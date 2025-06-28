package com.luuviet.javademo.controller;

import com.luuviet.javademo.dto.request.UserCreateRequest;
import com.luuviet.javademo.dto.request.UserUpdateRequest;
import com.luuviet.javademo.dto.response.ResponseData;
import com.luuviet.javademo.dto.response.ResponseSuccess;
import com.luuviet.javademo.model.User;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {


    @PostMapping("")
    public ResponseData<Integer> addUser(@Valid @RequestBody UserCreateRequest userCreateRequest) {
        System.out.println("userCreateRequest: " + userCreateRequest.toString());
        return new ResponseData<>(HttpStatus.CREATED.value(), "User created successfully", 1);
    }

    @PutMapping("/{userId}")
    public ResponseData<?> updateUser(@Min(1) @PathVariable("userId") Integer userId, @RequestBody UserUpdateRequest userUpdateRequest) {
        System.out.println("userUpdateRequest: " + userUpdateRequest.toString());
        return new ResponseData<>(HttpStatus.ACCEPTED.value(), "User updated successfully");
    }

    @PatchMapping("/{userId}")
    public ResponseData<?> changeStatus(@Min(1) @PathVariable("userId") Integer userId, @RequestParam(required = false) boolean status) {
        System.out.println("Change User Status: " + status);
        return new ResponseData<>(HttpStatus.ACCEPTED.value(), "User changed status successfully");
    }

    @DeleteMapping("/{userId}")
    public ResponseData<?> deleteUser(@Min(1) @PathVariable("userId") Integer userId) {
        System.out.println("Delete User Status: " + userId);
        return new ResponseData<>(HttpStatus.NO_CONTENT.value(), "User deleted successfully");
    }

    @GetMapping("/{userId}")
    public ResponseData<UserCreateRequest> getUser(@Min(1) @PathVariable("userId") Integer userId) {
        System.out.println("Get User Status: " + userId);
        return new ResponseData<>(HttpStatus.OK.value(), "User", new UserCreateRequest("XuanAnh", "LuuViet", "luuviet@gmail.com", "0988987071"));
    }

    @GetMapping("/list")
    public ResponseData<List<UserCreateRequest>> getUsers() {
        return new ResponseData<>(HttpStatus.OK.value(), "User", List.of(new UserCreateRequest("XuanAnh", "LuuViet", "luuviet@gmail.com", "0988987071")));
    }
}
