package com.dynamic.bv.validation.cascade;

import javax.validation.Valid;

/**
 * @ClassName Order
 * @Description 级联约束
 * @Author oker
 * @Date 2019-07-12 11:00
 **/
public class Order {
    @Valid
    private Person person;

    public Person getPerson() {
        return person;
    }
    public void setPerson(final Person person) {
        this.person = person;
    }
}
