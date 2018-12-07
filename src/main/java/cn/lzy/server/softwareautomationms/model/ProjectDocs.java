package cn.lzy.server.softwareautomationms.model;

import java.util.Date;

public class ProjectDocs {
    private Integer projectDocId;

    private Integer projectId;

    private String projectDocName;

    private String projectDocAddress;

    private Integer createByUser;

    private Date createTime;

    private Date updateTime;

    public Integer getProjectDocId() {
        return projectDocId;
    }

    public void setProjectDocId(Integer projectDocId) {
        this.projectDocId = projectDocId;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public String getProjectDocName() {
        return projectDocName;
    }

    public void setProjectDocName(String projectDocName) {
        this.projectDocName = projectDocName == null ? null : projectDocName.trim();
    }

    public String getProjectDocAddress() {
        return projectDocAddress;
    }

    public void setProjectDocAddress(String projectDocAddress) {
        this.projectDocAddress = projectDocAddress == null ? null : projectDocAddress.trim();
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