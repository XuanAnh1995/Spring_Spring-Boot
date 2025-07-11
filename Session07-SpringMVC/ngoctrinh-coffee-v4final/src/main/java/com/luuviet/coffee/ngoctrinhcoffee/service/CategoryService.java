package com.luuviet.coffee.ngoctrinhcoffee.service;

import com.luuviet.coffee.ngoctrinhcoffee.entity.Category;
import com.luuviet.coffee.ngoctrinhcoffee.repository.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    // GUI, CONTROLLER --- SERVICE --- REPO --- SPRING JPA/HIBERNATE --- JDBC DRIVER --- TABLE

    // SERVICE LO CRUD TABLE TRONG RAM, LO LOGIC XỬ LÍ VỚI ENTITY/DTO
    // TÍNH VOUCHER, KHUYẾN MÃI, GỌI CỔNG THANH TOÁN, GỬI EMAIL,...
    // NẾU LO VIỆC CRUD TABLE THÌ PHẢI NHỜ VẢ REPO
    // BẢN CHẤT LÀ PHẢI KHAI BÁO REPO, NEW REPO(), GỌI HÀM REPO
    // NHƯNG REPO HIỆN NAY ĐANG LÀ INTERFACE, VÀ LÀ BEAN, CHO NÊN TA SẼ NHỜ IOC CONTAINER CHÍCH TIÊM VÀO SERVICE
    // VẬY SERVICE ĐƯỢC TIÊM REPO VÀO, VẬY SERVICE CŨNG PHẢI LÀ BEAN
    // @Component, @Service, @Controller, @Repository, @RestController

    @Autowired
    // có 1 đống hàm tự sinh cho CRUD Cate rồi nha - xài thoy- query method trong biến categoryRepo , chầm thoy, mặn mà luôn
    private CategoryRepo categoryRepo;

    // tiêm qua constructor
    // ko cần @Autowired nếu class chỉ có 1 tham số


    public CategoryService(CategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    // CRUD TRUYỀN THỐNG, GỌI HÀM DERIVED QUERY METHODS TỰ SINH CỦA THẰNG REPO
    public void saveCategory(Category category) {
        categoryRepo.save(category);
    }

    public List<Category> getAllCategories(){
        return categoryRepo.findAll();
    }

}
