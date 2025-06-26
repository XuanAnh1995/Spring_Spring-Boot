package com.luuviet.coffee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
//@Configuration
//@ComponentScan() scan ngay những class trong .coffee folder/package
// mà có chứa @Component , @Service, @Repository, @RestController, @Controller
// new những đứa này, chích/tiêm chúng vào những class tương ứng ...
//@EnableAutoConfiguration : tự new, tự cấu hình : JPA/Hibernate, Tomcat, MVC, ...
//@ComponentScan("ngoctrinh")
public class JavaCoffeeApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaCoffeeApplication.class, args);
    }

    // @Bean ở đây để chủ động new riêng những dependency , new xong gửi cho IoC Container quản lí giùm
}
