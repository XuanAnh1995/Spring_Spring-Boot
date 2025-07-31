package com.luuviet.coffee.ngoctrinhcoffee.repository;

import com.luuviet.coffee.ngoctrinhcoffee.entity.Product;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepo extends JpaRepository<Product, String> {

    // SPRING BOOT, SPRING JPA, SPRING HIBERNATE CÓ 2 CƠ CHẾ SINH HÀM TỰ ĐỘNG CHO MỖI ENTITY/TABLE
    // NHỮNG HÀM NỔI TIẾNG, PHỔ BIẾN, HAY DÙNG THƯỜNG XUYÊN
    // JPA/HIBERNATE NÓ SẼ SINH SẴN TRƯỚC CÁC HÀM NÀY: save(), findAll(), findAllBy..() .... -> BUILT-IN CÓ SẴN RỒI, KO CẦN KHAI BÁO Ở REPO, MÀ SERVICE CHẤM XÀI LUÔN

    // NHỮNG HÀM ĐẶC THÙ, ĐẶC BIỆT RIÊNG, ÍT KHI DÙNG
    // THÌ CHẤM BÊN SERVICE KO ĐỦ, MÀ PHẢI GÕ TÊN HÀM BÊN NÀY, ĐỂ RA LỆNH CHO JPA/HIBERNATE BIẾT CẦN GENERATE RA CODE CHO HÀM ĐẶC BIỆT NÀY
    // CÚ PHÁP VIẾT HÀM DẠNG NÀY LÀ CÚ PHÁP RIÊNG: ĐỘNG TỪ + PHÂN LOẠI TRẢ VỀ + KIỂU WHERE ... TỰ SINH SQL VÀ CODE KHI BIÊN DỊCH CHÍNH CLASS.
    // HÀM DẠNG NÀY GỌI LÀ: DERIVED QUERY METHOD: HÀM DẪN XUẤT, PHÁT SINH TỪ CÂU QUERY CẦN TRÊN TÊN HÀM
    public List<Product> searchAllByNameIsContainingIgnoreCase(@NotBlank(message = "Name is required! - Phải nhập tên") @Size(min = 5, max = 50, message = "Name length must be between 5 ... 50 characters") @Pattern(
            regexp = "^(\\p{Lu}\\p{Ll}+)(\\s\\p{Lu}\\p{Ll}+)*$",
            message = "Mỗi từ phải bắt đầu hoa, chỉ chứa chữ (Unicode), không số/ký tự đặc biệt, không khoảng trắng thừa"

    ) String name);


    // HÀM BUILT- IN NỔI TIẾNG : HÀM SINH TRƯỚC
    // HÀM HIẾM MUỘN: SINH SAU
    // ĐỀU PHẢI VIẾT THEO TEMPLATE, DERIVED QUERY METHOD
}
