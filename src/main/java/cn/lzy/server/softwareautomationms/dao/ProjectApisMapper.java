package cn.lzy.server.softwareautomationms.dao;

import cn.lzy.server.softwareautomationms.model.ProjectApis;

public interface ProjectApisMapper {
    int deleteByPrimaryKey(Integer apiId);

    int insert(ProjectApis record);

    int insertSelective(ProjectApis record);

    ProjectApis selectByPrimaryKey(Integer apiId);

    int updateByPrimaryKeySelective(ProjectApis record);

    int updateByPrimaryKey(ProjectApis record);
}