package cn.lzy.server.softwareautomationms.model;

public class BugPriority {
    private Integer bugPriorityId;

    private String bugPriorityName;

    public Integer getBugPriorityId() {
        return bugPriorityId;
    }

    public void setBugPriorityId(Integer bugPriorityId) {
        this.bugPriorityId = bugPriorityId;
    }

    public String getBugPriorityName() {
        return bugPriorityName;
    }

    public void setBugPriorityName(String bugPriorityName) {
        this.bugPriorityName = bugPriorityName == null ? null : bugPriorityName.trim();
    }
}