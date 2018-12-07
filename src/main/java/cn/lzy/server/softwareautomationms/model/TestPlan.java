package cn.lzy.server.softwareautomationms.model;

import java.util.Date;

public class TestPlan {
    private Integer planId;

    private Integer projectId;

    private Integer projectModuleId;

    private String planName;

    private String planContent;

    private String planRequired;

    private String planResult;

    private Integer planStatus;

    private Integer createByUser;

    private Date createTime;

    private Date updateTime;

    public Integer getPlanId() {
        return planId;
    }

    public void setPlanId(Integer planId) {
        this.planId = planId;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public Integer getProjectModuleId() {
        return projectModuleId;
    }

    public void setProjectModuleId(Integer projectModuleId) {
        this.projectModuleId = projectModuleId;
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName == null ? null : planName.trim();
    }

    public String getPlanContent() {
        return planContent;
    }

    public void setPlanContent(String planContent) {
        this.planContent = planContent == null ? null : planContent.trim();
    }

    public String getPlanRequired() {
        return planRequired;
    }

    public void setPlanRequired(String planRequired) {
        this.planRequired = planRequired == null ? null : planRequired.trim();
    }

    public String getPlanResult() {
        return planResult;
    }

    public void setPlanResult(String planResult) {
        this.planResult = planResult == null ? null : planResult.trim();
    }

    public Integer getPlanStatus() {
        return planStatus;
    }

    public void setPlanStatus(Integer planStatus) {
        this.planStatus = planStatus;
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