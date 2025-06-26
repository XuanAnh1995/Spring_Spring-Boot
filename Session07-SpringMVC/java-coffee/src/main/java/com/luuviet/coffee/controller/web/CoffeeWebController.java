package com.luuviet.coffee.controller.web;

import com.luuviet.coffee.entity.Coffee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller     // 1 bean được tự new từ đầu bởi Container, chuyên trả lời các http request đến từ url của trình duyệt cuả user
// có nhiều url khác nhau, thì ứng với nhiều hàm trong class
// các hàm trả về html, trang web lung linh Ngọc Trinh
public class CoffeeWebController {

    @GetMapping("/")
    // user gõ localhost:6969/ ngĩa là ngảy đến hàm này
    public String home(Model model) {
        model.addAttribute("coffee", "Cafe Java đậm đà  vị Ngọc Trinh");

        model.addAttribute("coffee_new", new Coffee("COF001", "Jakarta", 10.05));
        return "index";     // trả về trang cho trình duyệt
    }

}
