package cn.lzy.server.softwareautomationms.dao;

import cn.lzy.server.softwareautomationms.model.TestPlanTypeDetail;

public interface TestPlanTypeDetailMapper {
    int deleteByPrimaryKey(Integer planTypeDetailId);

    int insert(TestPlanTypeDetail record);

    int insertSelective(TestPlanTypeDetail record);

    TestPlanTypeDetail selectByPrimaryKey(Integer planTypeDetailId);

    int updateByPrimaryKeySelective(TestPlanTypeDetail record);

    int updateByPrimaryKey(TestPlanTypeDetail record);
}