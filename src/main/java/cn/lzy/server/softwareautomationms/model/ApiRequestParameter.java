package cn.lzy.server.softwareautomationms.model;

import java.util.Date;

public class ApiRequestParameter {
    private Integer requestParameterId;

    private Integer apiId;

    private String requestParameterName;

    private Integer requestParameterType;

    private Integer requestParameterRequired;

    private Integer requestParameterLength;

    private String requestParameterDefaultValue;

    private String requestParameterDesc;

    private Integer createByUser;

    private Date createTime;

    private Date updateTime;

    public Integer getRequestParameterId() {
        return requestParameterId;
    }

    public void setRequestParameterId(Integer requestParameterId) {
        this.requestParameterId = requestParameterId;
    }

    public Integer getApiId() {
        return apiId;
    }

    public void setApiId(Integer apiId) {
        this.apiId = apiId;
    }

    public String getRequestParameterName() {
        return requestParameterName;
    }

    public void setRequestParameterName(String requestParameterName) {
        this.requestParameterName = requestParameterName == null ? null : requestParameterName.trim();
    }

    public Integer getRequestParameterType() {
        return requestParameterType;
    }

    public void setRequestParameterType(Integer requestParameterType) {
        this.requestParameterType = requestParameterType;
    }

    public Integer getRequestParameterRequired() {
        return requestParameterRequired;
    }

    public void setRequestParameterRequired(Integer requestParameterRequired) {
        this.requestParameterRequired = requestParameterRequired;
    }

    public Integer getRequestParameterLength() {
        return requestParameterLength;
    }

    public void setRequestParameterLength(Integer requestParameterLength) {
        this.requestParameterLength = requestParameterLength;
    }

    public String getRequestParameterDefaultValue() {
        return requestParameterDefaultValue;
    }

    public void setRequestParameterDefaultValue(String requestParameterDefaultValue) {
        this.requestParameterDefaultValue = requestParameterDefaultValue == null ? null : requestParameterDefaultValue.trim();
    }

    public String getRequestParameterDesc() {
        return requestParameterDesc;
    }

    public void setRequestParameterDesc(String requestParameterDesc) {
        this.requestParameterDesc = requestParameterDesc == null ? null : requestParameterDesc.trim();
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