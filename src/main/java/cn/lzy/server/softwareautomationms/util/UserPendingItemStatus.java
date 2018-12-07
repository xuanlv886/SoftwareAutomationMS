package cn.lzy.server.softwareautomationms.util;

/**
 * @author lzy
 * @Desc 用户待办事项状态枚举类
 * @Version 1.0
 * @Date 2018-11-27 10:30
 */
public enum UserPendingItemStatus {
    /**
     * @Desc 状态说明
     **/
    NOT_STARTED("未开始", 0),
    DOING("进行中", 1),
    COMPLETE("已完成", 2),
    CLOSED("已关闭", 3);


    private String statusName;
    private int statusCode;
    UserPendingItemStatus(String statusName, int statusCode) {
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
