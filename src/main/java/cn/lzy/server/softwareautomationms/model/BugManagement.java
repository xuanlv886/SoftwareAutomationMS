package cn.lzy.server.softwareautomationms.model;

import java.util.Date;

public class BugManagement {
    private Integer bugId;

    private Integer projectId;

    private Integer projectModuleId;

    private Integer bugLevelId;

    private Integer bugPriorityId;

    private Integer bugPresenter;

    private Date createTime;

    private Date updateTime;

    private Integer planId;

    private String bugTitle;

    private String bugDesc;

    private Integer bugStatus;

    public Integer getBugId() {
        return bugId;
    }

    public void setBugId(Integer bugId) {
        this.bugId = bugId;
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

    public Integer getBugLevelId() {
        return bugLevelId;
    }

    public void setBugLevelId(Integer bugLevelId) {
        this.bugLevelId = bugLevelId;
    }

    public Integer getBugPriorityId() {
        return bugPriorityId;
    }

    public void setBugPriorityId(Integer bugPriorityId) {
        this.bugPriorityId = bugPriorityId;
    }

    public Integer getBugPresenter() {
        return bugPresenter;
    }

    public void setBugPresenter(Integer bugPresenter) {
        this.bugPresenter = bugPresenter;
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

    public Integer getPlanId() {
        return planId;
    }

    public void setPlanId(Integer planId) {
        this.planId = planId;
    }

    public String getBugTitle() {
        return bugTitle;
    }

    public void setBugTitle(String bugTitle) {
        this.bugTitle = bugTitle == null ? null : bugTitle.trim();
    }

    public String getBugDesc() {
        return bugDesc;
    }

    public void setBugDesc(String bugDesc) {
        this.bugDesc = bugDesc == null ? null : bugDesc.trim();
    }

    public Integer getBugStatus() {
        return bugStatus;
    }

    public void setBugStatus(Integer bugStatus) {
        this.bugStatus = bugStatus;
    }
}