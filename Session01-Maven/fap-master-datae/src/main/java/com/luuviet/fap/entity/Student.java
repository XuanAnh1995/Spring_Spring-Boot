package com.luuviet.fap.entity;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
// Thay bằng @Data là đủ
public class Student {

    private String id;

    private String name;

    private int yob;

    private double gpa;

}
