package com.luuviet.superapp.entity.bidirectional;

import com.luuviet.superapp.infra.JpaUtil;
import jakarta.persistence.EntityManager;

import java.util.List;

public class MainBiOneMany {

    public static void main(String[] args) {
//        createStudentMajor();
//        getAllInfoWithSE();
//        getAllInfoWithGD();
        getAll();
    }

    private static void getAll() {
        EntityManager em = JpaUtil.getEntityManager();

        Long countMajor = em
                .createQuery("SELECT COUNT(m.id) FROM Major m", Long.class)
                .getSingleResult();
        System.out.println("Số lượng chuyên ngành: " + countMajor);

        Long countStudent = em
                .createQuery("SELECT COUNT(s.id) FROM Student s", Long.class)
                .getSingleResult();
        System.out.println("Số lượng sinh viên: " + countStudent);
    }


    // LÁY DANH SÁCH SINH VIÊN, DANH SÁCH CHUYÊN NGÀNH
    // EM ENTITYMANAGER CÓ HÀM LỢI HẠI .find(tên class, id) -> trả về duy nhất 1 dòng theo key
    //                                  .create(câu JPQL) -> TRẢ VỀ 1 LIST, LIST 1 DÒNG HAY NHIỀU DÒNG TÙY WHERE
    // VÌ OOP 2 CHIỀU NÊN KHI LẤY ĐƯỢC 1 MAJOR SE , KO CẦN WHERE GÌ NỮA , VÀO THẲNG LIST CỦA SE LÀ LẤY FULL STUDENT CỦA SE, TA LẤY QUA OBJECT MAJOR MÀ LẠI CÓ LIST STUDENT , VÌ MAJOR COS NHIỀU SINH VIÊN
    // THAY VÌ CHƠI TRỰC TIẾP TABLE STUDENT
    public static void getAllInfoWithSE(){
        EntityManager em = JpaUtil.getEntityManager();

        Major se = em.find(Major.class, "SE");
        System.out.println("SE major info: " + se.toString());

        List<Student> stuList = se.getStuList();    // ko lazy nữa
        // lazy ở chỗ nào: @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "major")
        System.out.println("Student list: " );
        stuList.forEach(nt -> System.out.println(nt.toString()));
    }

    public static void getAllInfoWithGD(){
        EntityManager em = JpaUtil.getEntityManager();
        Major GD = em.find(Major.class, "GD");
        System.out.println("GD major info: " + GD.toString());

        List<Student> stuList = GD.getStuList();
        System.out.println("Student list: " );
        stuList.forEach(nt -> System.out.println(nt.toString()));
    }


    public static void createStudentMajor() {
        Major se = new Major("SE", "Software Engineering | Kỹ thuật phần mềm ");
        Major gd = new Major("GD", "Graphics Design | Kỹ thuật số ");

        Student an = new Student("SE1000", "AN NGUYỄN", 2005, 8.6);
        Student binh = new Student("SE1001", "BÌNH LÊ", 2005, 8.7);
        Student cuong = new Student("GD1000", "CƯỜNG VÕ", 2005, 8.6);
        Student dung = new Student("GD1001", "DUNG PHẠM", 2005, 8.7);

        // kết nối chuyên ngành, style obj
        se.addStudent(an);
        se.addStudent(binh);
        gd.addStudent(cuong);
        gd.addStudent(dung);

        // mời giám đốc
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(se);     // đổ DOMINO
        em.persist(gd);
        em.getTransaction().commit();
        em.close();
    }
}
