package cn.lzy.server.softwareautomationms.model;

import java.util.Date;

public class ApiResponseParameter {
    private Integer responseParameterId;

    private Integer apiId;

    private String responseParameterName;

    private Integer responseParameterType;

    private String responseParameterDesc;

    private Integer createByUser;

    private Date createTime;

    private Date updateTime;

    public Integer getResponseParameterId() {
        return responseParameterId;
    }

    public void setResponseParameterId(Integer responseParameterId) {
        this.responseParameterId = responseParameterId;
    }

    public Integer getApiId() {
        return apiId;
    }

    public void setApiId(Integer apiId) {
        this.apiId = apiId;
    }

    public String getResponseParameterName() {
        return responseParameterName;
    }

    public void setResponseParameterName(String responseParameterName) {
        this.responseParameterName = responseParameterName == null ? null : responseParameterName.trim();
    }

    public Integer getResponseParameterType() {
        return responseParameterType;
    }

    public void setResponseParameterType(Integer responseParameterType) {
        this.responseParameterType = responseParameterType;
    }

    public String getResponseParameterDesc() {
        return responseParameterDesc;
    }

    public void setResponseParameterDesc(String responseParameterDesc) {
        this.responseParameterDesc = responseParameterDesc == null ? null : responseParameterDesc.trim();
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