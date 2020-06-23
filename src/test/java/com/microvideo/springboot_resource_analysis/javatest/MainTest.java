package com.microvideo.springboot_resource_analysis.javatest;

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
    public static void main(String[] args) {
        System.out.println(StringUtils.isEmpty(" "));
        System.out.println(StringUtils.isBlank(" "));
        System.out.println(StringUtils.rightPad("test", 8, "0"));
        System.out.println(StringUtils.replaceOnce("test", "t", "0"));

        String[] array = new String[]{"test", "1234", "5678"};
        List<String> list=new ArrayList<>();
        list.add("test");
        list.add("1234");
        list.add("5678");
        System.out.println(StringUtils.join(array, ":"));
        Joiner joiner = Joiner.on(",").skipNulls();
        joiner.join(array);
        joiner.join(list);

    }
}