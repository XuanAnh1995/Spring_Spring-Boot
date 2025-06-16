package com.luuviet.loosecoupling.di.v1constructor;

public class EmailSender {

    // TỚ EMAIL-SENDER RẤT GIỎI VỤ GỬI EMAIL
    public void sendEmail(String recipient, String message) {
        // TODO: Logic XỬ LÝ GỬI EMAIL: SETUP ACCOUNT ĐỂ ĐÓNG VAI TRÒ NGƯỜI GỬI (FROM MÌNH GỬI- APP GỬI)
        // FORMAT EMAIL CHO PRO...

        // Thông báo thành công
        System.out.println("DI Email was sent to " + recipient + " successfully " );
    }
}
