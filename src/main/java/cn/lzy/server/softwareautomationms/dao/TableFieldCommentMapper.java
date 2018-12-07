package cn.lzy.server.softwareautomationms.dao;

import cn.lzy.server.softwareautomationms.model.TableFieldComment;

public interface TableFieldCommentMapper {
    int deleteByPrimaryKey(Integer fieldId);

    int insert(TableFieldComment record);

    int insertSelective(TableFieldComment record);

    TableFieldComment selectByPrimaryKey(Integer fieldId);

    int updateByPrimaryKeySelective(TableFieldComment record);

    int updateByPrimaryKey(TableFieldComment record);
}