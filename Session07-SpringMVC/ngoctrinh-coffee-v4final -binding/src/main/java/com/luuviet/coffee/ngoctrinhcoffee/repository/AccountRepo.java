package com.luuviet.coffee.ngoctrinhcoffee.repository;

import com.luuviet.coffee.ngoctrinhcoffee.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepo extends JpaRepository<Account, Long> {


    Account findByEmail(String email);
}
