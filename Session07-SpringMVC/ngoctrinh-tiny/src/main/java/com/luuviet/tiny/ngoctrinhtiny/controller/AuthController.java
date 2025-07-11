package com.luuviet.tiny.ngoctrinhtiny.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AuthController {

    @GetMapping(path = {"/", "/login"})
    public String showLogin() {
        return "login";
    }

//    @PostMapping(path = "/do-login")    // lấy data từ trang web gửi lên có 2 cách: @RequestParam, @ModelAttribute
//    public String doLogin(
//            @RequestParam("username") String username,
//            RedirectAttributes redirectAttributes) {
//        // TODO: PHẢI LẤY ROLE TỪ DATABASE
//        if (username.equalsIgnoreCase("admin")) {
//            redirectAttributes.addFlashAttribute(
//                    "role", 1);
//        } else {
//            redirectAttributes.addFlashAttribute("role", 2);
//        }

    @PostMapping(path = "/do-login")
    public String doLogin(
            @RequestParam("username") String username,
            HttpSession httpSession
    ) {
        // Session là cái thùng dành cho từng người, từng user khác nhau, có thể chứa nhiều món đồ, dùng chung cho các page luôn
        // f5 của mỗi page, vùng session nay ko mất
        // thông tin login hay cất ở đây, role cất ở đây

        if (username.equalsIgnoreCase("admin")) {
            httpSession.setAttribute("role", 1);
            //                          key      value
            //  hộp cất đồ - value, có chìa khóa để mở ra lấy đồ
        } else {
            httpSession.setAttribute("role", 2);
        }

        return "redirect:/products";
    }

    // HTTP: GIAO THỨC THEO STYLE STATELESS , KO NHỚ NHAU LÂU
    // REQUEST/RESPONSE XONG, QUÊN LUÔN AI ĐÃ GỌI
    // CẦN CÓ KĨ THUẬT ĐỂ LƯU LẠI DẤU VẾT CỦA 1 USER: REQUEST LẦN TRƯỚC, LẦN NÀY CỦA CÙNG 1 NGƯỜI
    // SETTING NGÔN NGỮ CỦA WEB APP:USER HOANG: SETTING LANG -> EN
    //                                          DÙNG CHO NHIỀU TRANG
    // GIỎ HÀNG QUA NHIỀU TRANG KHÁC NHAU
    // SESSION: CƠ CHẾ LƯU TRỮ GIÁ TRỊ DÙNG CHUNG CHO NHIỀU TRANG CỦA 1 USER


    @GetMapping("/products")
    public String showProducts(
            @RequestParam(name = "keyword", required = false) String keyword,
            Model model,
            HttpSession httpSession
    ) {
        // CHẶN NGAY TỪ ĐẦU HÀM, KO CẤM USER GÕ URL
        // SERVER VÀ CODE MÌNH SẼ CHẶN ... GÌ ĐÓ KHI CHƯA LOGIN THÌ VÒNG VỀ LOGIN, ĐỔI URL LUÔN
        Integer role = (Integer) httpSession.getAttribute("role");
        if (role == null) {
            return "redirect:/login";
        }

        // XÀI KEYWORD ĐỂ WHERE TRONG DATABASE, NẾU ĐI CON ĐƯỜNG SEARCH
        // LÚC NÀY SHOW ÍT HƠN
        // ĐI TỪ LOGIN SANG THÌ KO CÓ FIELD KEYWORD LUÔN !!!
        // LÚC NÀY SHOW FULL
        if(keyword != null && !keyword.isEmpty()) {
            // Gọi Service, Repository để where DB trả về table
            model.addAttribute("result", keyword + " ĐÃ WHERE RỒI NHE");
        } else {
            // đi con đường login ..., show Full từ DB
            model.addAttribute("result", " FULL KO CHE!!!");
        }

        model.addAttribute("role", httpSession.getAttribute("role"));   // lấy được 1 hoặc 2
        return "products";
    }

    @GetMapping(path = "/logout")
    public String logout(HttpSession httpSession) {
        httpSession.invalidate();
        return "redirect:/login";
    }
}
