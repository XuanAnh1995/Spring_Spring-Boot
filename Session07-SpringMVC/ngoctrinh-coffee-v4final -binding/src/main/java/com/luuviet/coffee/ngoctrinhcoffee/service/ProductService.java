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

    // search
    public List<Product> searchProductsByName(String keyword){
        return productRepo.searchAllByNameIsContainingIgnoreCase(keyword);
    }

    // HÀM KHÁC ... KIỂM TRA SỰ TỒN TẠI CỦA 1 ROW PRODUCT THEO ID
    // THAY VÌ TÌM 1 DÒNG, TRẢ LẠI NULL HAY DÒNG TÌM THẤY

    public boolean existsProductById(String id){
        return productRepo.existsById(id);
    }

}
