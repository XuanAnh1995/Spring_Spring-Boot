package com.luuviet.spring.IoC.v4di.setterorfield;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service("ngocTrinh")
public class ContractService {

    @Autowired  // Spring chơi trò Reflection
    private PdfGenerator pdfGenerator;

    // CHƠI SETTER BẮT BUỘC PHẢI CÓ @Autowired VÌ NÓ LÀ HÀM THƯỜNG , ĐÂU BỊ ÉP PHẢI GỌI NGAY LÚC TẠO OBJ, DO ĐÓ KHIẾN DEPENDENCY BỊ NULL
    // GIANG HỒ HAY CHỌN: CHÍCH/ TIÊM QUA CONSTRUCTOR , KHỞI TẠO NGAY LÚC TẠO OBJ, SET() MANG Ý NGHĨA CHỈNH SỬA SAU NÀY
//    @Autowired
//    public void setPdfGenerator(PdfGenerator pdfGenerator) {
//        this.pdfGenerator = pdfGenerator;
//    }
    // null problem may be

    public void processContract() {
        // TODO: LOGIC XỬ LÝ HỢP ĐỒNG

        // generate file
        pdfGenerator.generatePdf(LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
    }

}
