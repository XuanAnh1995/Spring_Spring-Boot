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
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller     // @RestController, cũng nghe, nhưng trả về JSON
public class ProductController {

    @GetMapping(path = "/msg")
    public String showMessage(Model model) {
        // làm sao lấy được name sản phẩm của bên POST
        // 1 URL, 1 HÀM TƯƠNG ỨNG, 1 THÙNG MODEL MỚI TÍNH ĐỂ TA BỎ ĐỒ VÀO TRƯỚC KHI RENDER!!!!!!!!!!!
        // MỖI HÀM CÓ 1 THÙNG RIÊNG
        // KĨ THUẬT CHUYỂN DATA TỪ MODEL KIA SANG MODEL NÀY Ở CÂU LỆNH REDIRECT, TẠI SAO LÀM VẬY: REDIRECT LÀ GỌI URL MỚI
        // URL MỚI LÀ CHỚI THÙNG MỚI
        // TRƯỚC KHI REDIRECT, GỬI KÉ THÊM DATA TỪ MODEL CŨ SANG MODEL MỚI
        // TỪ MODEL CỦA THẰNG POST KÉ SANG MODEL CỦA THẰNG GET NÁY

        // MODEL Ở ĐÂY, NGOÀI DATA CỦA CHÍNH CHỦ HÀM NÀY, CÒN NHẬN THÊM TỪ BÊN POST GỬI SANG !!!


        return "result";    //.html
    }

    // hàm này update 1 sản phẩm xuống DB được gọi bởi việc nhấn nút Save
    // và nhận vào các data gõ trong ô nhập được gửi đến đây
    @PostMapping(path = "/products/edit")
    // @RequestParam : gửi từng ô nhập ở form lên server, map vào biến hứng trong hàm
    // tên biến hừng ko cần giống biến trong form
    // nhưng @RequestParam("tên-biến-ở-bên-form-html-thuộc-tính-của-ô-nhập")
    public String update(@RequestParam("id") String id,
                         @RequestParam("name") String name,
                         @RequestParam("price") Double price,
                         Model model,
                         RedirectAttributes redirectAttributes) {
        model.addAttribute("msg", "Đã update thành công - Mock message");
        model.addAttribute("id", id);
        model.addAttribute("name", name);
        model.addAttribute("price", price);
        // 4 LỆNH NÀY SẼ VÔ DỤNG NẾU CHƠI VỚI REDIRECT VÌ BÊN REDIRECT XÀI THÙNG MODEL KHÁC !!!

        //return "result";  // .html HIỆN TƯỢNG RESUBMISSION XUẤT HIỆN

        // GỬI KÉ SANG BÊN MODEL CỦA URL GET /msg
        redirectAttributes.addFlashAttribute("msg", "Đã update thành công - Mock message");
        redirectAttributes.addFlashAttribute("id", id);
        redirectAttributes.addFlashAttribute("name", name);
        redirectAttributes.addFlashAttribute("price", price);

        return "redirect:/msg";  // gọi URL: localhost:8080/result
        // url đổi trên trình duyệt luôn
        // f5 thì f5 của result, ko còn là f5 post nữa
    }
    // VỚI HÀM POST (BẢN CHẤT LÀ GET - NHƯNG ỬI KÈM NHIỀU DATA KHI "GET")
    // KHI HÀM POST TRẢ VỀ 1 TRANG KẾT QUẢ QUA LỆNH RETURN "TÊN TRANG"

    // THÌ URL POST VẪN GIỮ NGUYÊN, TRONG KHI ĐÓ THÂN TRÌNH DUYỆT CÓ DATA ĐƯỢC TRẢ VỀ - TRANG TRẢ VỀ
    // F5 VỚI POST THÌ SAO
    // THÌ VẪN TRẢ VỀ TRANG KQ NHƯ BÌNH THƯỜNG, NHƯNG LẠI GỬI KÈM 1 ĐỐNG DATA
    // RESUBMISSION FORM, GIỐNG NHƯ NHẤN LẠI NÚT BẤM (VÌ NHẤN NÚT GỌI URL NÀY )
    // CỰC KỲ NGUY HIỂM VỚI TÍNH NĂNG CREATE , F5 MÀN HÌNH KQ SẼ TƯƠNG ĐƯƠNG
    // VIỆC GỬI LẠI DATA, CHẠY LẠI XỬ LÝ => DUPLICATE DATA!!!

