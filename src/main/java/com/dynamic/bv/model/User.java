package com.dynamic.bv.model;

import com.dynamic.bv.validation.NotEmpty2;
import com.dynamic.bv.validation.Number;

import javax.validation.constraints.Email;

/**
 * @ClassName User
 * @Description
 * @Author oker
 * @Date 2019-07-08 18:46
 **/
public class User {
    /**
     * @NotNull://CharSequence, Collection, Map 和 Array 对象不能是 null, 但可以是空集（size = 0）。  
     * @NotEmpty://CharSequence, Collection, Map 和 Array 对象不能是 null 并且相关对象的 size 大于 0。  
     * @NotBlank://String 不是 null 且去除两端空白字符后的长度（trimmed length）大于 0。 
     */

    public Integer id;

   //@NotEmpty(message = "{user.username}{null}")
   @NotEmpty2(message = "{user.username}{null}")
    public String username;

    public Integer age;

    @Email(message = "email格式不正确")
    public String email;
    @Number
    public String phoneNumber;

    public Integer getId() {
        return id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(final String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(final Integer age) {
        this.age = age;
    }

    public String getEmail() {

        return email;
    }

    public void setEmail(final String email) {

        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(final String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("com.dynamic.bv.model.User{");
        sb.append("id=").append(id);
        sb.append(", username='").append(username).append('\'');
        sb.append(", age=").append(age);
        sb.append(", email='").append(email).append('\'');
        sb.append(", phoneNumber='").append(phoneNumber).append('\'');
        sb.append('}');
        return sb.toString();
    }
}