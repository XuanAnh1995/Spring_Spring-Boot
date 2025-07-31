package com.luuviet.bookstore.bookmanager.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id = 0L;

    @Column(name = "Email", unique = true, nullable = false, columnDefinition = "VARCHAR(100)")
    private String email;

    @Column(name = "Password", nullable = false, columnDefinition = "NVARCHAR(30)")
    private String password;

//    @Enumerated(EnumType.STRING)
    @Column(name = "Role", nullable = false)
    private int role;   // Vai trò: ADMIN 1, STAFF 2, MEMBER 3

    public Account() {
    }

    public Account(String email, String password, int role) {
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }
}
