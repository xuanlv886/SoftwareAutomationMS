package cn.lzy.server.softwareautomationms.model;

import java.util.Date;

public class TestPlanTemplate {
    private Integer planTemplateId;

    private Integer planTypeDetailId;

    private String planTemplateName;

    private String planTemplateContent;

    private String planTemplateRequired;

    private String planTemplateResult;

    private Integer createByUser;

    private Date createTime;

    private Date updateTime;

    public Integer getPlanTemplateId() {
        return planTemplateId;
    }

    public void setPlanTemplateId(Integer planTemplateId) {
        this.planTemplateId = planTemplateId;
    }

    public Integer getPlanTypeDetailId() {
        return planTypeDetailId;
    }

    public void setPlanTypeDetailId(Integer planTypeDetailId) {
        this.planTypeDetailId = planTypeDetailId;
    }

    public String getPlanTemplateName() {
        return planTemplateName;
    }

    public void setPlanTemplateName(String planTemplateName) {
        this.planTemplateName = planTemplateName == null ? null : planTemplateName.trim();
    }

    public String getPlanTemplateContent() {
        return planTemplateContent;
    }

    public void setPlanTemplateContent(String planTemplateContent) {
        this.planTemplateContent = planTemplateContent == null ? null : planTemplateContent.trim();
    }

    public String getPlanTemplateRequired() {
        return planTemplateRequired;
    }

    public void setPlanTemplateRequired(String planTemplateRequired) {
        this.planTemplateRequired = planTemplateRequired == null ? null : planTemplateRequired.trim();
    }

    public String getPlanTemplateResult() {
        return planTemplateResult;
    }

    public void setPlanTemplateResult(String planTemplateResult) {
        this.planTemplateResult = planTemplateResult == null ? null : planTemplateResult.trim();
    }

    public Integer getCreateByUser() {
        return createByUser;
    }

    public void setCreateByUser(Integer createByUser) {
        this.createByUser = createByUser;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}