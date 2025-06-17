package com.luuviet.spring.IoC.v4di.setterorfield;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainV4 {

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        ContractService contractService = (ContractService) context.getBean("ngocTrinh");
        contractService.processContract();
    }

}
