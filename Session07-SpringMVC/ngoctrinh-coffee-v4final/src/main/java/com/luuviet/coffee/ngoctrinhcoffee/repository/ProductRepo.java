package com.luuviet.coffee.ngoctrinhcoffee.repository;

import com.luuviet.coffee.ngoctrinhcoffee.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product, String> {
}
