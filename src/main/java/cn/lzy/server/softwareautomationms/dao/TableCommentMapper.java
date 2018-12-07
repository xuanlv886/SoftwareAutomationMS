package cn.lzy.server.softwareautomationms.dao;

import cn.lzy.server.softwareautomationms.model.TableComment;

public interface TableCommentMapper {
    int deleteByPrimaryKey(Integer tableId);

    int insert(TableComment record);

    int insertSelective(TableComment record);

    TableComment selectByPrimaryKey(Integer tableId);

    int updateByPrimaryKeySelective(TableComment record);

    int updateByPrimaryKey(TableComment record);
}