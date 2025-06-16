package com.luuviet.loosecoupling.di.v3finalfantasy;

public class MainDIV3 {

    public static void main(String[] args) {
        // Gửi email confirm khi đăng kí
        EmailSender emailSender = new EmailSender();

        // DÙNG SERVICE
        UserService userService = new UserService(emailSender);

        userService.registerAccount("luuvietxuananh95@gmail.com", "LƯU VIỆT XUÂN ÁNH");

        // tui muốn gửi qua SMS
        SmsSender smsSender = new SmsSender();

        // CHÍCH VÀO SERVICE TRÊN QUA SET, KO NEW SERVICE MỚI
        userService.setNotiService(smsSender);
        userService.registerAccount("0988987071", "LƯU VIỆT XUÂN ÁNH");

        // Tui muốn gửi qua Whatsapp
        WhatsAppSender whatsAppSender = new WhatsAppSender();

        // CHÍCH VÀO SERVICE TRÊN QUA SET, KO NEW SERVICE MỚI
        userService.setNotiService(whatsAppSender);
        userService.registerAccount("0988987071", "LƯU VIỆT XUÂN ÁNH");

        // TUYỆT ĐỈNH KUNGFU
        // GỬI TIN NHẮN QUA TELEGRAM, DISCORD !!!
        // THƯỜNG : CODE THÊM CLASS LẺ: CONCRETE CLASS VÀ IMPLEMENT NOTI-SERVICE
        // PRO: CLASS ON THE GO, TAKE AWAY, ANONYMOUS CLASS
        // NEW LUÔN INTERFACE , ĂN ĐÒN, HOẶC IMPLEMENT NGAY CODE NGAY LÚC NEW INTERFACE!!!
        NotiService tele = new NotiService() {
            @Override
            public void sendNoti(String to, String message) {
                // Thông báo thành công
                System.out.println("(DI V3 - Setter) Telegram was sent to " + to + " successfully !!! \n Telegram content: " + message );
            }
        };
        userService.setNotiService(tele);
        userService.registerAccount("012345678", "HÀ NỘI");
    }

}
