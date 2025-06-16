package com.luuviet.tightcoupling;

public class EmailSender {

    // TUI, GÃ RẤT GIỎI CHUYÊN GỬI EMAIL, TUI KO DÍNH DÁNG G ĐẾN SMS, WHATSAPP
    //  TUI THỎA NGUYÊN LÍ S TRONG SOLID : SINGLE RESPONSIBILITY PRINCIPLE
    // TUI CHI CHỨA HÀM, NHIỀU HÀM CHUYÊN LIÊN QUAN ĐẾN EMAIL - 1 CHỦ THỂ
    // SAU NÀY NÂNG CẤP CODE , CHỈ LÀ XOAY QUANH EMAIL, 1 LÍ DO SỬA ĐỔI MÀ THÔI
    //                          to:                nội dung email
    // hàm này gửi email tới người đăng ký account, thông tin email nhập từ màn hình đăng ký, đi qua Controller đến Service đến đây !!!
    // email của user đăng ký nằm trong Account entity (đơn giản) , nằm trong AccountDto (bản cắt bớt từ field từ Entity)
    public void sendEmail(String recipient, String message) {
        // TODO: Logic XỬ LÝ GỬI EMAIL: SETUP ACCOUNT ĐỂ ĐÓNG VAI TRÒ NGƯỜI GỬI (FROM MÌNH GỬI- APP GỬI)
        // FORMAT EMAIL CHO PRO...

        // Thông báo thành công
        System.out.println("Email was sent to " + recipient + " successfully " );
    }
}
