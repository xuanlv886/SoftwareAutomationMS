package cn.lzy.server.softwareautomationms.dao;

import cn.lzy.server.softwareautomationms.model.ProjectUserRelation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProjectUserRelationMapper {
    int deleteByPrimaryKey(Integer projectUserRelationId);

    int insert(ProjectUserRelation record);

    int insertSelective(ProjectUserRelation record);

    ProjectUserRelation selectByPrimaryKey(Integer projectUserRelationId);

    int updateByPrimaryKeySelective(ProjectUserRelation record);

    int updateByPrimaryKey(ProjectUserRelation record);

    int getAllProjectByUserIdAndProjectIdList(
            @Param("projectIdList")List<Integer> projectIdList,
            @Param("userId") Integer userId);
}