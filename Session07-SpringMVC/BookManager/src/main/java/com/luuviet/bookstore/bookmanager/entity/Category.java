package com.luuviet.bookstore.bookmanager.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id = 0L;

    @Column(name = "Name", nullable = false, columnDefinition = "NVARCHAR(50)")
    private String name;

    @Column(name = "Description", columnDefinition = "NVARCHAR(100)")
    private String description;

    // MAPPING MỐI QUAN HỆ 1 - N
    // 1 CATE ---<-- CÓ NHIỀU BOOK, CHỨA List<Book>
    @OneToMany(
            mappedBy = "category",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<Book> bookList = new ArrayList<>();

    // Các hàm bổ sung thêm 1 cuốn sách vào category đang đứng, hay loại bỏ sách ra khỏi cate này (this)
    // list category này ban đầu là rỗng, chưa có cuốn sách nào, từ từ thêm bớt sách
    public void addBook(Book book) {
        bookList.add(book);
        book.setCategory(this);
    }

    public void removeBook(Book book) {
        bookList.remove(book);
        book.setCategory(null);
    }


    public Category() {}

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
}
