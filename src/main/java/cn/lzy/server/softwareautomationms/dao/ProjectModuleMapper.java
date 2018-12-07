package cn.lzy.server.softwareautomationms.dao;

import cn.lzy.server.softwareautomationms.model.ProjectModule;

import java.util.List;

public interface ProjectModuleMapper {
    int deleteByPrimaryKey(Integer projectModuleId);

    int insert(ProjectModule record);

    int insertSelective(ProjectModule record);

    ProjectModule selectByPrimaryKey(Integer projectModuleId);

    int updateByPrimaryKeySelective(ProjectModule record);

    int updateByPrimaryKey(ProjectModule record);

    /**
     * 根据项目获取模块
     * @param projectIdList
     * @return
     */
    List<ProjectModule> getAllProjectModuleByProjectId(List<Integer> projectIdList);
}