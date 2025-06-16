package com.luuviet.loosecoupling.di.v1constructor;

public class MainDIV1 {

    public static void main(String[] args) {
        // MUỐN CÓ SERVICE , CẦN CO EMAIL-SENDER TRUYỀN VÀO
        EmailSender sender = new EmailSender();    // DEPENDENCY CHỦ ĐỘNG LỘ MẶT

        UserService service = new UserService(sender);  // CHÍNH TIÊM OBJ BÊN NGOÀI VÀO

        service.registerAccount(new Account());

        // MAIN CLASS CHỦ ĐỘNG TẠO OBJ CLASS B , DEPENDENCY , ĐƯA VÀO CLASS CHÍNH
        // THẰNG CHỨA, TẠO CÁC DEPENDENCY ĐƯỢC GỌI LÀ CONTAINER
        // CHỦ ĐỘNG TẠO DEPENDENCY, ĐƯA VÀO TRONG SERVICE CLASS CHÍNH A THÌ KỸ THUẬT NÀY CODE Ở TRÊN GỌI LÀ IoC, ĐẢO NGƯỢC LẠI VIỆC KIỂM SOA TẠO OBJ
        // SERVICE MẤT BỚT QUYỀN, TRAO QUYỀN, ĐẢO QUYỀN KIỂM SOÁT DEPENDENCY
        // Inversion of Control

        // BỮA SAU, SPRING, SPRING BOOT THAY MAIN, TẠO, KIỂM SOÁT, TIÊM CHÍCH DEPENDENCY CHO CLASS CHÍNH

        // 2 THẰNG SPRING, SPRING BOOT ĐƯỢC GỌI LÀ IOC CONTAINER
    }
}
