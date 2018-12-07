package cn.lzy.server.softwareautomationms.model;

public class UserRole {
    private Integer userRoleId;

    private String userRoleName;

    private Integer userRoleLevel;

    public Integer getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(Integer userRoleId) {
        this.userRoleId = userRoleId;
    }

    public String getUserRoleName() {
        return userRoleName;
    }

    public void setUserRoleName(String userRoleName) {
        this.userRoleName = userRoleName == null ? null : userRoleName.trim();
    }

    public Integer getUserRoleLevel() {
        return userRoleLevel;
    }

    public void setUserRoleLevel(Integer userRoleLevel) {
        this.userRoleLevel = userRoleLevel;
    }
}