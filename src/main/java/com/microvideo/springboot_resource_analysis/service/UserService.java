package com.microvideo.springboot_resource_analysis.service;

import com.microvideo.springboot_resource_analysis.domain.User;

/**
 * @Description: TODO
 * @Author: Hujm
 * @Date: Created in 17:40 2020/4/28
 * @Version: 1.0
 */
public interface UserService {
    int addUser(User user);
    public int saveAndUpdateUserBySelf(User user);

    void updateUserBySelf(User user);
}
