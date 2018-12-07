package cn.lzy.server.softwareautomationms.dao;

import cn.lzy.server.softwareautomationms.model.BugLevel;

public interface BugLevelMapper {
    int deleteByPrimaryKey(Integer bugLevelId);

    int insert(BugLevel record);

    int insertSelective(BugLevel record);

    BugLevel selectByPrimaryKey(Integer bugLevelId);

    int updateByPrimaryKeySelective(BugLevel record);

    int updateByPrimaryKey(BugLevel record);
}