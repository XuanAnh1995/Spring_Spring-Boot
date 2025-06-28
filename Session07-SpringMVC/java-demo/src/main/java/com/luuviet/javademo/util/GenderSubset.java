package com.luuviet.javademo.util;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER})
@Constraint(validatedBy = {GenderSubsetValidator.class})
public @interface GenderSubset {
    Gender[] value();
    String message() default "Invalid gender";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
