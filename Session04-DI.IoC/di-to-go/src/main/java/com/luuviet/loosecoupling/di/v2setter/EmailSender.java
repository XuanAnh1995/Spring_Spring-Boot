package com.luuviet.loosecoupling.di.v2setter;

public class EmailSender {

    // TỚ EMAIL-SENDER RẤT GIỎI VỤ GỬI EMAIL
    public void sendEmail(String recipient, String message) {
        // TODO: Logic XỬ LÝ GỬI EMAIL: SETUP ACCOUNT ĐỂ ĐÓNG VAI TRÒ NGƯỜI GỬI (FROM MÌNH GỬI- APP GỬI)
        // FORMAT EMAIL CHO PRO...

        // Thông báo thành công
        System.out.println("(DI V2 - Setter) Email was sent to " + recipient + " successfully !!! \n Email content: " + message );
    }

}
