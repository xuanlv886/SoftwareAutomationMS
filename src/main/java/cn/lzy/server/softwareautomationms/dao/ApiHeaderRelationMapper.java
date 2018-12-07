package cn.lzy.server.softwareautomationms.dao;

import cn.lzy.server.softwareautomationms.model.ApiHeaderRelation;

public interface ApiHeaderRelationMapper {
    int deleteByPrimaryKey(Integer apiHeaderRelationId);

    int insert(ApiHeaderRelation record);

    int insertSelective(ApiHeaderRelation record);

    ApiHeaderRelation selectByPrimaryKey(Integer apiHeaderRelationId);

    int updateByPrimaryKeySelective(ApiHeaderRelation record);

    int updateByPrimaryKey(ApiHeaderRelation record);
}