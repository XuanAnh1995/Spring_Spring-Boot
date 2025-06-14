package com.luuviet.superapp.entity.unione;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Student")
public class Student {

    @Id
    @Column(name = "Id", columnDefinition = "CHAR(8)")
    private String id;

    @Column(name = "Name", columnDefinition = "NVARCHAR(50)", nullable = false)
    private String name;

    @Column(name = "Yob", nullable = false)
    private int yob;

    @Column(name = "Gpa")
    private double gpa;

    // private String majorId;  // Khóa ngoại đó thây !!! ĂN ĐÒN
    // NGHĨ THEO STYLE TABLE/CSDL -> KO ĐÚNG, TƯ DUY OOP

    // NGHĨ ĐÚNG, TƯ DUY OOP, CÁC OBJECT CÓ MỐI QUAN HỆ
    // TUI STUDENT THAM CHIẾU ĐẾN THÔNG TIN MAJOR-OBJECT
    // CÓ CÁCH CONVERT TỪ OOP THÀNH TABLE/ FK, JOIN COLUMN ->ORM MAPPING
    // CẦN 1 THẰNG GIÚP ÁNH XẠ 2 THẾ GIỚI ĐỂ CHO TƯƠNG THÍCH : JPA/ HIBERNATE
    // private Major major;

    public Student() {
    }

    public Student(String id, String name, int yob, double gpa) {
        this.id = id;
        this.name = name;
        this.yob = yob;
        this.gpa = gpa;
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

    public int getYob() {
        return yob;
    }

    public void setYob(int yob) {
        this.yob = yob;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", yob=" + yob +
                ", gpa=" + gpa +
                '}';
    }
}
