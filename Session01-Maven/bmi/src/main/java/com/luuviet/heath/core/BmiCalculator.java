package com.luuviet.heath.core;

public class BmiCalculator {
    // Hàm static tính chỉ số khỗi cỏ thể dựa trên chiều cao  và cân nặng
    // bmi = cân nặng (kg) / chiều cao (m) bình phương
    // bmi < 18.5 ốm
    // bmi 18.5 ... 24.9 chuẩn form
    // 25 béo
    public  double getBmi(double height, double weight) {
        return weight / (height * height);
    }
}
