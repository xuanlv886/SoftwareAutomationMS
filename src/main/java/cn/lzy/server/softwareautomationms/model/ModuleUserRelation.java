package cn.lzy.server.softwareautomationms.model;

public class ModuleUserRelation {
    private Integer moduleUserRelationId;

    private Integer userId;

    private Integer projectModuleId;

    public Integer getModuleUserRelationId() {
        return moduleUserRelationId;
    }

    public void setModuleUserRelationId(Integer moduleUserRelationId) {
        this.moduleUserRelationId = moduleUserRelationId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getProjectModuleId() {
        return projectModuleId;
    }

    public void setProjectModuleId(Integer projectModuleId) {
        this.projectModuleId = projectModuleId;
    }
}