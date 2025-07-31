package com.luuviet.coffee.ngoctrinhcoffee.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;

@Entity
@Table(name = "Account")
public class Account {  // POJO: PLAIN OLD JAVA OBJECT

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @Column(name = "Email", length = 100, unique = true, nullable = false)
    private String email;

    @Column(name = "Password", length = 30, unique = true, nullable = false)
    private String password;

    @Column(name = "Role", nullable = false)
    private int role;       // 1- ADMIN
                            // 2- STAFF
                            // 3- MEMBER

    //    @Column(name = "Active")
    //    private boolean active;   // true/false

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

    //    @Column(name = "FullName")
    //    private String fullName;

}
