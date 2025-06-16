package com.luuviet.loosecoupling.di.v3finalfantasy;

public class UserService {

    private UserRepo userRepo;  // ko new, chờ chích/ tiêm vào

//    private EmailSender emailSender;    // ko new, chờ chích/ tiêm vào
//
//    private SmsSender smsSender;    // ko new, chờ chích/ tiêm vào
//
//    private WhatsAppSender whatsAppSender;  // ko new, chờ chích/ tiêm vào

    // KHAI BÁO SmsSender, EmailSender đang gọi khai báo cứng cái dependency
    // KO TỐT CHO TƯƠNG LAI
    // KO LÊN PHỤ THUỘC  VÀO CÁI CỤ THỂ Ở TRÊN, TA LÊN PHỤ THUỘC VÀO CÁI CHUNG CHUNG ĐỂ SAU NÀY CÒN DỄ BỔ SUNG CÁC HÌNH THỨC KHÁC MÀ KO THÊM SỬA CODE CỦA CHÍNH CLASS SERVICE

    private NotiService notiService;
    // ko new, chờ chích/ tiêm vào
    // nói chung chung là phụ thuộc vào cái đám gửi info nhưng ko nói đứa nào , SmS hay Email hay ...
    // NHƯNG CHẮC CHẮN 1 ĐIỀU, Obj  noti CHẮC CHẮN CÓ HÀM sendNoti()
    // code thế nào, từ từ tính

    // CHÍCH VÀO HOY, QUA FIELD , CONSTRUCTOR , VÀ SETTER TÙY CHỌN NHƯNG CTOR LÀ OKE NHẤT
    public UserService(UserRepo userRepo, NotiService notiService) {
        this.userRepo = userRepo;
        this.notiService = notiService;
    }

    public UserService(NotiService notiService) {
        this.notiService = notiService;
    }   // BÀI NÀY TẬP TRUNG VÀO NOTI, TIÊM TỪ NGOÀI VÀO

    public void setNotiService(NotiService notiService) {
        this.notiService = notiService;
    }

    // GỬI NOTI HOY, KO DÁM NÓI GỬI MAIL, SMS, WHATSAPP
    public void registerAccount(Account account) {
        // LOGIC CODE GỌI REPO ĐỂ CRUD TABLE

        // GỬI NOTI
//        notiService.sendNoti(to???, message???);
    }

    public void registerAccount(String to, String message) {
        // LOGIC CODE GỌI REPO ĐỂ CRUD TABLE

        // GỬI NOTI KO BIẾT CHÍNH XÁC LÀ DỊCH VỤ NÀO GỬI : SMS, MAIL, WHATSAPP
        notiService.sendNoti(to, message);
    }



}
