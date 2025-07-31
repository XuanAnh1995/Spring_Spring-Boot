package com.luuviet.coffee.ngoctrinhcoffee.controller;

import com.luuviet.coffee.ngoctrinhcoffee.entity.Account;
import com.luuviet.coffee.ngoctrinhcoffee.entity.Product;
import com.luuviet.coffee.ngoctrinhcoffee.service.CategoryService;
import com.luuviet.coffee.ngoctrinhcoffee.service.ProductService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
// 1. chịu trách nhiệm hứng các url từ trình duyệt (GET, POST, ...) hứng data gửi lên server
// 2. gọi hàm xử lí
// 3. Return tên trang web
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/products")
    public String showProductList(
            Model model,
            @RequestParam(value = "kw", required = false, defaultValue = "") String kw,
            HttpSession session
    ) {
        Account account = (Account) session.getAttribute("loggedInUser");
        if (account == null) {
            // chưa login, vì tìm ko thấy info đã login nằm trong quảng trường, thùng lâu dài session
            return "redirect:/login";
        }

        // Kiểm tra keyword có hay ko, search gần đúng - LIKE RELATIVE SEARCH
        // Ko có thì show full
        if (!kw.equals("")) {
            model.addAttribute("products", productService.searchProductsByName(kw));
        } else {
            model.addAttribute("products", productService.getAllProducts());
        }

        return "products";
    }

    @GetMapping("/products/update/{id}")
    public String showProductForm(
            Model model,
            @PathVariable("id") String id,
            HttpSession session
    ) {
        Account account = (Account) session.getAttribute("loggedInUser");
        if (account == null) {
            // chưa login, cì tìm ko thấy info đã login nằm trong quảng trường, thùng lâu dài session
            return "redirect:/login";
        }

        // role = 2, 1, 3 -> ENUM !!! Role.STAFF
        if (account.getRole() == 2) {     // staff mà bày đặt update
            // đã login, nhưng coi chừng role staff gõ url trực tiếp là giết, login đi
            return "redirect:/products";
        }

        model.addAttribute("selectProduct", productService.getProductById(id));

        model.addAttribute("categories", categoryService.getAllCategories());

        // GỬI THÊM EM PHẤT CỜ TRẠNG THÁI/BIẾN FLAG LƯU CÁI MODE /TRẠNG THÁI, CHẾ ĐỘ CỦA MÀN HÌNH
        model.addAttribute("formMode", "update");
        // String formMode = "update"; gửi biến formMode sang màn hình product-form.html

        return "product-form";
    }

    @GetMapping("/products/create")
    public String showCreateForm(
            Model model,
            HttpSession session
    ) {
        Account account = (Account) session.getAttribute("loggedInUser");
        if (account == null) {
            // chưa login, cì tìm ko thấy info đã login nằm trong quảng trường, thùng lâu dài session
            return "redirect:/login";
        }

        if (account.getRole() == 2) {     // staff mà bày đặt update
            // đã login, nhưng coi chừng role staff gõ url trực tiếp là giết, login đi
            return "redirect:/products";
        }

        model.addAttribute("selectProduct", new Product());

        model.addAttribute("categories", categoryService.getAllCategories());

        model.addAttribute("formMode", "create");
        // String formMode = "create"; gửi biến formMode sang màn hình product-form.html

        return "product-form";
    }

    // linh save
    @PostMapping("/products/save")
    // Phải lấy từ dưới màn hình form gửi lên: id, name, quantity, price, category =>   CÓ 2 CÁCH LẤY
    // CÁCH 1: TRÂU BÒ: DÙNG @RequestParam("id") String id,
    //                      @RequestParam("name") String name,
    //                      @RequestParam("quantity") Integer quantity,
    //                      ...
    //      chỉ dùng nếu ít field

    // CÁCH 2: OBJECT BINDING , TOÀN BỘ FORM THÀNH 1 OBJ ĐẨY LÊN, TRÊN NÀY CHỈ 1 THAM SÓ PRODUCT GOM
    //                      DÙNG @ModelAttribute("?") Product pro
    // THAY VÌ CÁCH 1 GỬI LẺ TỪNG PHẦN CỦA OBJ, CÁCH 2 GỬI SỈ , 1 OBJ CHỨA CÁC THÀNH PHẦN
    // ??? ĐI XUỐNG LÀ GÌ, ĐI LÊN LÀ ĐÓ !!! - BIẾN ĐI LÊN NẰM Ở TAG <FORM>: selectProduct

    // KĨ THUẬT BEAN VALIDATION, CHỈ ĐƯỢC SỬ DỤNG NẾU BẠN DÙNG CƠ CHẾ BINDING OBJECT TỪ DƯỚI FORM HTML LÊN CONTROLLER, NẾU BẠN MUỐN DÙNG @RequestParam("price") ... thì ko xài được kĩ thuật validation này
    // CHẶN ĐẦU, CHẶN ĐUÔI QUÁ TRÌNH BINDING DỮ LIỆU TỪ DƯỚI LÊN OBJECT
    // CHẶN ĐÂU QUA @Valid ĐỂ KÍCH HOẠT VIỆC KIỂM SOÁT TỪNG FIELD ĐƯỢC GÁN GIÁ TRỊ CÓ BỊ LỖI HAY KO
    // NẾU PHÁT HIỆN CÓ LỖI, THÌ GHI BIÊN BẢN QUA bindingResult
    // BIÊN BẢN VI PHẠM RESULT TỰ ĐƯỢC ADD VÀO THÙNG MODEL GỬI TRỞ LẠI FORM, NẾU MÌNH QĐ CÓ LỖI NHẬP THÌ TRỞ LẠI FORM
    public String saveProduct(
            @Valid @ModelAttribute("selectProduct") Product product,
            BindingResult bindingResult,
            Model model,
            @RequestParam("mode") String formMode
    ) {
        // save xong trả về trang products, show danh sách sản phẩm mới, hoặc sản phẩm cũ đã được cập nhật!!!

        // NẾU CÓ LỖI NHẬP TRONG QUÁ TRÌNH BINDING, THÌ VÒNG LẠI MÀN HÌNH NHẬP
        if (bindingResult.hasErrors()) {
            // gởi thêm category khi ở màn hình show error
            model.addAttribute("categories", categoryService.getAllCategories());

            // gửi lại formMode nhe
            model.addAttribute("formMode", formMode);
            // create/ updated được gửi khi nhấn [Save]

            return "product-form";  // đã gởi kèm biên bản result sang form
        }

        // nhờ Service save: key mời thì là insert, key cũ thì là update , tự Hibernate nó tính cho mình qua thằng repo
        // TODO: KEY TRÙNG
        if (formMode.equals("create")) {
            // check key trùng ...
            if (productService.existsProductById(product.getId())) {
                // trùng key rồi, ko save được; phải chửi, vòng lại màn nhập
                model.addAttribute("categories", categoryService.getAllCategories());

                // gửi lại formMode nhe
                model.addAttribute("formMode", formMode);
                model.addAttribute("duplicated", "Duplicated Id. Input another one!");

                return "product-form";
            }
        }

        // Ko trùng id thì save bình thường
        // và còn dùng luôn cho update
        productService.addProduct(product);

        // return "/products";     // bị url cũ VẪN CÒN /save , F5 RESUBMISSION

        return "redirect:/products";    // gọi lại hàm showProductList ở trên
        // redirect: bắt trình duyệt gọi URL khác
        // /save bị thay bằng  /products, f5 ko sợ
    }

    // link delete
    @GetMapping("/products/delete/{id}")
    public String deleteProduct(@PathVariable("id") String id) {
        productService.deleteProduct(productService.getProductById(id));
        return "redirect:/products";
    }

    // link search

}
