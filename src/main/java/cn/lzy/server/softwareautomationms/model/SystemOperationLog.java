package cn.lzy.server.softwareautomationms.model;

import java.util.Date;

public class SystemOperationLog {
    private Integer operationLogId;

    private Integer tableId;

    private Integer operationByUser;

    private Integer operationType;

    private Date operationTime;

    public Integer getOperationLogId() {
        return operationLogId;
    }

    public void setOperationLogId(Integer operationLogId) {
        this.operationLogId = operationLogId;
    }

    public Integer getTableId() {
        return tableId;
    }

    public void setTableId(Integer tableId) {
        this.tableId = tableId;
    }

    public Integer getOperationByUser() {
        return operationByUser;
    }

    public void setOperationByUser(Integer operationByUser) {
        this.operationByUser = operationByUser;
    }

    public Integer getOperationType() {
        return operationType;
    }

    public void setOperationType(Integer operationType) {
        this.operationType = operationType;
    }

    public Date getOperationTime() {
        return operationTime;
    }

    public void setOperationTime(Date operationTime) {
        this.operationTime = operationTime;
    }
}