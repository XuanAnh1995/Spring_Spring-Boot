package com.luuviet.spring.IoC.v1scan;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainV1 {

    public static void main(String[] args) {
        // KHỞI TẠO CONTAINER, THÙNG CHỨA OBJ, THÙNG CHỨA BEAN
        // VÀO SPRING RỒI ĐÓ EM
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        // context thuộc class ApplicationContext là TRÙM CUỐI quản lí các Obj, các BEAN, quản lí luôn việc tiêm vào
        // ĐỨA NÀO MUỐN ĐƯỢC TIÊM VÀO , ĐỨA ĐÓ CŨNG PHẢI LÀ BEAN
        // TRÙM CUỐI CONTEXT - CHƠI TRONG RAM
        // TRÙM CUỐI NÀY GIỐNG ENTITY-MANAGER-FACTORY ĐÃ HỌC - CHƠI VỚI DB

        // LẤY BEAN RA XÀI
        PdfGenerator pdfGenerator = (PdfGenerator) context.getBean("pdfGenerator");
        pdfGenerator.generatePdf("19:44");

        PdfGenerator pdfGenerator2 = context.getBean("pdfGenerator", PdfGenerator.class);
        pdfGenerator2.generatePdf("09:20");

        PdfGenerator pdfGenerator3 = context.getBean(PdfGenerator.class);
        pdfGenerator3.generatePdf("09:21");
    }
}
