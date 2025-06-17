package com.luuviet.spring.IoC.v1scan;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component  // @Component nghĩa là : đây là 1 obj, 1 bean , sẽ được tự động new bởi thư viện Spring , Spring Context
// @Service , @Repository cũng được luôn, 2 thằng này là con của @Component
public class PdfGenerator {

    public void generatePdf(String fileName) {
        // TODO: LOGIC XỬ LÍ GEN RA FILE PDF ...

        System.out.println("V1 -> The pdf file " + fileName + " has been generated successfully.");
    }
}
