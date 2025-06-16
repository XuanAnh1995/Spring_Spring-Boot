package com.luuviet.tightcoupling;

// CLASS CHÍNH LÀ ĐÂY
// GUI --- CONTROLLER --- SERVICE --- REPO (JPAUTIL) --- TABLE
public class UserService {

    // CÓ ÍT NHẤT 2 DEPENDENCY SERVICE NÓ CẦN
    // 1. USER-REPO GIÚP CRUD TABLE ACCOUNT
    // 2. GỬI EMAIL/SMS/WHATSAPP CONFIRM

    private UserRepo userRepo = new UserRepo();     // dependency, tight coupling, chủ động quản lý OBJ DEPENDENCY

    private EmailSender emailSender = new EmailSender();    // dependency, tight coupling, chủ động tạo obj trong lòng !!!
    // new Service , có 2 chú này được new luôn
    // hard-code dependency , cứng dependency vào đây
    // full-control , direct-control dependency : tự khai báo, tự new!!!
    // vấn đề: sau này nâng cấp và sửa code class chính này!!!

    // CÓ NHIỀU HÀM LIN QUAN ĐẾN TABLE USER:
    // getAllAccounts()     findByEmail()   findByPhone()   updateAccount()
    // nhận full info Account từ web form đăng k, hoặc nhận vào Dto
    // chứa email, phone, whatsapp id
    public void registerAccount(Account account) {
        // TODO: gọi Repo để xuống TABLE !!! XÀI DEPENDENCY 1

        // GỬI EMAIL CONFIRM - XÀI DEPENDENCY 2
        emailSender.sendEmail("luuvietxuananh95@gmail.com", "... Please input the OTP ...");
    }

    // Class A: Class Service, xài class B , chủ động new luôn ---> Tight Coupling
    // Class B: Class EmailSender --- dependency của A
}
