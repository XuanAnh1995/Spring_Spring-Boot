package com.luuviet.superapp.entity.unione;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Major")
public class Major {

    @Id
    @Column(name = "Id", columnDefinition = "CHAR(2)")
    private String id;  // mã chuyên ngành

    @Column(name = "Name", nullable = false, columnDefinition = "NVARCHAR(100)")
    private String name;    // tên chuyên ngành

    public Major() {
    }

    public Major(String id, String name) {
        this.id = id;
        this.name = name;
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

    @Override
    public String toString() {
        return "Major{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    // CÂU TRONG CSDL, CÂU TRONG ĐỜI THƯỜNG: 1 MAJOR CÓ NHIỀU STUDENT
    // MUỐN LƯU NHIỀU INFO , LIST/ ARRAYLIST THẲNG TIẾN, OBJECT NÀY THAM CHIẾU THÔNG TIN OBJECT KIA
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)  // nhờ câu này bảng -/ table Student xuất hiện và nó đòi FK/ Join Column
    @JoinColumn(name = "MajorId")   // tự tạo bên table Many Student 1 cột FK tên là MajorId
    private List<Student> students = new ArrayList<Student>();
    // để có cụ thể sv nào, ta gọi students.add(1 bạn sv đc new đâu đó)
    //                              students.add(new Student())
    // add 1 phần tử vào trong ArrayList

    // HÀM ADD STUDENT VÀO LIST, PUBLIC
    public void addStudent(Student obj) {
        // if else logic kiểm soát info bên ngoài đi vào object
        students.add(obj);
    }
}
