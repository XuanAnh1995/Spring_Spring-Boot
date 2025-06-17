package com.luuviet.spring.IoC.v3di.constructor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainV3 {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        // 2 bean à nhen: Service và Generator
//        ContractService service = context.getBean(ContractService.class);
        ContractService contractService = (ContractService) context.getBean("contractService");
        contractService.processContract();
    }

}
