package com.luuviet.superapp;

import com.luuviet.superapp.entity.Lecturer;
import com.luuviet.superapp.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;
import java.util.Locale;

public class Main {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.luuviet.orm-PU");   // Gửi thông số cấu hình Server, nhà thầu JPA: Hibernate, nhà thầu JDBC cho JPA class lo để tạo kết nối tới CSDL cụ thể là SQL Server

    public static void main(String[] args) {
//        insertStudents();
        getAllStudents();
//        insertLecturers();
//        getAllLecturers();
//        searchLecturers();
//        findLecturerById();
//        removeById();
//        updateById();
        emf.close(); // Đóng factory một lần ở cuối
    }

    // EntityManager là ông sếp quản lý các Entity - chính là các class có @Entity  và quản lý các object tạo từ class Entity: sếp có thể thêm persist(); xóa remove(); cập nhật merge(); tìm theo PK find() : lí do có hàm tìm theo key, vì ta luôn có nhu cầu thao tác trên 1 dòng / row/ record cụ thể trong table
    // ngoài ra còn có hàm createQuery() tìm linh hoạt theo điều kiện nào đó

    // KHI LÀM CÁC HÀNH ĐỘNG XÓA, SỬA, THÊM ẢNH HƯỞNG VÀ THAY ĐỔI HIỆN TRẠNG DATABASE , TA PHẢI NHÉT NÓ VÀO TRANSACTION ĐỂ  THEO DÕI
    public static void updateById() {
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        Lecturer lecturer = em.find(Lecturer.class, 5);
        Student student = em.find(Student.class, "SE3");
        lecturer.setSalary(25_000_000);
        student.setGpa(9.2);
        em.getTransaction().commit();

        System.out.println("Lecturer info: " + lecturer);
        System.out.println("Student info: " + student);
        em.close();
    }

    public static void removeById() {
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        Lecturer lecturer = em.find(Lecturer.class, 1);
        Student student = em.find(Student.class, "SE2");
        em.remove(lecturer);
        em.remove(student);
        em.getTransaction().commit();

        System.out.println("Lecturer info: " + lecturer);
        System.out.println("Student info: " + student);
        em.close();
    }

    public static void findById() {
        EntityManager em = emf.createEntityManager();

        // Tìm theo key chỉ ra 1 dòng
        Lecturer lecturer = em.find(Lecturer.class, 1);     // GIÁ TRỊ PK MUỐN TÌM
        Student student = em.find(Student.class, "SE2");
        System.out.println(lecturer);
        System.out.println(student);
    }

    public static void insertLecturers() {
        // Lôi cổ ô sếp quản lý Entity ra để tạo table, chèn data vào table, Lecturer - option XML create , hay update đều mlem!!!
        // ĐI LÀM THẬT, CẤM CREATE TRÊN MÁY KHÁCH HÀNG, NẾU TA FIX BUG, UPDATE APP VÌ TOANG HẾT DATA KHÁCH HÀNG
        Lecturer an = new Lecturer("AN NGUYỄN", 1990, 20_000_000);
        Lecturer binh = new Lecturer("BÌNH LÊ", 1991, 20_000_001);
        EntityManager em = emf.createEntityManager();
        // VÌ CÓ THAY ĐỔI TRÊN CSDL, DATA NÊN TA CẦN THEO DÕI CHẶT CÁC CÂU LỆNH -> DÙNG TRANSACTION
        em.getTransaction().begin();
        em.persist(an);
        em.persist(binh);
        em.getTransaction().commit();

        em.close();
    }

    // HỌC THÊM VE JPQL : JAVA PERSISTENCE QUERY LANGUAGE
    // LÀ PHIÊN BẢN ĐỘ TỪ SQL NHƯNG DÀNH CHO THẾ GIỚI OOP, OBJECT
    // HIBERNATE CŨNG CÓ PHIÊN BẢN RIÊNG  CỦA NÓ NƯÃ GỌI LÀ HQL
    // SQL: SELECT * FROM Lecturer
    // JPQL: FROM Lecturer
    //      SELECT lec FROM Lecturer lec
    //                      với mỗi dòng/ record lấy từ table lecturer
    //                      ta new nó trong RAM, new lecturer() và gọi vùng new này là lec, tức là lec = new Lecturer()
    //                      và lặp lại cho toàn bộ record trong table Lecturer
    // ADD KẾT QUẢ ĐỌC TỪ TABLE VÀO KẾT QUẢ CUỐI CÙNG DÙNG LỆNH SELECT lec
    // SELECT lec tức là lấy từng Object lec được new từ từng dòng trong table Lecturer

