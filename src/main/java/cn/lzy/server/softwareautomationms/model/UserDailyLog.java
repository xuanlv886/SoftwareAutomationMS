package cn.lzy.server.softwareautomationms.model;

import java.util.Date;

public class UserDailyLog {
    private Integer dailyLogId;

    private Integer userId;

    private Integer projectId;

    private Integer projectModuleId;

    private String dailyLogContent;

    private String dailyLogTime;

    private Date createTime;

    public Integer getDailyLogId() {
        return dailyLogId;
    }

    public void setDailyLogId(Integer dailyLogId) {
        this.dailyLogId = dailyLogId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public Integer getProjectModuleId() {
        return projectModuleId;
    }

    public void setProjectModuleId(Integer projectModuleId) {
        this.projectModuleId = projectModuleId;
    }

    public String getDailyLogContent() {
        return dailyLogContent;
    }

    public void setDailyLogContent(String dailyLogContent) {
        this.dailyLogContent = dailyLogContent == null ? null : dailyLogContent.trim();
    }

    public String getDailyLogTime() {
        return dailyLogTime;
    }

    public void setDailyLogTime(String dailyLogTime) {
        this.dailyLogTime = dailyLogTime == null ? null : dailyLogTime.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}