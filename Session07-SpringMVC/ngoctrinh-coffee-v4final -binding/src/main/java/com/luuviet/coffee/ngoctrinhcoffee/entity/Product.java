package com.luuviet.coffee.ngoctrinhcoffee.entity;

import jakarta.persistence.*;

@Entity
@Table(name ="Product")
public class Product {

    @Id
    @Column(name = "Id", columnDefinition = "CHAR(10)")
    private String id;

    @Column(name = "Name", columnDefinition = "NVARCHAR(50)", nullable = false)
    private String name;

    @Column(name = "Quantity", nullable = false)
    private int quantity;

    @Column(name = "Price", nullable = false)
    private double price;

    // MAPPING MỐI QUAN HỆ GIỮA CATEGORY-PRODUCT
    // 1, N PRODUCT BẤT KỲ PHẢI THUỘC VỀ 1 CATEGORY NÀO ĐÓ

    @ManyToOne
    @JoinColumn(name = "CategoryId")    // góc nhìn DB: cột FK trỏ sang table Category
    private Category category;  // góc nhìn OOP: biến này link sang Category nào đó!!!

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Product() {
    }

    public Product(String id, String name, int quantity, double price) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}
