package com.luuviet.spring.noIoC;

public class PdfGenerator {

    // CLASS NÀY CHUYÊN LO VIỆC GENERATE RA PDF - SRP SINGLE RESPONSIBILITY PRINCIPLE
    // LÀM GIẢ HÀM generateFile() ko làm thật vì tốn thời gian, ngoài scope
    // giả nhưng chạy được, gọi là Mock

    public void generatePdf(String fileName) {
        // TODO: LOGIC XỬ LÍ GEN RA FILE PDF ...

        System.out.println("The pdf file " + fileName + " has been generated successfully.");
    }
}
