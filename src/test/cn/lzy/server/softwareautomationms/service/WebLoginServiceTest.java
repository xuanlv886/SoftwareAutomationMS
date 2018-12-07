package cn.lzy.server.softwareautomationms.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-mybatis.xml")
public class WebLoginServiceTest {

    @Resource
    WebService webService;

    @Test
    public void doWebLogin1() {
        try {
            Map<String, Object> map = webService.doWebLogin("",
                    "");
//            System.out.println(map.toString());
            Assert.assertNotNull(map);
        } catch (Exception e) {
            Assert.assertEquals(e.getMessage(),
                    "userAccount can not null");
        }
    }

    @Test
    public void doWebLogin2() {
        try {
            Map<String, Object> map = webService.doWebLogin("123",
                    "");
//            System.out.println(map.toString());
            Assert.assertNotNull(map);
        } catch (Exception e) {
            Assert.assertEquals(e.getMessage(),
                    "userPassword can not null");
        }
    }

    @Test
    public void doWebLogin3() {
        try {
            Map<String, Object> map = webService.doWebLogin("123456789123456789121",
                    "123456789123456789121");
//            System.out.println(map.toString());
            Assert.assertNotNull(map);
        } catch (Exception e) {
            Assert.assertEquals(e.getMessage(),
                    "userAccount length error");
        }
    }

    @Test
    public void doWebLogin4() {
        try {
            Map<String, Object> map = webService.doWebLogin("123456",
                    "123456789123456789121");
//            System.out.println(map.toString());
            Assert.assertNotNull(map);
        } catch (Exception e) {
            Assert.assertEquals(e.getMessage(),
                    "userPassword length error");
        }
    }

    @Test
    public void doWebLogin5() {
        try {
            Map<String, Object> map = webService.doWebLogin("admin",
                    "123456");
//            System.out.println(map.toString());
            Assert.assertEquals("{errorString=账号或密码错误！, status=false}",
                    map.toString());
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("未处理异常！");
        }
    }

    @Test
    public void doWebLogin6() {
        try {
            Map<String, Object> map = webService.doWebLogin("admin",
                    "123456");
//            System.out.println(map.toString());
            Assert.assertEquals("{errorString=, userRoleLevel=0, userRoleId=1, userName=管理员, userId=1, userRoleName=管理员, status=true}",
                    map.toString());
        } catch (Exception e) {
            Assert.fail("未处理异常！");
        }
    }
}