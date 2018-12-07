package cn.lzy.server.softwareautomationms.model;

import java.util.Date;

public class TestPlanType {
    private Integer planTypeId;

    private String planTypeName;

    private Integer createByUser;

    private Date createTime;

    private Date updateTime;

    public Integer getPlanTypeId() {
        return planTypeId;
    }

    public void setPlanTypeId(Integer planTypeId) {
        this.planTypeId = planTypeId;
    }

    public String getPlanTypeName() {
        return planTypeName;
    }

    public void setPlanTypeName(String planTypeName) {
        this.planTypeName = planTypeName == null ? null : planTypeName.trim();
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