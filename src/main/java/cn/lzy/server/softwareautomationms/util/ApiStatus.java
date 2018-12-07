package cn.lzy.server.softwareautomationms.util;

/**
 * @author lzy
 * @Desc
 * @Version 1.0
 * @Date 2018-11-27 11:08
 */
public enum ApiStatus {

    /**
     * @Desc 状态说明
     **/
    NORMAL("正常", 0),
    DEVELOPING("开发中", 1),
    ABANDONED("已弃用", 2);

    private String statusName;
    private int statusCode;
    ApiStatus(String statusName, int statusCode) {
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
