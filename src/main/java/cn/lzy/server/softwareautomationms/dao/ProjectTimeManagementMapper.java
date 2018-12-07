package cn.lzy.server.softwareautomationms.dao;

import cn.lzy.server.softwareautomationms.model.ProjectTimeManagement;

public interface ProjectTimeManagementMapper {
    int deleteByPrimaryKey(Integer projectTimeManagementId);

    int insert(ProjectTimeManagement record);

    int insertSelective(ProjectTimeManagement record);

    ProjectTimeManagement selectByPrimaryKey(Integer projectTimeManagementId);

    int updateByPrimaryKeySelective(ProjectTimeManagement record);

    int updateByPrimaryKey(ProjectTimeManagement record);
}