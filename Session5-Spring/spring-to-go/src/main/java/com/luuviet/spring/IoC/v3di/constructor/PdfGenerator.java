package com.luuviet.spring.IoC.v3di.constructor;

import org.springframework.stereotype.Component;

@Component  // tự new đi, vì ko trạng thái
public class PdfGenerator {

    public void generatePdf(String fileName) {
        // TODO: LOGIC XỬ LÍ GEN RA FILE PDF ...

        System.out.println("V3 DI IOC MLEM -> The pdf file " + fileName + " has been generated successfully.");
    }

}
