package com.luuviet.loosecoupling.di.v2setter;

public class UserService {

    private UserRepo userRepo;  // ko new chờ tiêm vô

    private EmailSender emailSender;    // ko new, chờ tiêm vô

    // setter tự generate hoặc tự gõ code

    public UserRepo getUserRepo() {
        return userRepo;
    }

    public void setUserRepo(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public EmailSender getEmailSender() {
        return emailSender;
    }

    public void setEmailSender(EmailSender emailSender) {
        this.emailSender = emailSender;
    }

    // CÁCH NÀY DỄ HIỂU LUÔN, NHƯNG GIÁ PHẢI TRẢ : NULL CHO DEPENDENCY NẾU KO GỌI SET()
    // NẾU QUA CONSTRUCTOR , BẠN KO ĐƯA VÀO CTOR, THÌ KO NEW ĐƯỢC, VÌ CTOR YÊU CẦU PHẢI ĐƯA THAM SỐ VÀO THÌ MỚI TRỌN VẸN VIỆC GỌI HÀM

    // Về mặt logic, chỗ này thay Account bằng AccountDto - Data Transfer Object
    public void registerAccount(Account account) {
        // trong acc có info email ... mình tự gửi cho email này
        // TODO: Logic code gọi CRUD của repo

        // confirm email
        emailSender.sendEmail("anhlvxPH47179@fpt.edu.vn", "... Please sign in to your account" );
    }
}
