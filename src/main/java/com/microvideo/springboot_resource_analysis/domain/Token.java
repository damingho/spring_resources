package com.microvideo.springboot_resource_analysis.domain;
/**
 * @Description: 微信access token信息
 * @Author: Hujm
 * @Date: Created in 9:35 2020/6/5
 * @Version: 1.0
 */
public class Token {
    /**
     * 访问凭证
     */
    private String accessToken;
    /**
     * 过期时间
     */
    private int expiresIn;
    /**
     * 获取token的时间
     */
    private long getTokenTime;

    public long getGetTokenTime() {
        return this.getTokenTime;
    }

    public void setGetTokenTime(long getTokenTime) {
        this.getTokenTime = getTokenTime;
    }

    public String getAccessToken() {
        return this.accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public int getExpiresIn() {
        return this.expiresIn;
    }

    public void setExpiresIn(int expiresIn) {
        this.expiresIn = expiresIn;
    }
}