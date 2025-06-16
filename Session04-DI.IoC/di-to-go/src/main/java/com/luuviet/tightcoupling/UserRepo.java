package com.luuviet.tightcoupling;

public class UserRepo {

    // code chuyên biệt CRUD đúng 1 chủ thể , table Account
    // Nó thỏa SRP, nhiều hàm nhưng cũng chỉ là chơi 1 chủ thể, 1 table account
    // đóng vai trò dependency cho USER-SERVICE
    // vì thằng này giỏi việc xuống table
}
