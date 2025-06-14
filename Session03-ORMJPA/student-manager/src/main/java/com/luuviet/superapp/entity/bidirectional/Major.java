package com.luuviet.superapp.entity.bidirectional;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Major")
public class Major {
    @Id
    @Column(name = "Id", columnDefinition = "CHAR(2)")
    private String id;  // mã chuyên ngành

    @Column(name = "Name", nullable = false, columnDefinition = "NVARCHAR(100)")
    private String name;    // tên chuyên ngành

    // 1 CHUYÊN NGÀNH CÓ NHIỀU SINH VIÊN, TỨC LÀ 1 MAJOR PHẢI CHỨA 1 ARRAYLIST STUDENT
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "major")
    // mappedBy giúp kết nối ngược với bạn Student , để biết cái major bạn ấy đang giữ có cái major.id khớp với id đang đứng hay không
    // Major nối vơi Student qua đặc điểm Major major bên Student
    // object quan hệ với nhau , đúng chuẩn OOP: chỉ có obj mà thôi
    private List<Student> stuList = new ArrayList<>();
    // stuList.add(đưa 1 stu vào)
    // stuList.remove(1 sv đổi chuyên ngành)
    // VIẾT CODE Ở ĐÂU VỚI 2 LỆNH NÀY ??? NGUYÊN LÍ TRONG S.O.L.I.D
    //                                                  SRP
    // SINGLE RESPONSIBILITY PRINCIPLE : TÍNH ĐƠN TRÁCH NHIỆM
    // Thêm xóa SV KHỎI CHUYÊN NGÀNH, LÀ VIỆC CỦA MAJOR, THÌ PHẢI MAJOR
    // VÌ CHUYÊN NGÀNH CÓ NHIỀU SV, VIỆC SV VÀO RA LÀ VIỆC CỦA MAJOR
    // 2 HÀM XÓA, NHẬP SV THUỘC CLASS NÀY LÀ HỢP LÝ

    public void addStudent(Student obj) {
        stuList.add(obj);   // 1 student đã tham gia vào chuyên ngành này
        // nhưng chưa nói được student obj đang có thực sự trỏ về, lưu info chuyên ngành hay không, info major của sv chưa được set giá trị
        // ta cần có 2 câu: major có sinh viên ra nhập -> done qua lệnh stuList.add(obj)
        // student thuộc về major này (this) -> done:
        obj.setMajor(this);     // student thuộc về major này (this) -> done
        // sv obj trỏ thẳng vào major đang đứng è è this có đủ info id, name của Major
    }

    public void removeStudent(Student obj) {
        stuList.remove(obj);    // 1 sv đổi ngành
        obj.setMajor(null);     // tạm thời sv ko còn ngành trước đ, giờ là null, chưa trỏ ngành nào
    }

    // CÓ CÂU QUERY TRONG DB: CHUYÊN NGÀNH SẼ CÓ BAO NHIÊU STUDENT
    // SELECT * FROM STUDENT WHERE MAJORID = 'SE'
    // OOP: MAJOR NÀY ĐANG CÓ LIST STUDENT , MÌNH RETURN LÀ XONG
    // HÀM GET() TRUYỀN THỐNG
    public List<Student> getStuList() {
        return stuList;
    }

    public Major() {
    }

    public Major(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        // TOSTRING ĐẸP TRAI
        return String.format("|%2s|%-50s|", id, name);
    }
}
