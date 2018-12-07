package cn.lzy.server.softwareautomationms.model;

import java.util.Date;

public class ProjectApis {
    private Integer apiId;

    private Integer projectId;

    private String apiDesc;

    private String apiHost;

    private String apiRequestUrl;

    private Integer apiRequestType;

    private String apiRequestExample;

    private String apiResponseExample;

    private Integer apiStatus;

    private Integer createByUser;

    private Date createTime;

    private Date updateTime;

    public Integer getApiId() {
        return apiId;
    }

    public void setApiId(Integer apiId) {
        this.apiId = apiId;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public String getApiDesc() {
        return apiDesc;
    }

    public void setApiDesc(String apiDesc) {
        this.apiDesc = apiDesc == null ? null : apiDesc.trim();
    }

    public String getApiHost() {
        return apiHost;
    }

    public void setApiHost(String apiHost) {
        this.apiHost = apiHost == null ? null : apiHost.trim();
    }

    public String getApiRequestUrl() {
        return apiRequestUrl;
    }

    public void setApiRequestUrl(String apiRequestUrl) {
        this.apiRequestUrl = apiRequestUrl == null ? null : apiRequestUrl.trim();
    }

    public Integer getApiRequestType() {
        return apiRequestType;
    }

    public void setApiRequestType(Integer apiRequestType) {
        this.apiRequestType = apiRequestType;
    }

    public String getApiRequestExample() {
        return apiRequestExample;
    }

    public void setApiRequestExample(String apiRequestExample) {
        this.apiRequestExample = apiRequestExample == null ? null : apiRequestExample.trim();
    }

    public String getApiResponseExample() {
        return apiResponseExample;
    }

    public void setApiResponseExample(String apiResponseExample) {
        this.apiResponseExample = apiResponseExample == null ? null : apiResponseExample.trim();
    }

    public Integer getApiStatus() {
        return apiStatus;
    }

    public void setApiStatus(Integer apiStatus) {
        this.apiStatus = apiStatus;
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