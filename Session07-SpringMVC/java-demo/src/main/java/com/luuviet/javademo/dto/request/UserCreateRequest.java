package com.luuviet.javademo.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.luuviet.javademo.util.*;
import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import static com.luuviet.javademo.util.Gender.*;

public class UserCreateRequest implements Serializable {

    @NotBlank(message = "firstName must be not blank")
    private String firstName;

    @NotBlank(message = "lastName must be not blank")
    private String lastName;

    @NotBlank(message = "email must be not blank")
    @Email(message = "email invalid format")
    private String email;

    @Phone(message = "") // Để trống vì thông báo được xử lý trong PhoneValidator
    private String phone;

    @NotNull(message = "dateOfBirth must be not null")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @JsonFormat(pattern = "MM/dd/yyyy")
    private LocalDate dateOfBirth;

    @NotNull
    @EnumPattern(name = "status", regex = "ACTIVE|INACTIVE|NONE")
    private UserStatus userStatus;

    @NotNull
    @GenderSubset(value = {MALE, FEMALE, OTHER})
    private Gender gender;

    @NotNull(message = "type must be not null")
    @EnumValue(enumClass = UserType.class, name = "type")
    private String type;

    @NotEmpty
    private List<String> permissions;

    public UserCreateRequest() {
    }

    public UserCreateRequest(String firstName, String lastName, String email, String phone, LocalDate dateOfBirth, UserStatus userStatus, Gender gender, List<String> permissions) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.dateOfBirth = dateOfBirth;
        this.userStatus = userStatus;
        this.gender = gender;
        this.permissions = permissions;
    }

    public UserCreateRequest(String firstName, String lastName, String email, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public List<String> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<String> permissions) {
        this.permissions = permissions;
    }

    public UserStatus getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(UserStatus userStatus) {
        this.userStatus = userStatus;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
