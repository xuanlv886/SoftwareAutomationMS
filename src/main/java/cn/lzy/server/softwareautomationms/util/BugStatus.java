package cn.lzy.server.softwareautomationms.util;

/**
 * @author lzy
 * @Desc 缺陷状态枚举类
 * @Version 1.0
 * @Date 2018-11-27 11:03
 */
public enum BugStatus {

    /**
     * @Desc 状态说明
     **/
    NEW("新增", 0),
    WAIT_APPLY("待申领", 1),
    IN_PROCESSING("处理中", 2),
    DELAY_PROCESSING("延时处理中", 3),
    WAIT_RETEST("待复测", 4),
    PROCESSED("已处理", 5);

    private String statusName;
    private int statusCode;
    BugStatus(String statusName, int statusCode) {
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
