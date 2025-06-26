package com.luuviet.superapp.repository;

import com.luuviet.superapp.entity.Student;
import com.luuviet.superapp.infra.JpaUtil;
import jakarta.persistence.EntityManager;

import java.util.List;

public class StudentRepository {

    // CLASS NÀY SẼ CHỨA CÁC HÀM CRUD TRỰC TIẾP TABLE STUDENT
    // MUỐN CRUD TABLE THÌ PHẢI NHỜ VẢ ÔNG ENTITY-MANAGER ĐƯỢC CUNG CẤP TỪ JpaUtil SINGLETON

    // FLOW: UI --- SERVICE --- REPOSITORY --- JpaUtil --- DATABASE

    // CÁC HÀM CURD Ở ĐÂY THƯỜNG ĐẶT TÊN NGẮN GỌN, HƯỜNG HÀNH ĐỘNG GIỐNG NHƯ LỆNH SQL CHUẨN (INSERT, UPDATE, DELETE)
    // TÊN HÀM GỢI Ý: save()  update()  delete() remove() find() findAll() findById()
    // DÙNG TRANSACTION KHI THAY ĐỔI DATA TABLE

    // HÀM INSERT XUỐNG TABLE
    public void save(Student obj) {
        // Gọi em EntityManager nhờ giúp ; kèm TRANSACTION
        EntityManager em = JpaUtil.getEntityManager();  // đoạn lệnh trôi nổi static {}
        // chạy duy nhất 1 lần , khởi động chạy heavy connection
        em.getTransaction().begin();
        em.persist(obj);
        em.getTransaction().commit();
        // try - catch khi save bị lỗi -- từ từ
        em.close();
    }

    // HÀM LẤY TẤT CẢ SINH VIÊN
    // JPQL SELECT s FROM Student s
    public List<Student> findAll() {
        EntityManager em = JpaUtil.getEntityManager();
        List<Student> list = em.createQuery("SELECT s FROM Student s", Student.class).getResultList();
        em.close();
        return list;
    }

    // HÀM UPDATE
    public void update(Student obj) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        em.merge(obj);      // merge() nghĩa là tích hợp object đưa vào trong EM
        // EM sẽ ổ ngang, copy ngang obj vào TRONG obj ứng đối với dòng trong table
        // Nếu bạn cố tình đưa Obj mà key ko tồn tại trong table, sẽ insert mới
        em.getTransaction().commit();
        em.close();
    }

    // HÀM REMOVE
    public void delete(Student obj) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        em.remove(obj);
        em.getTransaction().commit();
        em.close();
    }

    public void deleleStudentById(String id) {
        EntityManager em = JpaUtil.getEntityManager();
        Student obj = em.find(Student.class, id);
        em.getTransaction().begin();
        em.remove(obj);
        em.getTransaction().commit();
        em.close();
    }

    //TODO AT HOME: LÀM THÊM HÀM WHERE THEO CỘT NÀO ĐÓ, findById() TRẢ VỀ 1 STUDENT

    public List<Student> findStudentsByOrthers(String name, Double gpa, Integer yob) {
        EntityManager em = JpaUtil.getEntityManager();
        List<Student> result = em
                .createQuery("SELECT s FROM Student s WHERE s.name LIKE :pName OR s.yob = :pYob OR s.gpa = :pGpa", Student.class)
                .setParameter("pName", "%" + name + "%")
                .setParameter("pYob", yob)
                .setParameter("pGpa", gpa)
                .getResultList();
        em.close();
        return result;
    }

    public Student findStudentById(String id) {
        EntityManager em = JpaUtil.getEntityManager();
        Student obj = em.find(Student.class, id);
        em.close();
        return obj;
    }


}
