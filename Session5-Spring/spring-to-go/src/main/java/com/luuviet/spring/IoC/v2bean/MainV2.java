package com.luuviet.spring.IoC.v2bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainV2 {

    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

//        PdfGenerator pdfGenerator = (PdfGenerator) ctx.getBean("pdfGenerator");
//        pdfGenerator.generatePdf("09:39");
//
//        PdfGenerator pdfGenerator2 = ctx.getBean("pdfGenerator", PdfGenerator.class);
//        pdfGenerator2.generatePdf("09:40");

//        PdfGenerator pdfGenerator3 = ctx.getBean(PdfGenerator.class);
//        pdfGenerator3.generatePdf("09:41");
//
//        PdfGenerator pdfGenerator4 = (PdfGenerator) ctx.getBean("ngocTrinh");
//        pdfGenerator4.generatePdf("09:39");
//
//        PdfGenerator pdfGenerator5 = ctx.getBean("ngocTrinh", PdfGenerator.class);
//        pdfGenerator5.generatePdf("09:40");

        PdfGenerator pdfGenerator = (PdfGenerator) ctx.getBean("pdfGenerator");
        pdfGenerator.generateDocument("10:08");

        ExcelGenerator excelGenerator = (ExcelGenerator) ctx.getBean("excelGenerator");
        excelGenerator.generateDocument("10:09");

        DocumentGenerator documentGenerator = ctx.getBean(DocumentGenerator.class);
        documentGenerator.generateDocument("10:10");

    }

}
