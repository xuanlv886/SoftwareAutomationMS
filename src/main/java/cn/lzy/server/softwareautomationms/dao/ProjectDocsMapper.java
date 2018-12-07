package cn.lzy.server.softwareautomationms.dao;

import cn.lzy.server.softwareautomationms.model.ProjectDocs;

public interface ProjectDocsMapper {
    int deleteByPrimaryKey(Integer projectDocId);

    int insert(ProjectDocs record);

    int insertSelective(ProjectDocs record);

    ProjectDocs selectByPrimaryKey(Integer projectDocId);

    int updateByPrimaryKeySelective(ProjectDocs record);

    int updateByPrimaryKey(ProjectDocs record);
}