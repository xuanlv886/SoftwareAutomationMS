package cn.lzy.server.softwareautomationms.model;

public class BugLevel {
    private Integer bugLevelId;

    private String bugLevelName;

    private String bugLevelDesc;

    public Integer getBugLevelId() {
        return bugLevelId;
    }

    public void setBugLevelId(Integer bugLevelId) {
        this.bugLevelId = bugLevelId;
    }

    public String getBugLevelName() {
        return bugLevelName;
    }

    public void setBugLevelName(String bugLevelName) {
        this.bugLevelName = bugLevelName == null ? null : bugLevelName.trim();
    }

    public String getBugLevelDesc() {
        return bugLevelDesc;
    }

    public void setBugLevelDesc(String bugLevelDesc) {
        this.bugLevelDesc = bugLevelDesc == null ? null : bugLevelDesc.trim();
    }
}