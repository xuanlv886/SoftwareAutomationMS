package cn.lzy.server.softwareautomationms.model;

public class TableComment {
    private Integer tableId;

    private String tableName;

    private String tableComment;

    private Integer tableUseless;

    public Integer getTableId() {
        return tableId;
    }

    public void setTableId(Integer tableId) {
        this.tableId = tableId;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName == null ? null : tableName.trim();
    }

    public String getTableComment() {
        return tableComment;
    }

    public void setTableComment(String tableComment) {
        this.tableComment = tableComment == null ? null : tableComment.trim();
    }

    public Integer getTableUseless() {
        return tableUseless;
    }

    public void setTableUseless(Integer tableUseless) {
        this.tableUseless = tableUseless;
    }
}