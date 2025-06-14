package com.luuviet.superapp.entity.unimany;

import com.luuviet.superapp.infra.JpaUtil;
import jakarta.persistence.EntityManager;

public class MainUniMany {

    public static void main(String[] args) {
        createStudentsMajor();
    }

    public static void createStudentsMajor() {
        Major seMajor = new Major("SE", "SOFTWARE ENGINEERING | KĨ THUẬT PHẦN MỀM");

        Student an = new Student("SE100", "AN NGUYỄN", 2006, 8.6);
        Student binh = new Student("SE101", "BÌNH LÊ", 2006, 8.7);

        an.setMajor(seMajor);
        binh.setMajor(seMajor);

        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(seMajor);
        em.persist(an);
        em.persist(binh);
        em.getTransaction().commit();

    }
}
