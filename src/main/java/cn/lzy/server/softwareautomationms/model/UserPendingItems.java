package cn.lzy.server.softwareautomationms.model;

import java.util.Date;

public class UserPendingItems {
    private Integer itemId;

    private Integer userId;

    private String itemContent;

    private Date itemWorkTime;

    private Integer itemStatus;

    private Date createTime;

    private Date updateTime;

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getItemContent() {
        return itemContent;
    }

    public void setItemContent(String itemContent) {
        this.itemContent = itemContent == null ? null : itemContent.trim();
    }

    public Date getItemWorkTime() {
        return itemWorkTime;
    }

    public void setItemWorkTime(Date itemWorkTime) {
        this.itemWorkTime = itemWorkTime;
    }

    public Integer getItemStatus() {
        return itemStatus;
    }

    public void setItemStatus(Integer itemStatus) {
        this.itemStatus = itemStatus;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}