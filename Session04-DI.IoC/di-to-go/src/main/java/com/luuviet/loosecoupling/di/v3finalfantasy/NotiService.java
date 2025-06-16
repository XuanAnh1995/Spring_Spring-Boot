package com.luuviet.loosecoupling.di.v3finalfantasy;

// INTERFACE LÀ 1 CLASS CHA KO CÓ CODE TRONG CÁC HÀM (ABSTRACT METHOD)
// VỀ LÍ THUYẾT, KO CÓ CODE THÌ KO LƯU ĐƯỢC OBJ VÌ NEW XONG, CHẤM GỌI HÀM, HÀM KO CÓ CODE LẤY GÌ MÀ CHẠY
// VỀ THỰC TẾ, INTERFACE ĐƯỢC VÍ NHƯ CLB, ĐỘI NHÓM, GROUP KHI NÓ TỤ TẬP AE CÙNG CHÍ HƯỚNG, QUY TẮC MÀ CLB ĐƯA RA , YÊU CẦU AE PHẢI TUÂN THỦ
// AE TUÂN THỦ, LÀM THEO CÁCH CỦA MỖI NGƯỜI, GOỊ LÀ IMPLEMENT - THI TRIỂN, TRIỂN KHAI
// NÓ SẼ MÓC THEO NGUYÊN LÍ: TÍNH ĐA HÌNH: POLYMORPHISM
public interface NotiService {

    public void sendNoti(String to, String message);     // Hàm này ko có code, chờ ae member triển khai, thực thi
}
