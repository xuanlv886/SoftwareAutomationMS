package cn.lzy.server.softwareautomationms.dao;

import cn.lzy.server.softwareautomationms.model.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-mybatis.xml")
//配置事务的回滚,对数据库的增删改都会回滚,便于测试用例的循环利用
@TransactionConfiguration(defaultRollback=true)
@Transactional //事务处理
public class UserMapperTest {

    @Resource
    UserMapper userMapper;

    @Test
    public void deleteByPrimaryKey() {
        Assert.assertEquals(1, userMapper.deleteByPrimaryKey(1));
    }

    @Test
    public void insert() {
        User user = new User();
        user.setUserId(0);
        user.setUserRoleId(2);
        user.setUserAccount("123");
        user.setUserPassword("123456");
        user.setUserName("刘子誉");
        user.setUserSex(1);
        user.setUserPhone("18132653088");
        user.setUserEmail("liuziyu886@qq.com");
        user.setUserLeader(1);
        user.setUserLastLoginTime(new Date());
//        user.setUserVisitCount(100);
        user.setCreateByUser(1);
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        Assert.assertEquals(1, userMapper.insert(user));
        System.out.println("userId:" + user.getUserId().toString());
        System.out.println(userMapper.selectByPrimaryKey(user.getUserId()).toString());
    }

    @Test
    public void insertSelective() {
        User user = new User();
        user.setUserId(0);
        user.setUserRoleId(2);
        user.setUserAccount("123");
        user.setUserPassword("123");
        user.setUserName("刘子誉");
        user.setUserSex(1);
        user.setUserPhone("18132653088");
//        user.setUserEmail("liuziyu886@qq.com");
        user.setUserLeader(1);
        user.setCreateByUser(1);
        user.setUserLastLoginTime(new Date());
        user.setUserVisitCount(100);
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        Assert.assertEquals(1, userMapper.insertSelective(user));
        System.out.println(userMapper.selectByPrimaryKey(user.getUserId()).toString());
        Assert.assertEquals(null, userMapper.selectByPrimaryKey(user.getUserId()).getUserEmail());
    }

    @Test
    public void selectByPrimaryKey() {
        Assert.assertEquals("admin", userMapper.selectByPrimaryKey(1).getUserAccount());
    }

    @Test
    public void updateByPrimaryKeySelective() {
    }

    @Test
    public void updateByPrimaryKey() {
    }

    @Test
    public void selectByAccountAndPassword() {
        Assert.assertNull(userMapper.selectByAccountAndPassword(
                "123", "456"));
        Assert.assertEquals("管理员", userMapper.selectByAccountAndPassword(
                "admin", "123456").getUserName());
    }
}