package cn.lzy.server.softwareautomationms.dao;

import cn.lzy.server.softwareautomationms.model.TestPlanTemplate;

public interface TestPlanTemplateMapper {
    int deleteByPrimaryKey(Integer planTemplateId);

    int insert(TestPlanTemplate record);

    int insertSelective(TestPlanTemplate record);

    TestPlanTemplate selectByPrimaryKey(Integer planTemplateId);

    int updateByPrimaryKeySelective(TestPlanTemplate record);

    int updateByPrimaryKey(TestPlanTemplate record);
}