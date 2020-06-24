package com.microvideo.springboot_resource_analysis.controller;
 
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipaySystemOauthTokenRequest;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.alipay.api.response.AlipaySystemOauthTokenResponse;
import com.microvideo.springboot_resource_analysis.config.AlipayConfig;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ProjectName: lnsf2019_project
 * @Package: com.lnsf.payment.controller
 * @ClassName: PayController
 * @Author: Mr.chenzy
 * @Description: ${description}
 * @Date: 2019/7/30 9:49
 * @Version: 1.0
 */
@RestController
public class PayController {

    @RequestMapping("userInfos")
    public String userInfos() {
        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);

        AlipaySystemOauthTokenRequest request = new AlipaySystemOauthTokenRequest();
        request.setCode("2e4248c2f50b4653bf18ecee3466UC18");
        request.setGrantType("authorization_code");
        try {
            AlipaySystemOauthTokenResponse oauthTokenResponse = alipayClient.execute(request);
            System.out.println(oauthTokenResponse.getAccessToken());
            return "调用成功";
        } catch (AlipayApiException e) {
            //处理异常
            e.printStackTrace();
        }
        return "调用失败";
    }
 
    @RequestMapping("/toPay")
    @ResponseBody
    public String toPay() throws Exception{
        //获得初始化的AlipayClient
        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);
 
        //设置请求参数
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        alipayRequest.setReturnUrl(AlipayConfig.return_url);
        alipayRequest.setNotifyUrl(AlipayConfig.notify_url);
        try {
            alipayRequest.setBizContent("{\"out_trade_no\":\"1592897136824\","
                    + "\"total_amount\":\""+ 100 +"\","
                    + "\"subject\":\""+ "测试支付" +"\","
                    + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
 
            //请求
            String result;
            result = alipayClient.pageExecute(alipayRequest).getBody();
            System.out.println("*********************\n返回结果为："+result);
            return result;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
    }
 
    @RequestMapping("alipay/callback/return_sult")
    public String toIndex(){
        return "index";
    }
}