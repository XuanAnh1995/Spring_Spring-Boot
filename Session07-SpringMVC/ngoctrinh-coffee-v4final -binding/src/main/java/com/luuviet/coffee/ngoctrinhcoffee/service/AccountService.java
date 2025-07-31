package com.luuviet.coffee.ngoctrinhcoffee.service;

import com.luuviet.coffee.ngoctrinhcoffee.entity.Account;
import com.luuviet.coffee.ngoctrinhcoffee.repository.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Autowired
    private AccountRepo accountRepo;

    public Account authenticate(String email, String password) {

        // nên where luôn repo email và pass hay ko?
        Account account = accountRepo.findByEmail(email);

        if (account == null) {
            return null;    // TODO: return DTO đặc biệt mang ý nghĩa 1 email ko tồn tại, tự tạo ngoại lệ và ném nó ra đại diện email ko tồn tại
        }

        if (!account.getPassword().equals(password)) {  // TODO: Decode PASSWORD
            return null;    // TODO : return DTO đặc biệt mang ý nghĩa sai pass , ném ngoại lệ Y
        }

        // if thêm account.getActive() == false

        // chặn luôn role = 3 với MEMBER
        if(account.getRole() == 3){
            return null;    // TODO: return DTO đặc biệt mang ý nghĩa MEMBER ko có quyền , ném ra ngoại lệ Z
        }

        return account;     // account với role = 1, 2

    }

    // DÀNH CHO CODE FIRST, VÀ DATA INITIALISER
    public void saveAccount(Account account) {
        accountRepo.save(account);
    }

}
