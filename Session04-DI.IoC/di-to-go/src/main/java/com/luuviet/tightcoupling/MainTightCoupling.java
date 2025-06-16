package com.luuviet.tightcoupling;

public class MainTightCoupling {

    public static void main(String[] args) {
        // CLASS MAIN NÀY ĐÓNG VAI UI, CONTROLLER , GỌI VÀ ĐIỀU KHIỂN NHỮNG CLASS Ở TẦNG DƯỚI : SERVICE, REPO, JPAUTIL
        // SAU NÀY THAY BẰNG WEB PAG, GUI, ...

        UserService userService = new UserService();    // có sẵn trong lòng 2 dependency: Repo và SendEmail

        userService.registerAccount(new Account());
    }
}
