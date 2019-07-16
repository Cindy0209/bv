package com.dynamic.bv.validation.group;

import javax.validation.constraints.NotEmpty;

/**
 * @ClassName Animal
 * @Description 组的验证
 * @Author oker
 * @Date 2019-07-12 10:55
 **/
public interface Animal {
    @NotEmpty
    String getName();
    @NotEmpty
    String getOwnerName();
}
