package com.microvideo.springboot_resource_analysis.config;
import java.io.FileWriter;
import java.io.IOException;
 
public class AlipayConfig {
 
	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public static String app_id = "2021001169631215";
 
	// 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQC8T6U2a+f/W1p3wlVX7ZJubuxPoBXMpVt9w8Ubt1l5F+UKDpo4b/EcwE1CguiFgh2bvv8V9z27JKVC9EB3X4hJyt1pXkcFjha2TjdhkYn5Ahok+plUzIkUI8H9DPDtiRqC8MUNFtw/ZcLo5bsGiPnWBdsxJjKltOIVqes84fUcJniKeSUQpTOJSt8XJ9U9YX3fsLgzzv5CUIAi2GOtRX2/a1y2B+vkzkFH9tTSwRzdp/yFGBMHaylhAVJp+9Wnex+EvZobThrIu1iyqeyd10Exd+FVUKtB+TaWH6dcsUW8pzhpw4nrQiJbK5CaUnHNuzV/dyIJdQTrKSHcdV+4qXE1AgMBAAECggEAVCnYsnEZ+JRw47O0hx8EYl0rOw9Wjuec86HK9+9Diw617H/IR88oWWxNW5u8pucXqqN7yOp+6aSgREN8iJ3nAOwtd0mOvpnZ5tMgh3gPzX42By8F1tOvtJOiwSHGkLPFaJ6Jw6bi+2bU7Vi39VzFJPXrGJV074Dfx0TxgX2QGmsG9DfAGp+/hPR/D4CZu/ZSNo7bqgx4b8Jemrz6ztxOB3suNBQpGKmvx6bHCdzE886FzcAnD6jdybk5okniL4kwFQEd31XE3LKkLpJ1jo68dQpudjad1dLRHfLxd5gjNrliOymOn1cQnSaAPrT50MgH3Nf/pItLXXBR43bO7fExBQKBgQDjapT890f6JDlJ6C6KWfFe3/2J84jh6Srvk/Uz3LS1sOmfNt2yf5LdUi1KmnbMAbfrnivTCmjQdf/PTzpdNQ32wsfnNDt8q4Pe8kpRHrsiQFi4/ePyLkgROZ+UTx1Q58hvGDYFdCebAOTCrlyRU1EFBmQfZDwaXgtYQdni1Mf5MwKBgQDT+s0/IBqZSpqq7+RrbA8z9UgHGOHMf6XLCSl+j/6JtUwE1pHBX0O5dZ7mlg2wWtY1RmpMWSDRxJpMuG+tsggzCvZYvytm+FjzTc4xKruAVRbpVrmOC+8af+wqazY5B7I7GS6xCiDz89yRTw0liL2mTiCvGtXk498IQxa7+hH79wKBgQDf3rUKDVeyu+QViFYAZihBEFkjazUtxv44WDvCsRrH3X8t97HonMNz0gi57zLRA0QN02gq2Y1y4SZQ6xp2VNsJNpfZV0bUJHetinB0SL9JKXTtryms57iUFFiug+9FDNb33iqX1c+DPC72IvUHLrCMNM1tRZwRDNE4MaMPNA4jlwKBgQDODqxZQoHYpPa4Vz05Vu9oWHRNwdgsi6DEPwHA74REpKFiypkg2dPhgf6WsyJXXdWAMBTAZptKjcxX66lTtQ3XYD6bgilUjPEagXV/wcRGOXBuHkl9VQh2QAd4LIOm6F5OqGoE2o2x1kmATtG+vK9t6+BFltZ5CzEQvPZqf+nffQKBgB2Nh4SMjjGnkG8wsMZc6lFkHFiZbBNYtMZ2+vJG8O5J+ibQsES1OMinv0mIS/f/GzR4UALnUu1Yq2EZcIrFD0UK+bH6AZmFcXOFMK8m2lej25TlWgDaIZCJZtpS1ScmmfBdptruVv2uNHWjQuvbz1S2otew+Z0ndrOhtSxSgvm7";
 
	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAg36Y4HFteC9LSrV6dbMatl/ctLsvERHJDR6H5H3LVZYzXiKP5kxCxIMy1ETppANK/R0CEN/NJJswf66358irZORzmWKILqvQlUBpj2MFDA9bXqtp8lkZDYorDSZy0N9t2/uF+ykWCJosniCz7sJpgcDRtTFzCu1NMR1UskSWL8JVCto7sz0p4MVWO1QP+gnynHNTsk2CIjgcbQzfZh0NIqC98dTjeo6CpXLzZZDOM+ow+5B9NbZZIUdInMJBirXZ6ury1Bec10PVFWGi+103Fw4z5pJFtv3zCwjrHAYml3mBCXh/eON/XaH5mWvgG8Lkdm7LZVPMTVuLuIBdHYTjbQIDAQAB";
 
	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://localhost:8080/alipay.trade.page.pay-JAVA-UTF-8/notify_url";
 
	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	/*public static String return_url = "http://localhost/alipay.trade.page.pay-JAVA-UTF-8/return_url.jsp";*/
    public static String return_url = "http://localhost:8080/alipay/callback/return_sult";
	// 签名方式，注意这里，如果步骤设置的是RSA则用RSA
	public static String sign_type = "RSA2";
 
	// 字符编码格式
	public static String charset = "utf-8";
 
	// 支付宝网关
	public static String gatewayUrl = "https://openapi.alipay.com/gateway.do";
 
	// 支付宝网关
	public static String log_path = "C:\\";

	public static final  String ALIPAY_URL = "https://openauth.alipay.com/oauth2/publicAppAuthorize.htm";
 
 
}
 