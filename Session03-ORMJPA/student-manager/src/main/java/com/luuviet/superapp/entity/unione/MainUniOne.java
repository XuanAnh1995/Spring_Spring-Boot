package com.luuviet.superapp.entity.unione;

import com.luuviet.superapp.infra.JpaUtil;
import jakarta.persistence.EntityManager;

public class MainUniOne {

    // NHỜ VẢ JPAUTIL , CÓ HÀM ĐOC FILE PERSISTENCE.XML ĐỂ KẾT NỐI ĐÚNG CSDL, DÙNG DRIVER , VÀ GIÚP TẠO RA ÔNG QUẢN LÝ ENTITY MANAGER
    public static void main(String[] args) {
        createMajorStudents();
    }

    public static void createMajorStudents() {
        // ta tạo chuyên ngành SE, và 2 sinh viên chuyên ngành này
        Major seMajor = new Major("SE", "SOFTWARE ENGINEERING | KĨ THUẬT PHẦN MỀM");
        Student s1 = new Student("SE100", "AN NGUYỄN", 2006, 8.6);
        Student s2 = new Student("SE101", "BÌNH LÊ", 2006, 8.7);

        // seMajor cần phải add 2 Student s1 , s2 vào cái list
        // Làm sao add students
        seMajor.addStudent(s1);
        seMajor.addStudent(s2);
        // OOP ĐÃ XONG, VỀ RELATIONSHIP
        // XUỐNG TABLE , ĐỔ DOMINO-CASCADE 1 MAJOR , N STUDENT XUỐNG LUÔN THEO
        // ONE ĐI XUỐNG, MANY ĐI THEO!!!!!!!!!
        // NHỜ JPAUTIL CHUẨN BỊ NHÀ XƯỞNG, MỜI GIÁM ĐỐC VỀ QUẢN LÍ

        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(seMajor);    // Major đi xuống, 2 Student đi theo sau !!!
        em.getTransaction().commit();
        em.close();
    }
}
