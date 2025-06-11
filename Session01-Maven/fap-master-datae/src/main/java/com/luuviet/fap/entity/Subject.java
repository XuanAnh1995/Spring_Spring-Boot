package com.luuviet.fap.entity;

// class lưu thông tin các môn học
public class Subject {

    private  String code;    // mã môn

    private  String name;   //  tên môn học

    private int credit;     // Số tín chỉ

    private double hours;   // số giờ học

    // khi chơi với table, tức là
    // class sẽ map thành cấu trúc table
    // new subject("SD191", "SOFTWARE TESTING", 3, 15)
    // tương ứng với từng dòng trên table ~ insert into
    // CLASS SUBJECT    ------------  TABLE SUBJECT
    // NEW  SUBJECT     ------------   INSERT INTO SUBJECT VALUES

    // Bắt buộc CLASS phải có những thứ sau khi chơi với CSDL
    // CONSTRUCTOR rỗng (Không tham số, không câu lệnh)
    // CONSTRUCTOR FULL tham số
    // GETTER() and SETTER()
    // TOSTRING()


    // TOÀN BỘ ĐOẠN CODE NÀY GIÚP TA TẠO RA OBJECT
    // 1 CÁCH LINH HOẠT (TẠO - NEW, CHỈNH SỬA - SET, HỎI - GET, SHOW - TOSTRING)
    // NHƯNG NHÀN CHÁN , KO THÈM TƯ DUY GÌ THÊM
    // ĐOẠN CODE NHÀM CHÁN, NHƯNG VẪN PHẢI LÀM, KO THỂ THIẾU -> GỌI LÀ BOILER PLATE!!!
    public Subject() {
    }

    public Subject(String code, String name, int credit, double hours) {
        this.code = code;
        this.name = name;
        this.credit = credit;
        this.hours = hours;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public double getHours() {
        return hours;
    }

    public void setHours(double hours) {
        this.hours = hours;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", credit=" + credit +
                ", hours=" + hours +
                '}';
    }
}
