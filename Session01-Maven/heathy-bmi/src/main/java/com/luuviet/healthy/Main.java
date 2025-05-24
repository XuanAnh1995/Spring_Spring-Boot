package com.luuviet.healthy;

import com.luuviet.heath.core.BmiCalculator;

public class Main {
    public static void main(String[] args) {
        System.out.println("BMI 70kg 1.7m : "+
        new BmiCalculator().getBmi(1.7, 70)
        );
    }
}