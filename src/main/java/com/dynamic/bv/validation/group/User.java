package com.dynamic.bv.validation.group;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.constraints.NotEmpty;
import javax.validation.groups.Default;
import java.util.Set;

/**
 * @ClassName User
 * @Description 组序列
 * @Author oker
 * @Date 2019-07-12 10:48
 **/
public class User {
    @NotEmpty (message = "firstname may be empty")
    private String firstname;

    @NotEmpty(message = "middlename may be empty", groups = Default.class)
    private String middlename;

    @NotEmpty(message = "lastname may be empty",groups = GroupA.class)
    private String lastname;

    @NotEmpty(message = "country may be empty",groups = GroupB.class)
    private String country;

    public static void main(final String[] args){
        final User user = new User();
        user.lastname = "hmt";
        final ValidatorFactory vf = Validation.buildDefaultValidatorFactory();
        final Validator validator = vf.getValidator();
        final Set<ConstraintViolation<User>> set = validator.validate(user,Group.class);
        for (final ConstraintViolation<User> constraintViolation : set) {
            System.out.println(constraintViolation.getMessage());
        }
    }
}
