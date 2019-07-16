package com.dynamic.bv.validation.group;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

/**
 * @ClassName Dog
 * @Description 组的验证
 * @Author oker
 * @Date 2019-07-16 10:55
 **/
public class Dog implements Animal {
    private String name;
    private String ownername;

    private String type;

    public void setType(final String type) {
        this.type = type;
    }
    @Override
    public String getName() {
        return null;
    }
    @Override
    public String getOwnerName() {
        return null;
    }
    @NotEmpty(message = "type of the dog may be empty")
    public String getType() {
        return type;
    }
    public static void main(final String[] args) {
        final Dog dog = new Dog();
        final ValidatorFactory vf = Validation.buildDefaultValidatorFactory();
        final Validator validator = vf.getValidator();
        final Set<ConstraintViolation<Dog>> set = validator.validate(dog);
        for (final ConstraintViolation<Dog> constraintViolation : set) {
            System.out.println(constraintViolation.getMessage());
        }
    }
}