package com.microvideo.springboot_resource_analysis.domain;
/**
 * @Description: 模板内容
 * @Author: Hujm
 * @Date: Created in 10:39 2020/6/5
 * @Version: 1.0
 */
public class TemplateParam {
    private String name;
    private String value;
    private String color;

    public TemplateParam(String name, String value, String color) {
        this.name = name;
        this.value = value;
        this.color = color;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}