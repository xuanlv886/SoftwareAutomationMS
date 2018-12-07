package cn.lzy.server.softwareautomationms.model;

import java.util.Date;

public class ProjectTimeManagement {
    private Integer projectTimeManagementId;

    private Integer projectId;

    private String projectTimeManagementDesc;

    private Date startTime;

    private Date endTime;

    private Integer principal;

    private Integer createByUser;

    private Date createTime;

    private Date updateTime;

    public Integer getProjectTimeManagementId() {
        return projectTimeManagementId;
    }

    public void setProjectTimeManagementId(Integer projectTimeManagementId) {
        this.projectTimeManagementId = projectTimeManagementId;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public String getProjectTimeManagementDesc() {
        return projectTimeManagementDesc;
    }

    public void setProjectTimeManagementDesc(String projectTimeManagementDesc) {
        this.projectTimeManagementDesc = projectTimeManagementDesc == null ? null : projectTimeManagementDesc.trim();
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getPrincipal() {
        return principal;
    }

    public void setPrincipal(Integer principal) {
        this.principal = principal;
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