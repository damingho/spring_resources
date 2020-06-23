package com.microvideo.springboot_resource_analysis.domain;

import java.util.List;

/**
 * @Description: 模板消息类
 * @Author: Hujm
 * @Date: Created in 9:33 2020/6/5
 * @Version: 1.0
 */
public class Template {
    private String toUser;
    private String templateId;
    private String url;
    private String topColor;
    private List<TemplateParam> templateParamList;

    public String getToUser() {
        return this.toUser;
    }

    public void setToUser(String toUser) {
        this.toUser = toUser;
    }

    public String getTemplateId() {
        return this.templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTopColor() {
        return this.topColor;
    }

    public void setTopColor(String topColor) {
        this.topColor = topColor;
    }

    public String toJSON() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("{");
        buffer.append(String.format("\"touser\":\"%s\"", new Object[]{this.toUser})).append(",");
        buffer.append(String.format("\"template_id\":\"%s\"", new Object[]{this.templateId})).append(",");
        buffer.append(String.format("\"url\":\"%s\"", new Object[]{this.url})).append(",");
        buffer.append(String.format("\"topcolor\":\"%s\"", new Object[]{this.topColor})).append(",");
        buffer.append("\"data\":{");
        TemplateParam param = null;
        for (int i = 0; i < this.templateParamList.size(); i++) {
            param = (TemplateParam) this.templateParamList.get(i);
            if (i < this.templateParamList.size() - 1) {
                buffer.append(String.format("\"%s\": {\"value\":\"%s\",\"color\":\"%s\"},", new Object[]{param.getName(), param.getValue(), param.getColor()}));
            } else {
                buffer.append(String.format("\"%s\": {\"value\":\"%s\",\"color\":\"%s\"}", new Object[]{param.getName(), param.getValue(), param.getColor()}));
            }
        }
        buffer.append("}");
        buffer.append("}");
        return buffer.toString();
    }

    public List<TemplateParam> getTemplateParamList() {
        return this.templateParamList;
    }

    public void setTemplateParamList(List<TemplateParam> templateParamList) {
        this.templateParamList = templateParamList;
    }
}