package cn.lzy.server.softwareautomationms.model;

public class SystemOperationLogDetailWithBLOBs extends SystemOperationLogDetail {
    private String operatedKeyOldValue;

    private String operatedKeyNowValue;

    public String getOperatedKeyOldValue() {
        return operatedKeyOldValue;
    }

    public void setOperatedKeyOldValue(String operatedKeyOldValue) {
        this.operatedKeyOldValue = operatedKeyOldValue == null ? null : operatedKeyOldValue.trim();
    }

    public String getOperatedKeyNowValue() {
        return operatedKeyNowValue;
    }

    public void setOperatedKeyNowValue(String operatedKeyNowValue) {
        this.operatedKeyNowValue = operatedKeyNowValue == null ? null : operatedKeyNowValue.trim();
    }
}