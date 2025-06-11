package com.luuviet.superapp.entity;


// CLASS NÀY SẼ ĐƯỢC KHAI BÁO
// ÁNH XẠ/ BIẾN ĐỔI TƯƠNG ĐƯƠNG, ĐƯỢC MAP THÀNH TABLE TƯƠNG ỨNG

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Student")    // Nếu không có khai báo này, mặc định lấy tên class thành tên table !!!
public class Student {

    @Id
    @Column(name = "Id")    // nếu ko có khai báo này , thì mặc định lấy tên field làm tên cột
    private String id;   // camelCase, id tự nhập (id tự tăng tính sau)

    @Column(name = "Name", nullable = false, length = 50)
    private String name;

    @Column(name = "Yob", nullable = false)
    private int yob;

    @Column(name = "Gpa")
    private double gpa;

    // BẮT BUỘC PHẢI CÓ CONSTRUCTOR RỖNG, CONSTRUCTOR FULL THAM SỐ
    // GET, SET, TOSTRING


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
