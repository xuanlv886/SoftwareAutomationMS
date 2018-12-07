package cn.lzy.server.softwareautomationms.dao;

import com.google.common.collect.Lists;
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
public class TestPlanUserRelationMapperTest {

    @Resource
    TestPlanUserRelationMapper testPlanUserRelationMapper;

    @Test
    public void getTotalTestPlan() {
        int count = testPlanUserRelationMapper.getTotalTestPlan(Lists.newArrayList(1, 2),
                6);
        System.out.println(count);
    }
}