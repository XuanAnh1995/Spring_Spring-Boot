package com.luuviet.loosecoupling.di.v3finalfantasy;

// TUI RA NHẬP HỘI NOTI , VẬY TUI PHẢI THEO QUY TẮC CỦA HỘI, CODE CHO HÀM ABSTRACT sendNoti
// VÀ MAY MẮN THAY TUI EMAIL-SENDER LÀ THÀNH VIÊN CỦA NOTI-SENDER , NAY TUI ĐƯỢC ĐÙNG
public class EmailSender implements NotiService{
    @Override
    public void sendNoti(String to, String message) {
        sendEmail(to, message);
    }

    // TỚ EMAIL-SENDER RẤT GIỎI VỤ GỬI EMAIL
    public void sendEmail(String recipient, String message) {
        // TODO: Logic XỬ LÝ GỬI EMAIL: SETUP ACCOUNT ĐỂ ĐÓNG VAI TRÒ NGƯỜI GỬI (FROM MÌNH GỬI- APP GỬI)
        // FORMAT EMAIL CHO PRO...

        // Thông báo thành công
        System.out.println("(DI V3 - Constructor) Email was sent to " + recipient + " successfully !!! \n Email content: " + message );
    }

}
