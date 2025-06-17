package com.luuviet.spring.IoC.v3di.constructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Contract;
import org.springframework.stereotype.Service;

@Service
public class ContractService {

    // TUI XỬ LÝ HỢP ĐỒNG LÀ VIỆC CHÍNH, THÊM GENERATE PDF, EXCEL -> XEM LẠI VIDEO
    // HỌC CÁCH ĐA HÌNH, INTERFACE, CHƠI VỚI FUTURE KO CẦN SỬA CODE - OCP OPEN CLOSED PRINCIPLE TRONG SOLID
    // CẦN 2 DEPENDENCY : REPO, GENERATOR (EXCEL, DOCUMENT GEN)

    public PdfGenerator pdfGenerator ;  // ko new nha, chờ tiêm tự động

    // tiêm vào , chích vào , new ở đâu ko càn biết - new IoC Container
    @Autowired  // chích , tiêm vào 1 bean khác qua constructor
    public void setPdfGenerator(PdfGenerator pdfGenerator) {
        this.pdfGenerator = pdfGenerator;
    }

    // xài dependency đc chích vào
    public void processContract() {
        // TODO: XỬ LÝ LOGIC HỢP ĐỒNG, REPO XUỐNG DATA

        // gen file
        pdfGenerator.generatePdf("11111111111111");
    }
}
