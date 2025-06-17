package com.luuviet.spring.noIoC;

public class MainNoIoC {

    // ĐÓNG VAI TRÒ NƠI TẠO RA OBJ , TẠO RA DEPENDENCY, TIÊM CHÍCH VÀO OBJ CHÍNH
    // IoC Container - Inversion of Control Container
    // em kiểm soát những đứa phụ thuộc, em chích tiêm chúng vào cho anh
    // IoC HANDMADE TỰ TRỒNG, CHƯA PHẢI HÀNG XỊN ĐẾN TỪ SPRING

    public static void main(String[] args) {
        PdfGenerator pdfGenerator = new PdfGenerator();

        ContractService contractService = new ContractService(pdfGenerator);

        contractService.processContract();
    }
}
