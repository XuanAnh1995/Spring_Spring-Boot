package com.luuviet.ngoctrinhcoffee.controller;

// class này lo xử lý liên quan đến sản phẩm - product, bao gồm CRUD product nhưng ở góc độ xử lý request - response
// NÓ PHỤ TRÁCH CÁC URL DÍNH DÁNG ĐẾN CRUD PRODUCT
// NHƯNG LÁT HỒI NÓ SẼ KÍNH CHUYỂN DẦN CHO SERVICE, REPOSITORY
// CLASS NÀY LẮNG NGHE CÁC URL, VÀ XEM URL NÀO PHÙ HỢP VỚI HÀM TRONG CLASS NÀY THÌ GỌI HÀM ĐÓ - METHOD MAPPING VỚI URL !!!
// 2 VIỆC: NÓ PHẢI LẮNG NGHE URL, NGHE XONG, GỌI ĐÚNG HÀM ỨNG VỚI URL
// VIỆC 0: NÓ PHẢI LÀ 1 BEAN ĐƯỢC NEW TỰ ĐỘNG, VÀO RAM VÀ NGHE
// VIỆC 1: NGHE - MÀY LÀ @CONTROLLER : BEAN VÀ LẮNG NGHE
// VIỆC 2: HÀM NÀO ỨNG VỚI URL NÀO
// QUAN TRỌNG: 1 URL GET -> ỨNG VỚI 1 HÀM RETURN "TÊN TRANG HTML NÀO ĐÓ"
//                          HÀM PHẢI NẰM TRONG 1 CLASS @CONTROLLER
//                      ->  GET CÓ NGHĨA LÀ LẤY 1 TRANG THÔNG TIN

import com.luuviet.ngoctrinhcoffee.entity.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller     // @RestController, cũng nghe, nhưng trả về JSON
public class ProductController {

    @RequestMapping("/products")    // URL map với hàm này localhost:8080/products
    public String list(Model model) {
        // list nghĩa là show danh sách sản phẩm nằm trong trang products.html
        // tên hàm đặt l gì cũng được, showList(), showProducts(), ...

        // gửi đồ cho view, bỏ vào tủ
        model.addAttribute("msg", "Xin chào Admin. Cafe hơm?!!!");

        // Chuẩn bị 1 danh sách sản phẩm để show ra trang web products.html
        // hard-code test thử, thực tế gọi Service, Repo ... làm sau
        List<Product> productList = new ArrayList<>();
        productList.add(new Product("NTCF1", "Cà phê Java nguyên bản", 30_000));
        productList.add(new Product("NTCF2", "Cà phê vị Ngọc Trinh", 30_000));
        productList.add(new Product("NTCF3", "Cà phê Java mix đậm đà vị Ngọc Trinh", 30_000));

        // gửi dang sách sản phẩm trong thùng đồ, lấy lại qua key products
        model.addAttribute("products", productList);

        return "products";  // return tên trang - view , ko cần .html
                            // tự thymleaf dependency nó gắn lên
    }

    // KHI CONTROLLER TÌM THẤY HÀM XỬ LÍ URL TƯƠNG ỨNG, NÓ SẼ GỌI HÀM NÀY
    // NHƯNG TRƯỚC KHI GỌI, NÓ SẼ GỬI CHO HÀM 1 THÙNG CHỨA ĐỒ RỖNG GỌI LÀ MODEL
    // MÌNH NHÉT DATA VÀO THÙNG CHỨA ĐỒ NÀY, THÙNG ĐỒ MODEL ĐƯỢC NEW TỰ ĐỘNG VÀ CHÍCH VÀO HÀM XỬ LÝ URL
    // KHI THỰC HIỆN LỆNH RETURN CHO URL GET ... THÌ SPRING NÓ SẼ ĐÍNH KÈM CÁI THÙNG ĐỒ VÀO CÙNG TRANG TRẢ VỀ, VÀ ĐƯA TÊN TRANG + THÙNG ĐỒ CHO THYMELEAF MIX, TRỘN, .. RENDER
    // THYMELEAF SẼ LẤY ĐỒ TRONG THÙNG, TRỘN VỚI CÁC TAG HTML, TRỘN XONG, TRẢ CHO TOMCAT TRANG WEB HTML NGON -> ĐẨY VỀ TRÌNH DUYỆT USER!!!

    // CÂU HỎI : LÀM SAO NHÉT ĐỒ VÀO THÙNG VÀ LẤY RA - THÙNG CHỨA NHIỀU ĐỒ ...
    //          CONTROLLER LÀ NHÉT ĐỒ VÀO THÙNG
    //          HTML/THYMELEAF LÀ LẤY ĐỒ RA KHỎI THÙNG VÀ MIX

    // TƯỞNG TƯỢNG QUẦY GỬI ĐỒ Ở SIÊU THỊ VÀ TRUNG TÂM THƯƠNG MẠI
    // BỎ ĐỒ VÔ VÀO HỘC TỦ, LẤY CHÌA KHÓA, MẢNH GIẤY
    // CHÌA KHÓA, MẢNH GIẤY GOI LÀ KEY | MÓN ĐỒ LÀ VALUE!!!!!
    // CÓ CHÌA, MẢNH GIẤY THÌ LẤY ĐƯỢC VALUE/MÓN ĐỒ
    // model.addAttribute(key,                   value)
    //                  chuỗi ko trùng        obj bất kì bạn muốn cất
    // lát hồi  trang view , lấy đồ, dùng key
    //          ${tên-key, mảnh-giấy} -> trả về object, món đồ
}
