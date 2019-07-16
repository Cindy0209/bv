package com.dynamic.bv.controller;

import com.dynamic.bv.model.User;
import com.dynamic.bv.service.UserService;
import com.dynamic.bv.util.ResponseResult;
import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * @ClassName UserController
 * @Description
 * @Author oker
 * @Date 2019-07-08 18:41
 **/
@RequestMapping("/user")
@Controller
public class UserController {
    @Resource
    UserService userService;

    @PostMapping("/add")
    @ResponseBody
    public ResponseResult add(final User user) {
        if (StringUtils.isEmpty(user.getUsername())){
            return ResponseResult.error(-1,"用户姓名不能为空");
        }
        userService.add(user);
        return ResponseResult.success();
    }
    /**
     * 使用apache commons validationUtils校验工具类
     * @param user
     * @return
     */
    @PostMapping("/addByApacheUtils")
    @ResponseBody
    public ResponseResult addByApacheUtils(final User user) {
        final EmailValidator validator = EmailValidator.getInstance();

        if (!validator.isValid(user.getEmail())){
            return ResponseResult.error(-1,"邮箱格式错误");
        }
        userService.add(user);
        return ResponseResult.success();
    }

    /**
     * 使用spring validationUtils 校验工具类
     * @param user
     * @return
     */
    @PostMapping("/addBySpringUtils")
    @ResponseBody
    public ResponseResult addBySpringUtils(final User user) {
        final Errors errors = new BeanPropertyBindingResult(user,"user");
        ValidationUtils.rejectIfEmpty(errors,"username","EMPTY_OR_WHITESPACE",new Object[]{"arg"},"username 不能为空");

        if (errors.hasFieldErrors("username")) {
            return ResponseResult.error(-1,errors.getFieldError("username").getDefaultMessage());
        }
        userService.add(user);
        return ResponseResult.success();
    }

    /**
     * 使用BV
     * @param user
     * @return
     */
    @PostMapping("/addByBV")
    @ResponseBody
    public ResponseResult addByBV(final @Valid User user) {
        userService.add(user);
        return ResponseResult.success();
    }

}
