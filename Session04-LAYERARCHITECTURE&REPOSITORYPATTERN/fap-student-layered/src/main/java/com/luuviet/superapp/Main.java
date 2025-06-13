package com.luuviet.superapp;

import com.luuviet.superapp.entity.Student;
import com.luuviet.superapp.service.StudentService;

public class Main {
    public static void main(String[] args) {
        StudentService studentService = new StudentService();

        // 1. TẠO MỚI HỒ SƠ SINH VIÊN
        Student an = new Student("SE10", "AN NGUYỄN", 2005, 8.6);
//        studentService.createStudent(an);
//        studentService.createStudent(new Student("SE11", "BÌNH LÊ", 2005, 8.7));

        // 2. SHOW ALL
        System.out.println("THE LIST OF STUDENTS:");
        studentService.
                getAllStudents().
                forEach( x -> System.out.println(x));

        // 3. UPDATE 1 HỐ SƠ SINH VIÊN
        an = new Student("SE10", "AN NGUYỄN", 2005, 10);
        studentService.updateStudent(an);
        System.out.println("THE LIST OF STUDENTS BEHIND UPDATED:");
        studentService.
                getAllStudents().
                forEach( x -> System.out.println(x));

        // 4. REMOVE 1 HỐ SƠ SINH VIÊN
        studentService.deleteStudent("SE10");
        System.out.println("THE LIST OF STUDENTS BEHIND DELETED:");
        studentService.
                getAllStudents().
                forEach( x -> System.out.println(x));
    }
}