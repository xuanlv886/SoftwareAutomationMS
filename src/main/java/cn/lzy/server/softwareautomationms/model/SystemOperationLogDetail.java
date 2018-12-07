package cn.lzy.server.softwareautomationms.model;

public class SystemOperationLogDetail {
    private Integer operationLogDetailId;

    private Integer operationLogId;

    private Integer fieldId;

    public Integer getOperationLogDetailId() {
        return operationLogDetailId;
    }

    public void setOperationLogDetailId(Integer operationLogDetailId) {
        this.operationLogDetailId = operationLogDetailId;
    }

    public Integer getOperationLogId() {
        return operationLogId;
    }

    public void setOperationLogId(Integer operationLogId) {
        this.operationLogId = operationLogId;
    }

    public Integer getFieldId() {
        return fieldId;
    }

    public void setFieldId(Integer fieldId) {
        this.fieldId = fieldId;
    }
}