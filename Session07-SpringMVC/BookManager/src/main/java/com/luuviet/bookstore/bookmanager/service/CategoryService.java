package com.luuviet.bookstore.bookmanager.service;

import com.luuviet.bookstore.bookmanager.entity.Category;
import com.luuviet.bookstore.bookmanager.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public void saveCategory(Category category) {
        categoryRepository.save(category);
    }
}
