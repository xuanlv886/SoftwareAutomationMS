package cn.lzy.server.softwareautomationms.util;

/**
 * @author lzy
 * @Desc 关联用户的测试计划状态枚举类
 * @Version 1.0
 * @Date 2018-11-27 10:54
 */
public enum TestPlanUserRelationStatus {

    /**
     * @Desc 状态说明
     **/
    UN_COMPLETE("待完成", 0),
    WAIT_TEST("待测试", 1),
    NOT_PASS("未通过", 2),
    PENDING_FEEDBACK("待反馈", 3),
    ALREADY_FEEDBACK("已反馈", 4),
    PASS("已通过", 5),
    ABANDONED("已弃用", 6);

    private String statusName;
    private int statusCode;
    TestPlanUserRelationStatus(String statusName, int statusCode) {
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
