package cn.lzy.server.softwareautomationms.model;

public class TableFieldComment {
    private Integer fieldId;

    private Integer tableId;

    private String fidldName;

    private String fieldComment;

    private String fieldType;

    private Integer fieldLength;

    private String fieldRemark;

    private Integer fieldUseless;

    public Integer getFieldId() {
        return fieldId;
    }

    public void setFieldId(Integer fieldId) {
        this.fieldId = fieldId;
    }

    public Integer getTableId() {
        return tableId;
    }

    public void setTableId(Integer tableId) {
        this.tableId = tableId;
    }

    public String getFidldName() {
        return fidldName;
    }

    public void setFidldName(String fidldName) {
        this.fidldName = fidldName == null ? null : fidldName.trim();
    }

    public String getFieldComment() {
        return fieldComment;
    }

    public void setFieldComment(String fieldComment) {
        this.fieldComment = fieldComment == null ? null : fieldComment.trim();
    }

    public String getFieldType() {
        return fieldType;
    }

    public void setFieldType(String fieldType) {
        this.fieldType = fieldType == null ? null : fieldType.trim();
    }

    public Integer getFieldLength() {
        return fieldLength;
    }

    public void setFieldLength(Integer fieldLength) {
        this.fieldLength = fieldLength;
    }

    public String getFieldRemark() {
        return fieldRemark;
    }

    public void setFieldRemark(String fieldRemark) {
        this.fieldRemark = fieldRemark == null ? null : fieldRemark.trim();
    }

    public Integer getFieldUseless() {
        return fieldUseless;
    }

    public void setFieldUseless(Integer fieldUseless) {
        this.fieldUseless = fieldUseless;
    }
}