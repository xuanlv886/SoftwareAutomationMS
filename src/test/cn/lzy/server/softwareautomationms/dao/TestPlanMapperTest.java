package cn.lzy.server.softwareautomationms.dao;

import cn.lzy.server.softwareautomationms.model.TestPlan;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-mybatis.xml")
//配置事务的回滚,对数据库的增删改都会回滚,便于测试用例的循环利用
@TransactionConfiguration(defaultRollback=true)
@Transactional //事务处理
public class TestPlanMapperTest {

    @Resource
    TestPlanMapper testPlanMapper;

    @Test
    public void selectByProjectId() {
        TestPlan testPlan = new TestPlan();
        testPlan.setPlanId(0);
        testPlan.setPlanName("测试");
        testPlan.setPlanContent("233333");
        testPlan.setPlanRequired("4343");
        testPlan.setPlanResult("343");
        testPlan.setPlanStatus(1);
        testPlan.setProjectId(1);
        testPlan.setProjectModuleId(1);
        testPlanMapper.insert(testPlan);
        System.out.println(testPlanMapper.selectByProjectId(1,
                0, 3));
    }
}