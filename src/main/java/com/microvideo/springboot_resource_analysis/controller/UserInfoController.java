package com.microvideo.springboot_resource_analysis.controller;
 
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipaySystemOauthTokenRequest;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.alipay.api.response.AlipaySystemOauthTokenResponse;
import com.microvideo.springboot_resource_analysis.config.AlipayConfig;
import com.microvideo.springboot_resource_analysis.utils.AlipaySubmit;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @ProjectName: lnsf2019_project
 * @Package: com.lnsf.payment.controller
 * @ClassName: PayController
 * @Author: Mr.chenzy
 * @Description: ${description}
 * @Date: 2019/7/30 9:49
 * @Version: 1.0
 */
@Controller
public class UserInfoController {

    /**
     *  跳转到授权界面
     */
    @RequestMapping(value = "zhifubao")
    public String save(HttpServletRequest request, HttpServletResponse response) {
        Map<String,String> maps = new HashMap<String ,String>();
        //页面回调地址 必须与应用中的设置一样
        String return_url = "http://1m69738d49.imwork.net/zhifubao/imf";
        //回调地址必须经encode
        return_url = java.net.URLEncoder.encode(return_url);
        //重定向到授权页面
        return "redirect:"+AlipayConfig.ALIPAY_URL+"?app_id=" + AlipayConfig.app_id + "&scope=auth_user&redirect_uri=" + return_url;
    }

    /**
     * 获取用户信息
     * @param request
     * @param response
     */
    @RequestMapping(value = "zhifubao/imf")
    public void returnImf(HttpServletRequest request, HttpServletResponse response) {
        //获取支付宝GET过来反馈信息
        Map<String,String> params = new HashMap<String,String>();
        Map requestParams = request.getParameterMap();
        for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext();) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == (values.length-1)) ? valueStr + values[i]:valueStr + values[i] + ",";
            }
            params.put(name, valueStr);
        }

        String accessToken= AlipaySubmit.buildRequest(params);
        if(accessToken!=null && accessToken!=""){
            String imf  =  AlipaySubmit.get(accessToken);
            System.out.println(imf);
        }
    }
 
}