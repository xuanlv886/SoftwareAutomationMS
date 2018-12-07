package cn.lzy.server.softwareautomationms.dao;

import cn.lzy.server.softwareautomationms.model.ApiResponseParameter;

public interface ApiResponseParameterMapper {
    int deleteByPrimaryKey(Integer responseParameterId);

    int insert(ApiResponseParameter record);

    int insertSelective(ApiResponseParameter record);

    ApiResponseParameter selectByPrimaryKey(Integer responseParameterId);

    int updateByPrimaryKeySelective(ApiResponseParameter record);

    int updateByPrimaryKey(ApiResponseParameter record);
}