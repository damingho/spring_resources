package com.microvideo.springboot_resource_analysis.utils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.ConnectException;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.microvideo.springboot_resource_analysis.domain.Template;
import com.microvideo.springboot_resource_analysis.domain.TemplateParam;
import com.microvideo.springboot_resource_analysis.domain.Token;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class WeixinUtils {

    private static Token token = null;

    /**
     * http请求方法
     *
     * @param requestUrl
     * @param requestMethod
     * @param outputStr
     * @return
     */
    public static String httpsRequest(String requestUrl, String requestMethod, String outputStr) {
        try {
            URL url = new URL(requestUrl);
            HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setUseCaches(false);

            conn.setRequestMethod(requestMethod);
            conn.setRequestProperty("content-type", "application/x-www-form-urlencoded");
            if (outputStr != null) {
                OutputStream outputStream = conn.getOutputStream();

                outputStream.write(outputStr.getBytes("UTF-8"));
                outputStream.close();
            }
            InputStream inputStream = conn.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String str = null;
            StringBuffer buffer = new StringBuffer();
            while ((str = bufferedReader.readLine()) != null) {
                buffer.append(str);
            }
            bufferedReader.close();
            inputStreamReader.close();
            inputStream.close();
            inputStream = null;
            conn.disconnect();
            return buffer.toString();
        } catch (ConnectException ce) {
            System.out.println("连接超时：{}");
        } catch (Exception e) {
            System.out.println("https请求异常：{}");
        }
        return null;
    }

    /**
     * url编码
     *
     * @param source
     * @return
     */
    public static String urlEncodeUTF8(String source) {
        String result = source;
        try {
            result = URLEncoder.encode(source, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 将模板消息打包成json
     *
     * @param first
     * @param keyword1
     * @param keyword2
     * @param remark
     * @return
     */
    public static JSONObject packJsonmsg(String first, String keyword1, String keyword2, String remark) {
        JSONObject json = new JSONObject();
        try {
            JSONObject jsonFirst = new JSONObject();
            jsonFirst.put("value", first);
            jsonFirst.put("color", "#173177");
            json.put("first", jsonFirst);

            JSONObject jsonKeyword1 = new JSONObject();
            jsonKeyword1.put("value", keyword1);
            jsonKeyword1.put("color", "#173177");
            json.put("keyword1", jsonKeyword1);

            JSONObject jsonKeyword2 = new JSONObject();
            jsonKeyword2.put("value", keyword2);
            jsonKeyword2.put("color", "#173177");
            json.put("keyword2", jsonKeyword2);

            JSONObject jsonRemark = new JSONObject();
            jsonRemark.put("value", remark);
            jsonRemark.put("color", "#173177");
            json.put("remark", jsonRemark);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return json;
    }

    /**
     * 发送模板消息
     *
     * @param template
     * @return
     */
    public static boolean sendTemplateMsg(String appid, String secret, Template template) {
        boolean flag = false;

        String requestUrl = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=ACCESS_TOKEN";
        requestUrl = requestUrl.replace("ACCESS_TOKEN", getToken(appid, secret).getAccessToken());
        log.info(requestUrl);
        log.info(template.toJSON());
        String Result = httpsRequest(requestUrl, "POST", template.toJSON());
        log.info(Result);
        JSONObject jsonResult = JSONObject.parseObject(Result);
        if (jsonResult != null) {
            int errorCode = jsonResult.getInteger("errcode");
            String errorMessage = jsonResult.getString("errmsg");
            if (errorCode == 0) {
                flag = true;
            } else {
                log.info("模板消息发送失败:" + errorCode + "," + errorMessage);
                flag = false;
            }
        }
        return flag;
    }

    /**
     * 构建消息内容  url为点击消息后跳转的网页
     *
     * @param openid
     * @param url
     */
    public static void sendMessage(String appid, String secret, String openid, String url, String templateId) {
        Template tem = new Template();
        //模板消息id
        tem.setTemplateId(templateId);
        tem.setTopColor("#00DD00");
        tem.setToUser(openid);
        tem.setUrl(url);

        List<TemplateParam> paras = new ArrayList();
        paras.add(new TemplateParam("User", "服务云", "#0044BB"));
        paras.add(new TemplateParam("Average","100", "#0044BB"));

        tem.setTemplateParamList(paras);

        sendTemplateMsg(appid, secret, tem);
    }

    /**
     * 获取有效的token
     *
     * @return
     * @param appid
     * @param secret
     */
    public static Token getToken(String appid, String secret) {
        if (token != null) {
            if (token.getGetTokenTime() + token.getExpiresIn() > System.currentTimeMillis()) {
                return token;
            }
        }
        String getTokenUrl = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=SECRET";
        //记得补充上appid和appsecret
        String result = httpsRequest(getTokenUrl.replace("APPID", appid).replace("SECRET", secret)
                ,"GET", null);
        JSONObject jsonObject = JSONObject.parseObject(result);
        if (jsonObject != null) {
            try {
                token = new Token();
                token.setGetTokenTime(System.currentTimeMillis());
                token.setAccessToken(jsonObject.getString("access_token"));
                token.setExpiresIn(jsonObject.getInteger("expires_in"));
            } catch (JSONException e) {
                token = null;
                log.error("获取token失败 errcode:{} errmsg:{}", Integer.valueOf(jsonObject.getInteger("errcode")), jsonObject.getString("errmsg"));
            }
        }
        return token;
    }


    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //第一个字符串是我们微信的openid
        sendMessage("wx48a7004d5e059e27", "d7568be9764b08a02a18be52f7f4ecf3", "oJSuKwG_3mmex4UiiTLAJwMlJwkg", "https://www.baidu.com/", "F9v-llZpnxgZg0u9ZORsgf3r9dSNnSp0ZgpK3r9eflI");
    }
}