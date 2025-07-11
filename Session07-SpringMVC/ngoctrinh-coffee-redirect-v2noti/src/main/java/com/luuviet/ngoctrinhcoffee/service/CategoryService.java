package com.luuviet.ngoctrinhcoffee.service;

import com.luuviet.ngoctrinhcoffee.entity.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    // hard-code danh sách
    public List<Category> getCategories() {
        List<Category> categories = List.of(
                new Category(100L, "Trà sữa", "..."),
                new Category(200L, "Cà phê", "..."),
                new Category(300L, "Beer - Nước ngọt", "..."),
                new Category(400L, "Bánh kẹo", "...")

        );
        return categories;
    }

}
