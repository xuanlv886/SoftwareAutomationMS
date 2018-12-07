package cn.lzy.server.softwareautomationms.model;

public class ApiHeaderRelation {
    private Integer apiHeaderRelationId;

    private Integer apiId;

    private Integer headerId;

    private String apiHeaderContent;

    public Integer getApiHeaderRelationId() {
        return apiHeaderRelationId;
    }

    public void setApiHeaderRelationId(Integer apiHeaderRelationId) {
        this.apiHeaderRelationId = apiHeaderRelationId;
    }

    public Integer getApiId() {
        return apiId;
    }

    public void setApiId(Integer apiId) {
        this.apiId = apiId;
    }

    public Integer getHeaderId() {
        return headerId;
    }

    public void setHeaderId(Integer headerId) {
        this.headerId = headerId;
    }

    public String getApiHeaderContent() {
        return apiHeaderContent;
    }

    public void setApiHeaderContent(String apiHeaderContent) {
        this.apiHeaderContent = apiHeaderContent == null ? null : apiHeaderContent.trim();
    }
}