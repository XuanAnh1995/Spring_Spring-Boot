package com.luuviet.spring.IoC.v2bean;

public class ExcelGenerator implements DocumentGenerator{

    @Override
    public void generateDocument(String fileName) {
        // TODO: LOGIC XỬ LÍ GEN RA FILE EXCEL ...

        System.out.println("V2 -> The EXCEL file " + fileName + " has been generated successfully.");
    }

}
