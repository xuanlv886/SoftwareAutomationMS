package cn.lzy.server.softwareautomationms.model;

public class ProjectUserRelation {
    private Integer projectUserRelationId;

    private Integer userId;

    private Integer projectId;

    public Integer getProjectUserRelationId() {
        return projectUserRelationId;
    }

    public void setProjectUserRelationId(Integer projectUserRelationId) {
        this.projectUserRelationId = projectUserRelationId;
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
}