    // WHERE
    // SQL: SELECT * FROM Lecturer WHERE Salary = 20.000.000
    // JPQL: SELECT x FROM Lecturer x WHERE x.salary = 20.000.000
    //                                          tên field trong class
    //              x là biến Object nhen !!! , ko phải cột trong table

    // QUERY ĐỘNG, THAM SỐ WHERE : TRUYỀN TỪ WEB / FORM -> ĐẾN ĐÂY CÓ 1 VALUE NÀO ĐÓ
    // JPQL: SELECT x FROM Lecturer x WHERE x.salary = :pSalary
    // CÓ QUYỀN DÙNG THÊM AND, OR NHƯ SQL CHUẨN
    // CÓ DÙNG TOÁN TỬ LIKE SO SÁNH GẦN ĐÚNG GIA TRỊ CHUỖI
    // SQL: SELECT * FROM Lecturer WHERE Name LIKE '%AN%'  -- tên chứa chữ AN đứng đâu cũng được
    //                                              '%AN' -- tên bắt đầu chứa chữ AN
    // JPQL: SELECT lec FROM Lecturer lec WHERE lec.name LIKE :pName
    // setParameter("pName", "%AN%")
    public static void searchLecturers() {
        EntityManager em = emf.createEntityManager();
//        List<Lecturer> result = em
//                .createQuery("SELECT x FROM Lecturer x WHERE x.salary = :pSalary", Lecturer.class)
//                .setParameter("pSalary", 20000000)
//                .getResultList();

//        List<Lecturer> result = em
//                .createQuery("SELECT x FROM Lecturer x WHERE x.yob = :pYob", Lecturer.class)
//                .setParameter("pYob", 1991)
//                .getResultList();

        List<Lecturer> result = em
                .createQuery("SELECT x FROM Lecturer x WHERE x.name LIKE :pName", Lecturer.class)
                .setParameter("pName", "%AN%")
                .getResultList();

        System.out.println("Found " + result.size() + " lecturer(s) in database have name AN ");
        for (Lecturer lecturer : result) {
            System.out.println(lecturer);
        }
        em.close();
    }


    public static void getAllLecturers() {
        EntityManager em = emf.createEntityManager();
        //  Viết câu SQL style Object, gọi là JPQL , HQL khá giống SQL truyền thống, nhưng làm việc , select, thao tác trên Object, trên cái class Entity chứ không quan tâm tên cột trong table như JDBC đã học
        List<Lecturer> list = em
                .createQuery("SELECT x FROM  Lecturer x WHERE x.salary = 20000000", Lecturer.class)
                .getResultList();
//        System.out.println("The list of Lecturers is: "+ list.size()+ " records");
//        for (Lecturer l : list) {
//            System.out.println(l);
//        }

        // BIỂU THỨC LAMBDA - LAMBDA EXPRESSION, DÍNH DÁNG CỰC KÌ CHẶT CHẼ VƠI STREAM-API , CƠ CHẾ XỬ LÝ NHIỀU DỮ LIỆU TRONG RAM
        // LAMBDA EXPRESSION LÀ HÀM VÔ DANH, HÀM ẨN DANH !!! HÀM KO CÓ TÊN
        // DÍNH ĐẾN KHÁI NIỆM LẬP TRÌNH HÀM - FUNCTIONAL PROGRAMMING
        // HÀM ĐƯỢC XEM LÀ 1 DATA , VÀ HÀM LÀ THAM SỐ ĐỂ TRUYỀN VÀO HÀM KHÁC
        System.out.println("The list of Lecturers printed by Lambda Expression:  ");
        list.forEach((x) -> {
            System.out.println(x);
        });

//        System.out.println("The list of numbers from 1 to 100");
//        list.forEach((x) -> {
//            for (int i = 0; i < 100; i++) {
//                System.out.print(i + " ");
//            }
//        });


        em.close();
    }

    // INSERT / TẠO MỚI SV
    public static void insertStudents() {
        EntityManager em = emf.createEntityManager();
        // tạo ra 1 Object dùng để quản lý các entity class ~ map ngang sang table . Class Student chịu sự quản lý của em/EntityManager
        // em/EntityManager sẽ lo CRUD trên 1 table nào đó
        // qua mấy hàm huyền thoại: persist(), find(), merge(), remove()
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
    }

    // SELECT * ĐỂ LẤY HÊT DATA
    public static void getAllStudents() {
        EntityManager em = emf.createEntityManager();
        List<Student> result = em
                .createQuery("SELECT stu FROM Student stu", Student.class)
                .getResultList();
        System.out.println("The list of students is: ");
        for (Student student : result) {
            System.out.println(student);
        }

        // dùng biểu thức Lambda để in cùng được

        em.close();
    }
}