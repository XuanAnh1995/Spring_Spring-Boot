package com.luuviet.coffee.ngoctrinhcoffee.service;


import com.luuviet.coffee.ngoctrinhcoffee.entity.Product;
import com.luuviet.coffee.ngoctrinhcoffee.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    public List<Product> getAllProducts(){
        return productRepo.findAll();
    }

    public Product getProductById(String id){
        return productRepo.findById(id).get();
    }

    public void addProduct(Product product){
        productRepo.save(product);
    }

    public void updateProduct(Product product){
        if(productRepo.existsById(product.getId())){
            productRepo.save(product);
        } else {
            System.out.println("Product not found");
        }
    }

    public void deleteProduct(Product product){
        productRepo.delete(product);
    }

}
