package com.microvideo.springboot_resource_analysis.javatest;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePayRequest;
import com.alipay.api.request.AlipayUserCertifyOpenInitializeRequest;
import com.alipay.api.response.AlipayTradePayResponse;
import com.alipay.api.response.AlipayUserCertifyOpenInitializeResponse;
import com.google.common.base.Joiner;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 测试
 * @Author: Hujm
 * @Date: Created in 19:35 2020/4/23
 * @Version: 1.0
 */
public class MainTest {

    private static final String privateKey = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCo5h0gwoLK9fEIeYgJki+Mki7aS9MuPre+RwByMnBxxALOky/VV3chPVPsiYD/6WujSy+9/XRxDHMHwThqKOwDwyiVoUzANnM6Aaax6GtA9dFxZkaaeP+ezfuE7SAV1GA5s+90bysgIDFt8QAV42Vr5jIT9R1QO0qR+HmCyxK9K6ogu6cj/qvI2gKQqJDZ+FUAWImitScG3HpU++MnDPgOzMbJA/+glh+1Ee2T+Yyg8nGOnszgyYLthn4EhqzQ6zAIBL/3LVMRhFm6uSk0mfkWXTcq2caVoRYH3bRdJitaL32jMAjze60ABihJLDNGVNSOatlEySY+0yC5FI+7V7KRAgMBAAECggEAYt9au9vCL0gsUta6QUgXl8XXsajjtlW2wKfV5gQK+T5SmlVlkhGCxq2dHIIeRzGA9nXEPAdMjAVKrYZ6HQNZrpYngviK8pate46N4+X4K237rtO9jx44HeHdVKJvvve1YPIpwlJ1v3e5F/AWKboVnEWEmVRLVbVv4OXBVETG8n/Rz3YC7ebB5dZYYNiLjzNQbkT1L5XD/H+x9Lq8D3W1swBtomuWP8Nuu5LQtGwfF21PMbJY8SJCxLd92nP77xCmyRC8HjEvKpKClh508JiGmzKRRVPi7GqMs1trnq2TzescR7XShVqViXk5gQ1sU+Tzms9OHPMo3h3FGcZ7n7NCAQKBgQDjIqpcJnxm/KtrpGhORXSfpbyZOPeEun/ksghjTiosWk0mvjHTWutCEXwkUlmFQviu6RQOlhwAZ/ODSaI5IwP79X9FIph8E5noTk9QP10zWU7MV6+ey3+Izsg1NeUmlKHFbVUc4xHK+oN5JV0y47hCqOYF6tcvnWCc2RKz2q9EsQKBgQC+XNrqAlXZfu4RvX0o2FSZ7NAp5t5Tnj69rvv0ho1qtkCrkuPkK7Zrb1PAMyjlkpggkMeI05FfHBHPq9HaMveZbuwSdKwGdO0qG42FBWcAvaRxuaWjv0jhSyco3FZ0eF7XmaU7TUSz/GCIfU3SO/6aRAn3q17zW/JG3Ml/ifJD4QKBgEdmzFsvlgfiAhlSk5+XYfQV69XW/Khy4GWKOezN06AhuwMk4xDoEfCxAm+Am7eyt+50QuPa+G6APyLUcPS5NzVrlVisaXcHymgmxfQaFzhfKNA/+GtY2XyuVG21xZV9P+WKWyk7kIpYeiAJSOUIhRIfej/99St4s7ha3PBBHLvhAoGAXzHGE4GpdsM/wEVXAobz/6lqC5o1EfGvhGGuA4EJ1RRg0Kv7JI4rghxA8Htk9zDQvHBKKAVMzBgYXBabMZeNNABBM5V+tRfhxc3TfnLOKJOtWWWyDGnKw0c2xPsyjLnpC7383+Pq+Gq7x2WJ9hkkX/aoWV8sc1xGkuM0LIBKU2ECgYBFZcZHiA01AtkmeYHgeiLvUxiKsg1SH9HtpBmNS4WRQLK/2GA+srP3KMi2YWO/nKHyH3XXA1MqtTt9/zjsN8tdLE/H3IdmC44f/7QQS+04DaAyt3OXs+VR//QlFt/K7dWcz6Hl4MXWgBk5a7SY7zcaM7qUtA2I5eATohX6tWRDbg==";
    private static final String publicKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA31Q52i7zO/UDF8FXhZEz/fa+boPUEpRZzLzLcP1NPI6gXNQbo78nLnWFWSxiBKImizTYTucEl7paSpxrqc2EIEfbwFhPgWZbcpIiJCIg2mL9Exl1TtZPRV6c8DnSafasoQCLxNP9/7/5DRKlybsG4qp7JxO8y0q9a61wuOGFhEnxze82UJcuY6KzUFhhtQtvSgEB4F9iiInOXjUOj+hvKPafoCaOuTXUkxTCBlTdAPbw/J+N0+dMEJqHg0wZaFPlSIkFItzBd+yPWFKO6zkWRZJ1mUac1bt68JQcz3YCVWWDweMdLiBJ8xAM0C5QxpYwIzM50yFGNgsTbwuWYnMEXwIDAQAB";
    public static void main(String[] args) throws AlipayApiException {

        AlipayClient alipayClient = new DefaultAlipayClient("https://openapi.alipaydev.com/gateway.do","2016102500756368",privateKey,"json","GBK",publicKey,"RSA2");
        AlipayTradePayRequest request = new AlipayTradePayRequest();
        request.setBizContent("{" +
                "\"out_trade_no\":\"1592895760993\"," +
                "\"scene\":\"bar_code\"," +
                "\"auth_code\":\"28763443825664394\"," +
                "\"product_code\":\"FACE_TO_FACE_PAYMENT\"," +
                "\"subject\":\"Iphone6 16G\"" +
                "  }");
        AlipayTradePayResponse response = alipayClient.execute(request);
        if(response.isSuccess()){
            System.out.println("调用成功");
        } else {
            System.out.println("调用失败");
        }
    }
}