package cn.lzy.server.softwareautomationms.util;

/**
 * @author lzy
 * @Desc 项目状态枚举类
 * @Version 1.0
 * @Date 2018-11-27 10:39
 */
public enum ProjectStatus {
    /**
     * @Desc 状态说明
     **/
    APPROVAL("立项", 0),
    DEVELOPING("开发中", 1),
    SYSTEM_TEST("系统联调", 2),
    PENDING_FEEDBACK("待反馈", 3),
    VERSION_ITERATION("版本迭代", 4),
    COMPLETE("已完结", 5),
    SUSPENDED("已挂起", 6),
    DELAY("已延期", 7);

    private String statusName;
    private int statusCode;
    ProjectStatus(String statusName, int statusCode) {
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
