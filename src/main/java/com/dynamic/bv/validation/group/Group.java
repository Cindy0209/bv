package com.dynamic.bv.validation.group;

import javax.validation.GroupSequence;
import javax.validation.groups.Default;

/**
 * @ClassName Group
 * @Description TODO
 * @Author oker
 * @Date 2019-07-12 10:48
 **/
@GroupSequence({GroupA.class, Default.class,GroupB.class})
public interface Group {

}
