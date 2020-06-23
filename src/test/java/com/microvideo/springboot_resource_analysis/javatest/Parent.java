package com.microvideo.springboot_resource_analysis.javatest;

/**
 * @Description: TODO
 * @Author: Hujm
 * @Date: Created in 23:25 2020/4/26
 * @Version: 1.0
 */
public abstract class Parent {
    static {
        System.out.println("parent init");
    }

    public static String value = "hehehe";
}
