package com.luuviet.springboot;

import org.springframework.stereotype.Component;

//@Component
public class ExcelGenerator {

    public void generateFile(String fileName) {
        System.out.println("Spring Boot: the file " + fileName + " generate success!!!");
    }
}
