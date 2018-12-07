package cn.lzy.server.softwareautomationms.dao;

import cn.lzy.server.softwareautomationms.model.SystemOperationLogDetail;
import cn.lzy.server.softwareautomationms.model.SystemOperationLogDetailWithBLOBs;

public interface SystemOperationLogDetailMapper {
    int deleteByPrimaryKey(Integer operationLogDetailId);

    int insert(SystemOperationLogDetailWithBLOBs record);

    int insertSelective(SystemOperationLogDetailWithBLOBs record);

    SystemOperationLogDetailWithBLOBs selectByPrimaryKey(Integer operationLogDetailId);

    int updateByPrimaryKeySelective(SystemOperationLogDetailWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(SystemOperationLogDetailWithBLOBs record);

    int updateByPrimaryKey(SystemOperationLogDetail record);
}