package com.luuviet.loosecoupling.di.v2setter;

public class MainDIV2 {

    public static void main(String[] args) {

        // DEPENDENCY ĐÃ LỘ DIỆN RA NGOÀI QUA SETTER, NHÀ MÌNH CẦN BÁC THỢ Ở NƠI KHÁC ĐẾNGIIUPSP, CHÍCH/ TIÊM DEPENDENCY VÀO QUA SETTER
        EmailSender emailSender = new EmailSender();
        UserService userService = new UserService();
        userService.setEmailSender(emailSender);
        userService.registerAccount(new Account());
    }
}
