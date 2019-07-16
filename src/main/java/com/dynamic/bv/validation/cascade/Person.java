package com.dynamic.bv.validation.cascade;

import javax.validation.constraints.NotEmpty;

/**
 * @ClassName Person
 * @Description 级联约束
 * @Author oker
 * @Date 2019-07-12 10:59
 **/
public class Person {
    @NotEmpty
    private String name;

    public String getName() {
        return name;
    }
    public void setName(final String name) {
        this.name = name;
    }
}
