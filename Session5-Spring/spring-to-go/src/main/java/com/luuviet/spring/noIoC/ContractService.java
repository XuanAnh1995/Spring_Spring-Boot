package com.luuviet.spring.noIoC;

public class ContractService {

    // Code chính và lo CRUD table Contract qua Repo
    // Sau đó sẽ generate pdf, Viện trợ nhờ PdfGenerator giúp
    // ---> PdfGenerator là Dependency và tự new ở đây, hoặc phải được truyền vào --- chích, tiêm vào

    private PdfGenerator pdfGenerator ;     // new là style tight coupling

    // tiêm , chích dependency qua constructor
    public ContractService(PdfGenerator pdfGenerator) {
        this.pdfGenerator = pdfGenerator;
    }

    public void processContract() {
        // TODO: LOGIC XỬ LÍ HỢP ĐỒNG ...

        // generate pdf
        pdfGenerator.generatePdf("contract 0001");
    }

}
