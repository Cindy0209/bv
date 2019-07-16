package com.dynamic.bv.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;


@Target({ANNOTATION_TYPE, METHOD, FIELD,ElementType.CONSTRUCTOR,ElementType.PARAMETER})   // 约束注解应用的目标元素类型(METHOD, FIELD, TYPE, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER等)
@Retention(RUNTIME)   // 约束注解应用的时机
@Documented
@Constraint(validatedBy ={NumberValidator.class})  //
public @interface Number {

    String message() default "手机号格式不正确";   // 约束注解验证时的输出消息

    Class<?>[] groups() default { };  // 约束注解在验证时所属的组别

    Class<? extends Payload>[] payload() default { }; // 约束注解的有效负载

    /**
     * 数字的验证规则
     * @return
     */
    String regexp() default "^[0-9]*$";

    @Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
    @Retention(RUNTIME)
    @Documented
    @interface List {
        Number[] value();
    }
}
