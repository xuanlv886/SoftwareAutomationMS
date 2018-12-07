package cn.lzy.server.softwareautomationms.dao;

import cn.lzy.server.softwareautomationms.model.BugPriority;

public interface BugPriorityMapper {
    int deleteByPrimaryKey(Integer bugPriorityId);

    int insert(BugPriority record);

    int insertSelective(BugPriority record);

    BugPriority selectByPrimaryKey(Integer bugPriorityId);

    int updateByPrimaryKeySelective(BugPriority record);

    int updateByPrimaryKey(BugPriority record);
}