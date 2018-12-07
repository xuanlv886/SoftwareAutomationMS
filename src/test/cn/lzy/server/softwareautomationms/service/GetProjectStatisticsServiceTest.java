package cn.lzy.server.softwareautomationms.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author lzy
 * @Desc
 * @Version 1.0
 * @Date 2018-11-26 15:14
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-mybatis.xml")
public class GetProjectStatisticsServiceTest {
    @Resource
    WebService webService;

    @Test
    public void doGetProjectStatisticsServiceTest1() {
        try {
            Map<String, Object> map = webService.doGetProjectStatistics("1");
            System.out.println(map.toString());
            Assert.assertNotNull(map);
        } catch (Exception e) {
            Assert.assertEquals(e.getMessage(),
                    "projectId can not null");
        }
    }
}
