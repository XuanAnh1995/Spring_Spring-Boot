package com.luuviet.superapp.service;

import com.luuviet.superapp.entity.Student;
import com.luuviet.superapp.repository.StudentRepository;

import java.util.List;

public class StudentService {

    private StudentRepository studentRepository = new StudentRepository();

    // CLASS NÀY ĐỨNG GIỮA , HỨNG INFO USER / NGƯỜI DÙNG , TẠO OBJECT , ĐẨY XUỐNG CHO REPO LO GIÙM
    // NÓ CŨNG NHỜ REPO LẤY OBJECT TỪ TABLE , ĐẨY NGƯỢC LÊN UI CHO USER XEM

    // CHẮC CHẮN NÓ KHẢI PHAI BÁO BIẾN REPO ĐỂ REPO TIẾP
    // CHỈ CẦN 1 BIẾN REPO DÙNG CHUNG CHO CÁC HAM, DO MÌNH GỌI BÊN TRONG REPO

    // CLASS NÀY PHẢI CHUẨN BỊ OBJECT ĐỂ ĐƯA XUỐNG REPO
    // TÊN HÀM CLASS NÀY ĐẶT THƯỜNG GẦN GŨI VỚI USER HƠN, DO GẦN USER HƠN GẦN DATABASE, MÌNH LÀ SERVICE CUNG CẤP DATA CHO USER, NHẬN THẦU DATA TỪ USER
    // TÊN HÀM GỢI Ý:
    // createStudent()  getAllStudents()    updateStudent()     deleteStudent()
    // FLOW: UI --- SERVICE --- REPOSITORY --- JpaUtil --- DATABASE

    public void createStudent(Student obj) {
        // TODO: CHECK TRÙNG KEY, EMAIL, VALIDATE, ...
        // TODO: BẮT TRY - CATCH THÔNG BÁO
        studentRepository.save(obj);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public void updateStudent(Student obj) {
        studentRepository.update(obj);
    }

    public void deleteStudent(String id) {
        studentRepository.deleleStudentById(id);
    }
}
