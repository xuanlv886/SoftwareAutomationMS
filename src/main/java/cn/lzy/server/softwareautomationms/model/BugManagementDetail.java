package cn.lzy.server.softwareautomationms.model;

import java.util.Date;

public class BugManagementDetail {
    private Integer bugManagementDetailId;

    private Integer bugId;

    private Integer bugMaker;

    private Date bugMakerApplyTime;

    private Date bugFixedTime;

    private Date bugActualFixedTime;

    private Integer bugRetester;

    private Date bugRetestTime;

    private Date bugRetestOverTime;

    private Date createTime;

    public Integer getBugManagementDetailId() {
        return bugManagementDetailId;
    }

    public void setBugManagementDetailId(Integer bugManagementDetailId) {
        this.bugManagementDetailId = bugManagementDetailId;
    }

    public Integer getBugId() {
        return bugId;
    }

    public void setBugId(Integer bugId) {
        this.bugId = bugId;
    }

    public Integer getBugMaker() {
        return bugMaker;
    }

    public void setBugMaker(Integer bugMaker) {
        this.bugMaker = bugMaker;
    }

    public Date getBugMakerApplyTime() {
        return bugMakerApplyTime;
    }

    public void setBugMakerApplyTime(Date bugMakerApplyTime) {
        this.bugMakerApplyTime = bugMakerApplyTime;
    }

    public Date getBugFixedTime() {
        return bugFixedTime;
    }

    public void setBugFixedTime(Date bugFixedTime) {
        this.bugFixedTime = bugFixedTime;
    }

    public Date getBugActualFixedTime() {
        return bugActualFixedTime;
    }

    public void setBugActualFixedTime(Date bugActualFixedTime) {
        this.bugActualFixedTime = bugActualFixedTime;
    }

    public Integer getBugRetester() {
        return bugRetester;
    }

    public void setBugRetester(Integer bugRetester) {
        this.bugRetester = bugRetester;
    }

    public Date getBugRetestTime() {
        return bugRetestTime;
    }

    public void setBugRetestTime(Date bugRetestTime) {
        this.bugRetestTime = bugRetestTime;
    }

    public Date getBugRetestOverTime() {
        return bugRetestOverTime;
    }

    public void setBugRetestOverTime(Date bugRetestOverTime) {
        this.bugRetestOverTime = bugRetestOverTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}