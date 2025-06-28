package com.luuviet.javademo.util;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Arrays;

public class GenderSubsetValidator implements ConstraintValidator<GenderSubset, Gender> {

    private Gender[] genders;

    @Override
    public void initialize(GenderSubset genderSubset) {
        this.genders = genderSubset.value();
    }

    @Override
    public boolean isValid(Gender gender, ConstraintValidatorContext context) {
        return gender == null || Arrays.stream(genders).anyMatch(g -> g.equals(gender));
    }
}
