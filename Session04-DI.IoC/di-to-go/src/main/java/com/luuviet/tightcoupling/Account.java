package com.luuviet.tightcoupling;

import jakarta.persistence.Entity;

//@Entity
public class Account {
    // CHỨA INFO: id, name, address, email, phone, whatsapp, status, ...
    // rút lại những info cần thiết để dùng luân chuyển giữa các  tầng thì ta chế thêm 1 class DTO - Data Transfer Obj
    // Account --- đổ qua lai class 2 obj --- mapper --- AccountDto
}
