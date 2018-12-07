package cn.lzy.server.softwareautomationms.dao;

import cn.lzy.server.softwareautomationms.model.ApiRequestParameter;

public interface ApiRequestParameterMapper {
    int deleteByPrimaryKey(Integer requestParameterId);

    int insert(ApiRequestParameter record);

    int insertSelective(ApiRequestParameter record);

    ApiRequestParameter selectByPrimaryKey(Integer requestParameterId);

    int updateByPrimaryKeySelective(ApiRequestParameter record);

    int updateByPrimaryKey(ApiRequestParameter record);
}