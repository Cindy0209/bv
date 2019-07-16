package com.dynamic.bv.service;

import com.dynamic.bv.mapper.UserMapper;
import com.dynamic.bv.model.User;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;
import java.util.List;

/**
 * user service
 * Created by Administrator on 2019/1/6.
 * commpany: yonyou
 * version:v1.0.0
 */
@Validated
@Service
public class UserService {
    @Resource
    private UserMapper userMapper;

    public User selectByPrimaryKey(final Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    public List<User> selectAll() {
        return userMapper.selectAll();
    }


    public int add(final User user) {
        return userMapper.insert(user);
    }
}

