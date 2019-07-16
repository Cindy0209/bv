package com.dynamic.bv.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @ClassName NumberValidator
 * @Description 数字校验器（约束校验器）
 * @Author oker
 * @Date 2019-07-12 10:01
 **/
public class NumberValidator implements ConstraintValidator<Number,Object> {

    private String regexp;
    @Override
    public void initialize(final Number constraintAnnotation) {
        this.regexp = constraintAnnotation.regexp();
    }

    @Override
    public boolean isValid(final Object value, final ConstraintValidatorContext context) {
        if (value == null){
            return true;
        } else if (value.toString().matches(regexp)){
            return true;
        }
        return false;
    }
}
