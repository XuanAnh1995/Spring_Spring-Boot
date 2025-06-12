package com.luuviet.superapp;

import com.luuviet.superapp.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        insertStudents();   // tạo bảng, chèn data qua OOP, CODE FIRST
        getAllStudents();   // select * from style OOP, CODE FIRST
    }

    // INSERT / TẠO MỚI SV
    public static void insertStudents(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.luuviet.superapp-PU");   // Gửi thông số cấu hình Server, nhà thầu JPA: Hibernate, nhà thầu JDBC cho JPA class lo để tạo kết nối tới CSDL cụ thể là SQL Server
        EntityManager em = emf.createEntityManager();
        // tạo ra 1 Object dùng để quản lý các entity class ~ map ngang sang table . Class Student chịu sự quản lý của em/EntityManager
        // em/EntityManager sẽ lo CRUD trên 1 table nào đó
        // qua mấy hàm huyền thoại: persit(), find(), merge(), remove()
        // TOÀN CHƠI OBJECT, ĐẰNG SAU LÀ TABLE BỊ ẢNH HƯỞNG - TỰ SINH SQL NGẦM, VÀ CHO MÌNH THẤY CÂU SQL NÀY LUÔN KHI MÌNH CHẤM CÁC HÀM Ơ TRÊN

        // chuẩn bị data Student - Object nha, OOP nha
        Student an = new Student("SE1", "AN NGUYỄN", 2004, 8.6);
        Student binh = new Student("SE2", "BÌNH LÊ", 2004, 8.7);
        Student cuong = new Student("SE3", "CƯỜNG VÕ", 2004, 8.7);

        // Gọi xếp EntityManager giúp CRUD
        em.getTransaction().begin();    // BẮT BUỘC PHẢI CÓ TRANSACTION KHI CÓ SỰ THAY ĐỔI TRONG DATABASE
        em.persist(an);     // CREATE TABLE DIỄN RA NGẦM
        em.persist(binh);   // GỌI LÀ CODE FIRST, CODE RA TABLE
        em.persist(cuong);  //                      CODE RA DATA
        em.getTransaction().commit();   // HOẶC CẢ 3 INSERT THÀNH CÔNG HOẶC CHƯA BẠN NÀO ĐƯỢC INSERT
        // SELECT KO CẦN, VÌ KO THAY ĐỔI TRẠNG THÁI TABLE
        em.close();     // Sa thải ô sếp vì đã xong
        emf.close();    // ngắt kết nối CSDL vì đã xong
    }

    // SELECT * ĐỂ LẤY HÊT DATA
    public static void getAllStudents(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.luuviet.superapp-PU");
        EntityManager em = emf.createEntityManager();
        List<Student> result = em.createQuery("FROM Student", Student.class).getResultList();
        System.out.println("The list of students is: ");
        for (Student student : result) {
            System.out.println(student);
        }

        // dùng biểu thức Lambda để in cùng được

        em.close();
        emf.close();
    }
}