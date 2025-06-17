package com.luuviet.spring.IoC.v1scan;

// class này là nơi khai báo các object dependency của riêng ta
// và gửi cho Spring Container nó giữ
// cũng là nơi khai báo các thông tin về các dependency khác mà ta ko tự tạo , IoC hẳn, cho Spring lo giùm luôn
// Class này là nơi lưu giữ các thông tin về dependency mà ta nhờ Spring quản lí giùm
// Các Object dependency new PdfGenerator(), new ContractService(),new Repository() sẽ được khai báo và được quản lý ở class này và sau đó chuyển giao cho Spring !!!
// Những Object dependency kể từ nay về sau gọi là BEAN - Hạt đậu thần

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration  // @SpringBootApplication khi chơi với SpringBoot
@ComponentScan("com.luuviet.spring.IoC.v1scan")
//@ComponentScan(basePackages = {
//        "com.luuviet.spring.IoC.v1scan",
//        "com.luuviet.spring.noIoC"
//})
// scan tất cả cái package nào, coi class nào có @Component, @Service, @Repository, @Controller, @RestController, ...
// thì new chúng nó - gọi chúng nó là BEAN
public class AppConfig {

}
