package com.luuviet.loosecoupling.di.v3finalfantasy;

// TỚ SmsSender RẤT GIỎI VỤ GỬI SMS - NGUYÊN LÝ SRP
// SINGLE RESPONSIBILITY PRINCIPLE
public class SmsSender implements NotiService{

    public void sendSMS(String phone, String message) {
        // TODO: Logic XỬ LÝ GỬI SMS: SETUP ACCOUNT ĐỂ ĐÓNG VAI TRÒ NGƯỜI GỬI (FROM MÌNH GỬI- APP GỬI)
        // FORMAT SMS CHO PRO...

        // Thông báo thành công
        System.out.println("(DI V3 - Setter) SMS was sent to " + phone + " successfully !!! \n SMS content: " + message );
    }

    @Override
    public void sendNoti(String to, String message) {
        sendSMS(to, message);
    }
}
