package com.luuviet.ngoctrinhcoffee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
// class này là class trung tâm, nơi chứa những khai báo về các bean có trong app này
// bean là những object dependency được IoC Container tự new, hay mình tự new và gửi cho Container giữ giùm
// Dependency object là những class có @Component, @Service, @Repository, @Controller, @RestController
// @SpringBootApplication gồm 3 @ khác
// @Configuration @ComponentScan  @EnableAutoConfiguration khởi động Tomcat, JPA/Hibernate, MVC - điều khiển request/response

//@ComponentScan("")
public class NgoctrinhCoffeeApplication {

	public static void main(String[] args) {
		SpringApplication.run(NgoctrinhCoffeeApplication.class, args);
	}

}
