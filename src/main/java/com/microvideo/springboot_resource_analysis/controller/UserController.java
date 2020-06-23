package com.microvideo.springboot_resource_analysis.controller;

import com.microvideo.springboot_resource_analysis.domain.User;
import com.microvideo.springboot_resource_analysis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: TODO
 * @Author: Hujm
 * @Date: Created in 15:33 2020/5/27
 * @Version: 1.0
 */
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String addUserBySelf() {
        User user = new User();
        user.setId(3);
        user.setUsername("lisi");
        user.setAge(23);

        userService.saveAndUpdateUserBySelf(user);
        return "success";
    }

}
