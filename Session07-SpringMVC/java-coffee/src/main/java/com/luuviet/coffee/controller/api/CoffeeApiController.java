package com.luuviet.coffee.controller.api;

import com.luuviet.coffee.entity.Coffee;
import org.springframework.web.bind.annotation.*;

@RestController     // bean này phục vụ các url mà muốn lấy data thô, trả về JSON
// hoặc nhận JSON từ trang web gửi lên ...
// thường bạn sẽ thấy url api tách hẳn so với url web
// https:.../api/v1/???
// https:.../api/v2/???
@RequestMapping("/api/v1")
public class CoffeeApiController {

    @GetMapping("/cup")
    public Coffee getACoffee() {
        return new Coffee("JCNT", "Cafe Java topping lung linh Ngọc Trinh", 29_000);
        // Lấy từ DB lên qua Service/Repo / JPA-Hibernate/JDBC/Table

        // data Jackson convert từ object thành JSON bên trình duyệt data thôi
        // Web API: gọi hàm qua URL trả về JSON
        // Swagger UI: help, document chứa URL để dùng thử API
    }

    // em muốn gửi data lên server , JSON gửi lên , xử lí giúp em
    @PostMapping("/add")
    public Coffee addCoffee(@RequestBody Coffee coffee) {
        // sửa object đã nhận , xong trả về để mọi người biết mình đã nhận từ client, và mình chỉnh ít info
        String oldName = coffee.getName();
        String newName = oldName + "|Lòng ah nghĩ đến Trinh";
        coffee.setName(newName);
        return coffee;
    }

}
