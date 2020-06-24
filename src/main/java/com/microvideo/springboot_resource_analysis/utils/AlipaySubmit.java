package com.microvideo.springboot_resource_analysis.utils;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipaySystemOauthTokenRequest;
import com.alipay.api.request.AlipayUserInfoShareRequest;
import com.alipay.api.response.AlipaySystemOauthTokenResponse;
import com.alipay.api.response.AlipayUserInfoShareResponse;
import com.microvideo.springboot_resource_analysis.config.AlipayConfig;

import java.util.Map;

public class AlipaySubmit {

    /**
     * 获取AccessToken
     * @param sParaTemp
     * @return
     */
    public static  String buildRequest(Map sParaTemp){
        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, "RSA2");
        AlipaySystemOauthTokenRequest request = new AlipaySystemOauthTokenRequest();
        request.setCode((String)sParaTemp.get("auth_code"));
        request.setGrantType("authorization_code");
        try {
            AlipaySystemOauthTokenResponse oauthTokenResponse = alipayClient.execute(request);
            System.out.println(oauthTokenResponse.getAccessToken());
            return oauthTokenResponse.getAccessToken();
        } catch (AlipayApiException e) {
            //处理异常
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取用户信息
     * @param accessToken
     * @return
     */
    public static String get(String accessToken){
        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, "RSA2");
        AlipayUserInfoShareRequest request = new AlipayUserInfoShareRequest();

        try {
            AlipayUserInfoShareResponse userinfoShareResponse = alipayClient.execute(request, accessToken);
           return  userinfoShareResponse.getBody();
        } catch (AlipayApiException e) {
            //处理异常
            e.printStackTrace();
        }
        return null;
    }

}