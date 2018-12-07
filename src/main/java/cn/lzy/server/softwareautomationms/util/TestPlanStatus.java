package cn.lzy.server.softwareautomationms.util;

/**
 * @author lzy
 * @Desc 测试计划状态枚举类
 * @Version 1.0
 * @Date 2018-11-27 10:49
 */
public enum TestPlanStatus {

    /**
     * @Desc 状态说明
     **/
    NOT_ACTIVE("未激活", 0),
    ACTIVATED("已激活", 1),
    UNASSIGNED("待指派", 2),
    ABANDONED("已弃用", 3);

    private String statusName;
    private int statusCode;
    TestPlanStatus(String statusName, int statusCode) {
        this.statusName = statusName;
        this.statusCode = statusCode;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }
}
