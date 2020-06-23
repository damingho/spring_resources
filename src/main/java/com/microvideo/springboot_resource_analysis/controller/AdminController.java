package com.microvideo.springboot_resource_analysis.controller;

import io.swagger.annotations.*;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: TODO
 * @Author: Hujm
 * @Date: Created in 15:33 2020/5/27
 * @Version: 1.0
 */
@Api(tags = "AdminController", value = "administrator")
@RestController
public class AdminController {

    @ApiOperation(value = "test", notes = "must do it")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "username", value = "用户名", required = true, dataType = "String"),
            @ApiImplicitParam(paramType = "query", name = "age", value = "年龄", required = true, dataType = "int")
    })
    @RequestMapping(value = "test", method = RequestMethod.GET)
    public String test(@RequestParam("username") String username, @RequestParam("age") Integer age) {
        return "hello, " + username + age;
    }

}
