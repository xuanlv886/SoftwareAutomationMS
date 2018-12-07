package cn.lzy.server.softwareautomationms.model;

import java.util.Date;

public class ProjectModule {
    private Integer projectModuleId;

    private Integer projectId;

    private String moduleName;

    private String moduleDesc;

    private Integer moduleFather;

    private Integer createByUser;

    private Date createTime;

    private Date updateTime;

    public Integer getProjectModuleId() {
        return projectModuleId;
    }

    public void setProjectModuleId(Integer projectModuleId) {
        this.projectModuleId = projectModuleId;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName == null ? null : moduleName.trim();
    }

    public String getModuleDesc() {
        return moduleDesc;
    }

    public void setModuleDesc(String moduleDesc) {
        this.moduleDesc = moduleDesc == null ? null : moduleDesc.trim();
    }

    public Integer getModuleFather() {
        return moduleFather;
    }

    public void setModuleFather(Integer moduleFather) {
        this.moduleFather = moduleFather;
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