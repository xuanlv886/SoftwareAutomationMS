package cn.lzy.server.softwareautomationms.dao;

import cn.lzy.server.softwareautomationms.model.SystemOperationLog;

public interface SystemOperationLogMapper {
    int deleteByPrimaryKey(Integer operationLogId);

    int insert(SystemOperationLog record);

    int insertSelective(SystemOperationLog record);

    SystemOperationLog selectByPrimaryKey(Integer operationLogId);

    int updateByPrimaryKeySelective(SystemOperationLog record);

    int updateByPrimaryKey(SystemOperationLog record);
}