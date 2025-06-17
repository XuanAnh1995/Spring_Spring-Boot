package com.luuviet.spring.IoC.v4di.setterorfield;

import org.springframework.stereotype.Component;

@Component
public class PdfGenerator {

    public void generatePdf(String fileName) {
        // TODO: LOGIC XỬ LÍ GEN RA FILE PDF ...

        System.out.println("V3 DI IOC SETTER| FIELD -> The pdf file " + fileName + " has been generated successfully.");
    }
}
