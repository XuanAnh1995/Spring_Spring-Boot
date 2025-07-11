package com.luuviet.coffee.ngoctrinhcoffee.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id")
    private Long id;

    @Column(name = "Name", columnDefinition = "NVARCHAR(50)", nullable = false)
    private String name;

    @Column(name = "Description", columnDefinition = "NVARCHAR(100)")
    private String description;

    // MAPPING MỐI QUAN HỆ : 1 CATEGORY CÓ NHIỀU PRODUCT
    @OneToMany(
            mappedBy = "category",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            orphanRemoval = true
    )

    private List<Product> listProducts = new ArrayList<Product>();

    // các hàm liên quan đến bổ sung product vào category, hay cho product ra khỏi category
    // list product của cate này ban đầu là rỗng, từ từ vào/ra
    public void addProduct(Product product) {
        listProducts.add(product);  // product bạn vào danh sách của category tớ
        product.setCategory(this);  // vế ngược lại, bạn product cũng phải flex rằng đã ghé tớ, thuộc về đội tớ
    }

    public void removeProduct(Product product) {
        listProducts.remove(product);
        product.setCategory(null);
    }

    public Category() {
    }

    public Category(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
