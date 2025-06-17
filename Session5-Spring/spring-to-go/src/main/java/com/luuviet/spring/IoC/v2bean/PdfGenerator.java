package com.luuviet.spring.IoC.v2bean;

import org.springframework.stereotype.Component;

public class PdfGenerator implements DocumentGenerator{

    @Override
    public void generateDocument(String fileName) {
        // TODO: LOGIC XỬ LÍ GEN RA FILE PDF ...

        System.out.println("V2 -> The pdf file " + fileName + " has been generated successfully.");
    }
}
