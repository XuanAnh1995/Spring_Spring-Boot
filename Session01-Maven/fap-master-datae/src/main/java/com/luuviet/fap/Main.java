package com.luuviet.fap;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.luuviet.fap.entity.*;

public class Main {

    public static void main(String[] args) throws JsonProcessingException {

        // Tạo mới môn học
        Subject swt = new Subject("SWT301", "SOFTWARE TESTING", 3, 45);
        Subject hsf = new Subject("HSF302", "HIBERNATE & SPRING FRAMEWORK", 3, 45);

        // SHOW info 2 môn
        System.out.println("SWT INFO: "+ swt.toString());
        System.out.println("HSF INFO: "+ hsf.toString());

        // Tao mới hồ sơ sinh viên
        Student an = new Student("SE1", "AN NGUYỄN", 2004, 8.6);
        Student binh = new Student("SE2", "BÌNH LÊ", 2004, 8.7);

        // SHOW info 2 bạn sv
        System.out.println("AN INFO: "+ an.toString());
        System.out.println("BINH INFO: "+ binh.toString());

        //CHƠI với JSON, từ OBJECT THÀNH JSON, VÀ NGƯỢC LẠI
        // CẦN TẠO OBJECT QUẢN LÝ JSON TỪ THƯ VIỆN JACKSON
        ObjectMapper mapper = new ObjectMapper();
        String anJson = mapper.writeValueAsString(an);
        System.out.println("LẦN ĐẦU TIÊN CHUYỆN ẤY, JSON TỪ OBJECT MÀ RA: " + anJson);

        // TỪ JSON THÀNH OBJECT , GIẢ BỘ FE GỬI BE, TAO CÓ FORM NHẬP USER SUBMIT INFO, TAO GỬI MÀY BE JSON, MÀY LO THÀNH OBJECT ĐI, ĐỂ XUỐNG DB
        String cuongJson = """
                                {"id":"SE3",
                                "name":"CƯỜNG NGUYỄN",
                                "yob":2005,
                                "gpa":8.0}
                            """;
        Student cuong = mapper.readValue(cuongJson, Student.class);
        System.out.println("CUONG TỪ JSON MÀ RA: "+ cuong.toString());

    }
}