package com.luuviet.coffee.ngoctrinhcoffee.config;


import com.luuviet.coffee.ngoctrinhcoffee.entity.Account;
import com.luuviet.coffee.ngoctrinhcoffee.entity.Category;
import com.luuviet.coffee.ngoctrinhcoffee.entity.Product;
import com.luuviet.coffee.ngoctrinhcoffee.service.AccountService;
import com.luuviet.coffee.ngoctrinhcoffee.service.CategoryService;
import com.luuviet.coffee.ngoctrinhcoffee.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

// TỰ CHẠY 1 LẦN DUY NHẤT KHI TOMCAT ĐƯỢC CHẠY, IOC CONTAINER CHẠY , DÙNG ĐỂ TẠO TABLE, TẠO SẴN DATA TRONG TABLE
@Component  // mày phải là 1 bean mới được gọi
public class DataInitializer implements CommandLineRunner {

    // nhờ vả 3 Service giúp xuống tạo table, chèn sẵn Data
    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProductService productService;

    @Autowired
    private AccountService accountService;

    @Override
    public void run(String... args) throws Exception {
        accountService.saveAccount(new Account("ad@a.com", "ad", 1));
        accountService.saveAccount(new Account("st@a.com", "st", 2));
        accountService.saveAccount(new Account("mb@a.com", "mb", 3));

        // TẠO OBJECT, NHỜ SERVICE ĐẨY XUỐNG
        // TẠO TABLE 1 TRƯỚC, N SAU (DO KHÓA NGOẠI THAM CHIẾU KHÓA CHÍNH)
        Category category1 = new Category("Trà Sữa", "Uống trà sữa, hoài nghi pass môn này");
        Category category2 = new Category("Cà Phê", "Uống cà phê Java top server 100");
        Category category3 = new Category("Beer-tăng-lực", "Uống bia trộn Java thì shock code thăng hoa");
        Category category4 = new Category("Bánh kẹo", "Đời ngọt ngào mướt mượt như Ngọc Trinh");

        Product p1c1 = new Product("TS01", "Trà Sữa Hàng Xóm Nấu", 79, 39_000);
        Product p2c1 = new Product("TS02", "Trà Sữa Ngọc Trinh Nấu", 79, 68_000);

        category1.addProduct(p1c1);
        category1.addProduct(p2c1);

        Product p1c2 = new Product("CP01", "Cafe Nguyên Bản Vị Java", 79, 5_700_000);
        Product p2c2 = new Product("CP02", "Cafe Vị Ngọc Trinh Nấu", 79, 2_350_000);
        Product p3c2 = new Product("CP03", "Cafe Vị Java Đậm Đà Vị Ngọc Trinh", 6789, 52_000_000);

        category2.addProduct(p1c2);
        category2.addProduct(p2c2);
        category2.addProduct(p3c2);

        // xuống table thôi khi tomcat được chạy, CASCADE ALL
        // NGHĨA LÀ TABLE 1 ĐI XUỐNG, TABLE N ĐI XUỐNG LUÔN
        categoryService.saveCategory(category1);
        categoryService.saveCategory(category2);
        categoryService.saveCategory(category3);
        categoryService.saveCategory(category4);



    }
}
