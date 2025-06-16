package com.luuviet.loosecoupling.di.v3finalfantasy;

public class WhatsAppSender implements NotiService{
    @Override
    public void sendNoti(String to, String message) {
        // Thông báo thành công
        System.out.println("(DI V3 - OCP) WHATSAPP was sent to " + to + " successfully !!! \n WHATSAPP message: " + message );
    }
}
