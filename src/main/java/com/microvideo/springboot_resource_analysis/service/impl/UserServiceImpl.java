package com.microvideo.springboot_resource_analysis.service.impl;


import com.microvideo.springboot_resource_analysis.domain.User;
import com.microvideo.springboot_resource_analysis.mapper.UserMapper;
import com.microvideo.springboot_resource_analysis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

/**
 * 〈一句话功能简述〉:UserService 的实现类
 * @author njtech
 * @create 2019/6/8
 * @since 1.0.0
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private UserMapper userMapper;

    @Override
    public int addUser(User user) {
        int rows = userMapper.addUser(user);
//        int i = 1 / 0;
        return rows;
    }

    @Override
    public void updateUserBySelf(User user) {
        userMapper.updateUser(user);
    }

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public int saveAndUpdateUserBySelf(User user) {
        int rows = userService.addUser(user);

        User updateUser = new User();
        updateUser.setAge(2222);
        userService.updateUserBySelf(updateUser);
        return rows;
    }
}