package com.luuviet.bookstore.bookmanager.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "Book")
@EntityListeners(AuditingEntityListener.class)  // GHI NHẬN NGÀY THÁNG TỰ ĐỘNG
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id = 0L;

    @Column(name = "Name", nullable = false, columnDefinition = "NVARCHAR(50)")
    @NotBlank(message = "Name is required")
    @Size(min = 5, max = 50, message = "Name must be 5-50 characters")
    private String name;

    @Column(name = "AuthorName", nullable = false, columnDefinition = "NVARCHAR(50)")
    @NotBlank(message = "Author name is required")
    @Size(min = 5, max = 50, message = "Author name must be 5-50 characters")
    private String authorName;

    @Column(name = "Quantity", nullable = false)
    @NotNull(message = "Quantity is required")
    @Min(value = 1, message = "Quantity must be between 1 and 100")
    @Max(value = 100, message = "Quantity must be between 1 and 100")
    private int quantity;

    @Column(name = "Price", nullable = false)
    @NotNull(message = "Price is required")
    @Min(value = 1, message = "Price must be between 1 and 1M!")
    @Max(value = 1_000_000, message = "Price must be between 1 and 1M!")
    private BigDecimal price;

    @Column(name = "CreateAt")
    @CreatedDate
    private LocalDateTime createdAt;

    @ManyToOne()
    @JoinColumn(name = "CateId")
    private Category category;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Book() {
    }

    public Book(String name, String authorName, int quantity, BigDecimal price, LocalDateTime createdAt) {
        this.name = name;
        this.authorName = authorName;
        this.quantity = quantity;
        this.price = price;
        this.createdAt = createdAt;
    }

    public Book(String name, String authorName, int quantity, BigDecimal price) {
        this.name = name;
        this.authorName = authorName;
        this.quantity = quantity;
        this.price = price;
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

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
