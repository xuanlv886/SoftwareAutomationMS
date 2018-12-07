package cn.lzy.server.softwareautomationms.model;

import java.util.Date;

public class TestPlanUserRelation {
    private Integer planUserRelationId;

    private Integer planId;

    private Integer userId;

    private Integer planActualResult;

    private String planFeedback;

    private Integer createByUser;

    private Date createTime;

    private Date updateTime;

    public Integer getPlanUserRelationId() {
        return planUserRelationId;
    }

    public void setPlanUserRelationId(Integer planUserRelationId) {
        this.planUserRelationId = planUserRelationId;
    }

    public Integer getPlanId() {
        return planId;
    }

    public void setPlanId(Integer planId) {
        this.planId = planId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getPlanActualResult() {
        return planActualResult;
    }

    public void setPlanActualResult(Integer planActualResult) {
        this.planActualResult = planActualResult;
    }

    public String getPlanFeedback() {
        return planFeedback;
    }

    public void setPlanFeedback(String planFeedback) {
        this.planFeedback = planFeedback == null ? null : planFeedback.trim();
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