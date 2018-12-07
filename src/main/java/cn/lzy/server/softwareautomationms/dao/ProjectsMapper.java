package cn.lzy.server.softwareautomationms.dao;

import cn.lzy.server.softwareautomationms.model.Projects;

import java.util.List;

public interface ProjectsMapper {
    int deleteByPrimaryKey(Integer projectId);

    int insert(Projects record);

    int insertSelective(Projects record);

    Projects selectByPrimaryKey(Integer projectId);

    int updateByPrimaryKeySelective(Projects record);

    int updateByPrimaryKey(Projects record);

    /**
     * 获取所有的项目
     * @return
     */
    List<Projects> selectAllProjects();

    /**
     * 获取所有未完结的项目（状态不为 已完结 已挂起）
     * @return
     */
    List<Projects> selectAllUnCompleteProjects();
}