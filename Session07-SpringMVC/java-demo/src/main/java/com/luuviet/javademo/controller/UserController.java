package com.luuviet.javademo.controller;

import com.luuviet.javademo.dto.request.UserCreateRequest;
import com.luuviet.javademo.dto.request.UserUpdateRequest;
import com.luuviet.javademo.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

//    @PostMapping("/")
    @RequestMapping(method = RequestMethod.POST, path = "/", headers = "apiKey = v1.0")
    public String addUser(@RequestBody UserCreateRequest userCreateRequest) {
        return "Success add user";
    }

    @PutMapping("/{userId}")
    public String updateUser(@PathVariable("userId") Integer userId, @RequestBody UserUpdateRequest userUpdateRequest) {
        return "Success update user";
    }

    @PatchMapping("/{userId}")
    public String changeStatus(@PathVariable("userId") Integer userId, @RequestParam(required = false) boolean status) {
        System.out.println("Change User Status: "+status);
        return "Success change status";
    }

    @DeleteMapping("/{userId}")
    public String deleteUser(@PathVariable("userId") Integer userId) {
        return "Success delete user";
    }

    @GetMapping("/{userId}")
    public User getUser(@PathVariable("userId") Integer userId) {
        User user = new User("XuanAnh", "LuuViet", "luuviet@gmail.com", "0988987071");
        return user;
    }

    @GetMapping("/list")
    public List<User> getUsers() {
        return List.of(getUser(1), getUser(2), getUser(3));
    }
}
