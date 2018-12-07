package cn.lzy.server.softwareautomationms.dao;

import cn.lzy.server.softwareautomationms.model.UserDailyLog;

public interface UserDailyLogMapper {
    int deleteByPrimaryKey(Integer dailyLogId);

    int insert(UserDailyLog record);

    int insertSelective(UserDailyLog record);

    UserDailyLog selectByPrimaryKey(Integer dailyLogId);

    int updateByPrimaryKeySelective(UserDailyLog record);

    int updateByPrimaryKey(UserDailyLog record);
}