    // CHỐT HẠ: VỚI POST , TA CẦN ĐỔI URL TRÁNH SUBMIT LẠI KHI F5
    // URL GET, F5 , GET LẠI
    // URL POST, F5, POST LẠI, NGUY HIỂM , URL POST XỬ LÝ XONG , RETURN TRANG VÀ ĐỔI URL LUÔN, LỠ F5 LẠI, KO CÒN URL POST ĐỂ RE-SUBMIT FORM
    // REDIRECT METHOD !!!!!!!!!
    // ĐỊNH HƯỚNG LẠI URL, GỌI LẠI URL MỚI NHƯNG VẪN CÙNG KẾT QUẢ TRẢ VỀ TRANG!!!

    // >>>>>>>>> QUAN TRỌNG: XỬ LÝ POST XONG, THÌ NHÓ ĐỔI URL KẾT QUẢ!!!
    //                      TRÁNH F5 LẠI CÁI POST!!!
    //                      ĐỔI URL VÀ F5 LÀ F5 KẾT QUẢ, KO PHẢI F5 POST

    // HIỆN TƯỢNG URL GET Y CHANG: URL GET VẪN GIỮ NGUYÊN, TRONG KHI ĐÓ THÂN TRÌNH DUYỆT CÓ DATA ĐƯỢC TRẢ VỀ - TRANG TRẢ VỀ

    // Ý NGHĨA VIỆC GIỮ NGUYÊN URL: GỌI HÀM THÌ TRẢ VỀ KQ Ở DƯỚI, TÊN HAM VẪN Ở TRÊN


    // @RequestMapping("/products")    // URL map với hàm này localhost:8080/products
    // nguy hiểm 1 chút: url na dành cho cả GET/POST/PUT/... miễn là match url
    // ta cần phân tách hàm nào dành cho GET, hàm nào dành cho POST

    // CÁCH VIẾT CHUẨN, PHÂN BIỆT HÀM NÀO TRONG GET/POST/...
    // @RequestMapping(path = {"/products", "/jack"}, method = RequestMethod.GET)

    // CÁCH VIẾT NGẮN HƠN:
    // HÀM NHẬN REQUEST THUỘC NHÓM GET, LÁT HỒI CÒN NHÓM POST, PUT, ...
    // @GetMapping(path = {"/products", "/jack"}) // CÓ BAO NHIÊU URL ĐƯỢC MAP
    @GetMapping("/products")
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

    // @GetMapping(path = {"/products/edit/NTCF1", "/products/edit/NTCF2", "/products/edit/NTCF3"})
    @GetMapping(path = "/products/edit/{pid}")
    // tách url thành 2 phần, 1 phần cố định, và 1 phần thay đổi - phần thay đổi gọi là path variable
    public String showProduct(Model model, @PathVariable("pid") String id) {
        // đã trích được id muốn xem chi tiết từ click hyperlink của user
        // TODO: DÙNG SERVER GỌI REPO ĐỂ WHERE TRONG TABLE PRODUCT SẢN PHẨM CÓ ID VỪA CLICK , LÀM SAU

        // Tạm thời HARD-CODE
        // Product selectedProduct = Repo   // lấy từ DB
        Product selectedProduct = null;
        if (id.equalsIgnoreCase("NTCF1")) {
            selectedProduct = new Product("NTCF1", "Cà phê Java nguyên bản", 30_000);
        } else if (id.equalsIgnoreCase("NTCF2")) {
            selectedProduct = new Product("NTCF2", "Cà phê vị Ngọc Trinh", 30_000);
        } else if (id.equalsIgnoreCase("NTCF3")) {
            selectedProduct = new Product("NTCF3", "Cà phê Java mix đậm đà vị Ngọc Trinh", 30_000);
        }

        // quan trọng ném vào thùng cho trang render!!!
        model.addAttribute("minzy", selectedProduct);

        return "product-form";  // .html mà ko cần ghi ra
        // lệnh return trang luôn đính kèm theo 1 thùng giao hàng, gửi đồ
        // theo style "key" - value, chìa khóa, mảnh giấy để lấy món đồ trong thùng. Thymeleaf engine dùng key để mò vào thùng lấy đồ ra mix trộn thành HTML THUẦN VÀ TRẢ VỀ CHO TOMCAT -> BROWSER!!!
    }

}
