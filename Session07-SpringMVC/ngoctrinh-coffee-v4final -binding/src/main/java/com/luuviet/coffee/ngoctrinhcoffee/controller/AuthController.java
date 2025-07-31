package com.luuviet.coffee.ngoctrinhcoffee.controller;

import com.luuviet.coffee.ngoctrinhcoffee.entity.Account;
import com.luuviet.coffee.ngoctrinhcoffee.service.AccountService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthController {

    @Autowired
    private AccountService accountService;

    @GetMapping({"/", "/login", "/ngoctrinh"})
    public String showFormLogin() {
        return "login";     // login.html
    }

    @PostMapping("/auth")
    public String doLogin(
            Model model,
            @RequestParam("email") String email,
            @RequestParam("pass") String password,
            HttpSession session
    ) {
        Account account = accountService.authenticate(email, password);
        // hoặc null hoặc khác null - tức là match email và pass
        // null chả biết sai cái gì, vì có thể sai email, sai pass , sai cả 2, role member, active false
        if (account == null) {
            // vòng về gõ lại login hoy
            // gửi kèm câu chửi
            model.addAttribute("error", "Invalid credentials!!!");
            return "login";
        }

        // Login thành công, cất thông tin login lâu dài để phân quyền các trang, để chặn gọi trực tiếp url, bypass login, ...
        // CẤT VÀO 1 NƠI MÀ MỌI TRANG CỦA USER NÀY CÙNG NHÌN THẤY, CÙNG XÀI
        // THÙNG NÀY LÂU DÀI HƠN THÙNG MODEL - MODEL CHỈ CÓ REQUEST, GỬI THÙNG, RETURN, HẾT THÙNG - REQUEST SCOPE
        // SESSION : MỌI TRANG ĐỀU ADD, DÙNG, DEFAULT 30 PHÚT
        // GIỐNG QUẢNG TRƯỜNG, SẢNH, MỌI NGƯỜI CÙNG ĐẾN THAM GIA ...
        // MỖI USER CÓ 1 SESSION, SERVER CO RẤT NHIỀU QUẢNG TRƯỜNG
        session.setAttribute("loggedInUser", account);
        // RAM TOMCAT: Account loggedInUser

        return "redirect:/products";    // gọi trang product lên đấy, qua url, ko return: tên trang lỗi Resubmission
    }

    @GetMapping("/logout")
    public String doLogout(HttpSession session) {
        session.invalidate();   // Xóa biến loggedInUser trong vùng quảng trường thay vì chờ 30 phút default
        return "redirect:/login";
    }
}
