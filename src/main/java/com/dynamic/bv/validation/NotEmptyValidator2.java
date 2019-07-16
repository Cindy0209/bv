package com.dynamic.bv.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @ClassName NotEmptyValidator2
 * @Description 组合约束
 * @Author oker
 * @Date 2019-07-16 12:14
 **/
public class NotEmptyValidator2 implements ConstraintValidator<NotEmpty2,Object> {
    public NotEmptyValidator2() {
    }

    @Override
    public boolean isValid(final Object object, final ConstraintValidatorContext constraintValidatorContext) {
        if (object == null || object == "") {
            return false;
        } else {
            return true;
        }
    }
}
