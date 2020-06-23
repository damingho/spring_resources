package com.microvideo.springboot_resource_analysis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;


/**
 * @Description: 启动类
 * @Author: Hujm
 * @Date: Created in 22:43 2020/4/16
 * @Version: 1.0
 */
@SpringBootApplication
@EnableScheduling
public class SpringbootResourceAnalysisApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootResourceAnalysisApplication.class, args);
    }

}
