package com.luuviet.loosecoupling.di.v1constructor;

public class UserService {

    // SRP : TỚ GIỎI VỤ CRUD TABLE ACCOUNT TRONG RAM
    // TỚ CẦN 2 DEPENDENCY , MỖI THẰNG LO 1 VIỆC
    // USER-REPO VÀ EMAIL-SENDER
    private UserRepo userRepo;  // có new hay ko, có là tight-coupling
    // lỏng ra, đó là DI @Autowire NGHĨA LÀ DI, NGHĨA LÀ KO FULL CONTROL

//    private EmailSender emailSender = new EmailSender(); full control , ko DI

    //@Autowire
    private EmailSender emailSender;    // KO NEW THÌ PHẢI ĐƯỢC ĐƯA VÀO

    // CÓ NHIỀU CÁCH ĐƯA OBJ TỪ NGOÀI VÀO TRONG 1 CLASS
    // 1. TRỰC TIẾP QUA FIELD , BIẾN emailSender THÀNH PUBLIC - NGUY HIỂM VI PHẠM ENCAPSULATION , VẪN MUỐN QUA FIELD VÀ PRIVATE - DÙNG KỸ THUẬT NÂNG CAO REFLECTION!!!
    // FIELD INJECTION (DŨNG REFLECTION , IoC FRAMEWORK)

    // 2. TRUYỀN VÀO QUA CONSTRUCTOR !!! MLEM NHẤT
    // TẠO OBJ CHÍNH MÌNH QUA CONSTRUCTOR VÀ NHẬN THÊM ĐỒ QUA THAM SỐ CONSTRUCTOR
    // OBJ DEPENDENCY ĐI QUA, ĐƯA QUA CONSTRUCTOR

    // 3. SETTER - TRUYỀN QUA HÀM SET() NHƯNG NẾU LƯỜI KO GỌI SET() THÌ DEPENDENCY BỊ NULL

    // 4. DÙNG FRAMEWORK / THƯ VIỆN BÊN NGOÀI TỰ KIỂM SOÁT VIỆC TẠO OBJ DEPENDENCY VÀ TIÊM CHÍCH VÀO : SPRING/SPRINGBOOT!!!

    // CHÍCH/ TIÊM 2 THẰNG DEPENDENCY TỪ NGOÀI VÀO TRONG MÌNH SERVICE QUA CONSTRUCTOR GÁN VÀO
    public UserService(UserRepo userRepo, EmailSender emailSender) {
        this.userRepo = userRepo;
        this.emailSender = emailSender;
    }

    public UserService(EmailSender emailSender) {
        this.emailSender = emailSender;
    }

    public void registerAccount(Account account) {
        // TODO: DÙNG REPO XUỐNG TABLE

        // GỬI EMAIL THÔI
        emailSender.sendEmail("anhlvxPH47179@fpt.edu.vn", "... Please sign in to your account" );
    }
}
