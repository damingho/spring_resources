package com.microvideo.springboot_resource_analysis.controller;

import com.microvideo.springboot_resource_analysis.utils.WeixinUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description: TODO
 * @Author: Hujm
 * @Date: Created in 9:52 2020/6/5
 * @Version: 1.0
 */
@RestController
@PropertySource("classpath:/wx.properties")
public class WxController {

    @Value("${appID}")
    private String APPID;
    @Value("${appsecret}")
    private String SECRET;
    @Value("${templateId}")
    private String TEMPLATEID;

    @GetMapping("/sendMsg")
    public String sendMessage() {
        WeixinUtils.sendMessage(APPID, SECRET, "o_SupuFK0qT3QaLzrMB4HB2-Knnw", "https://www.baidu.com/", TEMPLATEID);
        return "send success";
    }
}
