package com.microvideo.springboot_resource_analysis.config;
import java.io.FileWriter;
import java.io.IOException;
 
public class AlipayConfig {
 
	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public static String app_id = "2016102500756368";
 
	// 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCo5h0gwoLK9fEIeYgJki+Mki7aS9MuPre+RwByMnBxxALOky/VV3chPVPsiYD/6WujSy+9/XRxDHMHwThqKOwDwyiVoUzANnM6Aaax6GtA9dFxZkaaeP+ezfuE7SAV1GA5s+90bysgIDFt8QAV42Vr5jIT9R1QO0qR+HmCyxK9K6ogu6cj/qvI2gKQqJDZ+FUAWImitScG3HpU++MnDPgOzMbJA/+glh+1Ee2T+Yyg8nGOnszgyYLthn4EhqzQ6zAIBL/3LVMRhFm6uSk0mfkWXTcq2caVoRYH3bRdJitaL32jMAjze60ABihJLDNGVNSOatlEySY+0yC5FI+7V7KRAgMBAAECggEAYt9au9vCL0gsUta6QUgXl8XXsajjtlW2wKfV5gQK+T5SmlVlkhGCxq2dHIIeRzGA9nXEPAdMjAVKrYZ6HQNZrpYngviK8pate46N4+X4K237rtO9jx44HeHdVKJvvve1YPIpwlJ1v3e5F/AWKboVnEWEmVRLVbVv4OXBVETG8n/Rz3YC7ebB5dZYYNiLjzNQbkT1L5XD/H+x9Lq8D3W1swBtomuWP8Nuu5LQtGwfF21PMbJY8SJCxLd92nP77xCmyRC8HjEvKpKClh508JiGmzKRRVPi7GqMs1trnq2TzescR7XShVqViXk5gQ1sU+Tzms9OHPMo3h3FGcZ7n7NCAQKBgQDjIqpcJnxm/KtrpGhORXSfpbyZOPeEun/ksghjTiosWk0mvjHTWutCEXwkUlmFQviu6RQOlhwAZ/ODSaI5IwP79X9FIph8E5noTk9QP10zWU7MV6+ey3+Izsg1NeUmlKHFbVUc4xHK+oN5JV0y47hCqOYF6tcvnWCc2RKz2q9EsQKBgQC+XNrqAlXZfu4RvX0o2FSZ7NAp5t5Tnj69rvv0ho1qtkCrkuPkK7Zrb1PAMyjlkpggkMeI05FfHBHPq9HaMveZbuwSdKwGdO0qG42FBWcAvaRxuaWjv0jhSyco3FZ0eF7XmaU7TUSz/GCIfU3SO/6aRAn3q17zW/JG3Ml/ifJD4QKBgEdmzFsvlgfiAhlSk5+XYfQV69XW/Khy4GWKOezN06AhuwMk4xDoEfCxAm+Am7eyt+50QuPa+G6APyLUcPS5NzVrlVisaXcHymgmxfQaFzhfKNA/+GtY2XyuVG21xZV9P+WKWyk7kIpYeiAJSOUIhRIfej/99St4s7ha3PBBHLvhAoGAXzHGE4GpdsM/wEVXAobz/6lqC5o1EfGvhGGuA4EJ1RRg0Kv7JI4rghxA8Htk9zDQvHBKKAVMzBgYXBabMZeNNABBM5V+tRfhxc3TfnLOKJOtWWWyDGnKw0c2xPsyjLnpC7383+Pq+Gq7x2WJ9hkkX/aoWV8sc1xGkuM0LIBKU2ECgYBFZcZHiA01AtkmeYHgeiLvUxiKsg1SH9HtpBmNS4WRQLK/2GA+srP3KMi2YWO/nKHyH3XXA1MqtTt9/zjsN8tdLE/H3IdmC44f/7QQS+04DaAyt3OXs+VR//QlFt/K7dWcz6Hl4MXWgBk5a7SY7zcaM7qUtA2I5eATohX6tWRDbg==";
 
	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA31Q52i7zO/UDF8FXhZEz/fa+boPUEpRZzLzLcP1NPI6gXNQbo78nLnWFWSxiBKImizTYTucEl7paSpxrqc2EIEfbwFhPgWZbcpIiJCIg2mL9Exl1TtZPRV6c8DnSafasoQCLxNP9/7/5DRKlybsG4qp7JxO8y0q9a61wuOGFhEnxze82UJcuY6KzUFhhtQtvSgEB4F9iiInOXjUOj+hvKPafoCaOuTXUkxTCBlTdAPbw/J+N0+dMEJqHg0wZaFPlSIkFItzBd+yPWFKO6zkWRZJ1mUac1bt68JQcz3YCVWWDweMdLiBJ8xAM0C5QxpYwIzM50yFGNgsTbwuWYnMEXwIDAQAB";
 
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
	public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
 
	// 支付宝网关
	public static String log_path = "C:\\";
 
 
}
 