package cn.lzy.server.softwareautomationms.model;

import java.util.Date;

public class TestPlanTypeDetail {
    private Integer planTypeDetailId;

    private Integer planTypeId;

    private String planTypeDetailName;

    private Integer createByUser;

    private Date createTime;

    private Date updateTime;

    public Integer getPlanTypeDetailId() {
        return planTypeDetailId;
    }

    public void setPlanTypeDetailId(Integer planTypeDetailId) {
        this.planTypeDetailId = planTypeDetailId;
    }

    public Integer getPlanTypeId() {
        return planTypeId;
    }

    public void setPlanTypeId(Integer planTypeId) {
        this.planTypeId = planTypeId;
    }

    public String getPlanTypeDetailName() {
        return planTypeDetailName;
    }

    public void setPlanTypeDetailName(String planTypeDetailName) {
        this.planTypeDetailName = planTypeDetailName == null ? null : planTypeDetailName.trim();
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