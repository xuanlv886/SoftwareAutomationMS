package cn.lzy.server.softwareautomationms.dao;

import cn.lzy.server.softwareautomationms.model.TestPlanType;

public interface TestPlanTypeMapper {
    int deleteByPrimaryKey(Integer planTypeId);

    int insert(TestPlanType record);

    int insertSelective(TestPlanType record);

    TestPlanType selectByPrimaryKey(Integer planTypeId);

    int updateByPrimaryKeySelective(TestPlanType record);

    int updateByPrimaryKey(TestPlanType record);
}