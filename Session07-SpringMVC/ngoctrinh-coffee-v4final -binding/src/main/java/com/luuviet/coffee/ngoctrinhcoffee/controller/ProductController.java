package com.luuviet.coffee.ngoctrinhcoffee.controller;

import com.luuviet.coffee.ngoctrinhcoffee.entity.Product;
import com.luuviet.coffee.ngoctrinhcoffee.service.CategoryService;
import com.luuviet.coffee.ngoctrinhcoffee.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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
    public String showProductList(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "products";
    }

    @GetMapping("/products/update/{id}")
    public String showProductForm(Model model, @PathVariable ("id")String id) {
        model.addAttribute("selectProduct", productService.getProductById(id));

        model.addAttribute("categories", categoryService.getAllCategories());
        return "product-form";
    }

    @GetMapping("/products/create")
    public String showCreateForm(Model model) {
        model.addAttribute("selectProduct", new Product());

        model.addAttribute("categories", categoryService.getAllCategories());
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
    public String saveProduct(@ModelAttribute("selectProduct") Product product) {
        // save xong trả về trang products, show danh sách sản phẩm mới, hoặc sản phẩm cũ đã được cập nhật!!!

        // nhờ Service save: key mời thì là insert, key cũ thì là update , tự Hibernate nó tính cho mình qua thằng repo
        // TODO: KEY TRÙNG
        productService.addProduct(product);

        // return "/products";     // bị url cũ VẪN CÒN /save , F5 RESUBMISSION

        return "redirect:/products";    // gọi lại hàm showProductList ở trên
        // redirect: bắt trình duyệt gọi URL khác
        // /save bị thay bằng  /products, f5 ko sợ
    }

    // link delete
    @GetMapping("/products/delete/{id}")
    public String deleteProduct(@PathVariable ("id")String id){
        productService.deleteProduct(productService.getProductById(id));
        return "redirect:/products";
    }

    // link search

}
