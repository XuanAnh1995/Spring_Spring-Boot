package com.luuviet.bookstore.bookmanager.config;


import com.luuviet.bookstore.bookmanager.entity.Account;
import com.luuviet.bookstore.bookmanager.entity.Book;
import com.luuviet.bookstore.bookmanager.entity.Category;
import com.luuviet.bookstore.bookmanager.service.AccountService;
import com.luuviet.bookstore.bookmanager.service.BookService;
import com.luuviet.bookstore.bookmanager.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private BookService bookService;

    @Autowired
    private AccountService accountService;

    @Autowired
    private CategoryService categoryService;


    @Override
    public void run(String... args) throws Exception {
        accountService.saveAccount(new Account("ad@az.com", "ad", 1));
        accountService.saveAccount(new Account("st@az.com", "st", 2));
        accountService.saveAccount(new Account("mb@az.com", "mb", 3));

        //TẠO OBJECT, NHỜ SERVICE ĐẨY XUỐNG
        //TẠO TABLE 1 TRƯỚC, N SAU (DO KHOÁ NGOẠI THAM CHIẾU KHOÁ CHÍNH)
        Category cate1 = new Category("Đam mĩ", "...");
        Category cate2 = new Category("Kĩ năng sống", "...");
        Category cate3 = new Category("Tuổi hồng", "...");

        //ta tạo dữ liệu book, mỗi book thì phải thuộc về cate nào đó
        cate1.addBook(new Book("Tashiro, Cậu Đúng Thật Là!", "Yamada", 10, BigDecimal.valueOf(98_000)));
        cate1.addBook(new Book("Tình Ta Đơm Hoa Giữa Hạ", "Kotaro", 10, BigDecimal.valueOf(76_000)));

        cate2.addBook(new Book("Tuổi Trẻ Đáng Giá Bao Nhiêu", "Rosie Nguyễn", 10, BigDecimal.valueOf(95_000)));
        cate2.addBook(new Book("Mình Là Nắng Việc Của Mình Là Chói Chang", "Kazuko Watanable", 10, BigDecimal.valueOf(76_000)));

        cate3.addBook(new Book("Tôi Thương Mà Em Đâu Có Hay", "Đoàn Thạch Biền", 10, BigDecimal.valueOf(50_000)));


        //xuống table hoy khi tomcat chạy, CASCADE ALL
        //NGHĨA LÀ TABLE 1 ĐI XUỐNG THÌ TABLE N XUỐNG LUÔN!!! VÀ LIST SÁCH BỊ DOMINO XUỐNG THEO LUÔN
        categoryService.saveCategory(cate1);
        categoryService.saveCategory(cate2);
        categoryService.saveCategory(cate3);

    }
}
