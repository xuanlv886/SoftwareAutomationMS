package cn.lzy.server.softwareautomationms.dao;

import cn.lzy.server.softwareautomationms.model.HttpHeaders;

public interface HttpHeadersMapper {
    int deleteByPrimaryKey(Integer headerId);

    int insert(HttpHeaders record);

    int insertSelective(HttpHeaders record);

    HttpHeaders selectByPrimaryKey(Integer headerId);

    int updateByPrimaryKeySelective(HttpHeaders record);

    int updateByPrimaryKey(HttpHeaders record);
}