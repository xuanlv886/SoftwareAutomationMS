package cn.lzy.server.softwareautomationms.controller;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * SSM框架的Controller层测试
 * @author lzy
 * @date 2018/12/1 10:01
 * @version 1.0
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-mvc.xml", "classpath:spring-mybatis.xml"})
//配置事务的回滚,对数据库的增删改都会回滚,便于测试用例的循环利用
@TransactionConfiguration(defaultRollback=true)
@Transactional //事务处理
@WebAppConfiguration
public class WebControllerTest {

    /**
     * Content-Type
     **/
    private MediaType mediaType = MediaType.APPLICATION_FORM_URLENCODED;
    private MockMvc mockMvc;
    @Autowired
    private WebApplicationContext context;

    @Before
    public void setUp() {
        //初始化MockMvc对象
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    /**
     * webLogin接口测试
     * @author lzy
     * @date 2018/12/1 10:04
     **/
    @Test
    public void doWebLogin() {
        String response = null;
        try {
            response = mockMvc.perform(
                    post("/webLogin")
                            .contentType(mediaType)
                            .param("userAccount","admin")
                            .param("userPassword", "123456")
            ).andExpect(status().isOk())
                    //打印出请求和相应的内容
                    //                .andDo(print())
                    //将相应的数据转换为字符串
                    .andReturn().getResponse().getContentAsString();
        } catch (Exception e) {
            Assert.fail("throw exception!");
            e.printStackTrace();
        }
        Assert.assertTrue(response.contains("\"status\":true"));
    }

    /**
     * webLogin接口测试---用户账号为空字符串
     * @author lzy
     * @date 2018/12/1 10:04
     **/
    @Test
    public void doWebLoginWithUserAccountEmpty() {
        String response = null;
        try {
            response = mockMvc.perform(
                    post("/webLogin")
                            .contentType(mediaType)
                            .param("userAccount","")
                            .param("userPassword", "")
            ).andExpect(status().isOk())
                    //打印出请求和相应的内容
    //                .andDo(print())
                    //将相应的数据转换为字符串
                    .andReturn().getResponse().getContentAsString();
        } catch (Exception e) {
            Assert.fail("throw exception!");
            e.printStackTrace();
        }
        Assert.assertEquals("{\"errorString\":\"账号不能为空！\",\"flag\":false,\"data\":null}",
                response);
    }

    /**
     * webLogin接口测试---用户密码为空字符串
     * @author lzy
     * @date 2018/12/1 10:04
     **/
    @Test
    public void doWebLoginWithUserPasswordEmpty() {
        String response = null;
        try {
            response = mockMvc.perform(
                    post("/webLogin")
                            .contentType(mediaType)
                            .param("userAccount","123456")
                            .param("userPassword", "")
            ).andExpect(status().isOk())
                    //打印出请求和相应的内容
    //                .andDo(print())
                    //将相应的数据转换为字符串
                    .andReturn().getResponse().getContentAsString();
        } catch (Exception e) {
            Assert.fail("throw exception!");
            e.printStackTrace();
        }
        Assert.assertEquals("{\"errorString\":\"密码不能为空！\",\"flag\":false,\"data\":null}",
                response);
    }

    /**
     * webLogin接口测试---用户账号长度越界(超过20个字符)
     * @author lzy
     * @date 2018/12/1 10:04
     **/
    @Test
    public void doWebLoginWithUserAccountLengthOutOfBounds() {
        String response = null;
        try {
            response = mockMvc.perform(
                    post("/webLogin")
                            .contentType(mediaType)
                            .param("userAccount","123456789123456789123")
                            .param("userPassword", "123456")
            ).andExpect(status().isOk())
                    //打印出请求和相应的内容
                    //                .andDo(print())
                    //将相应的数据转换为字符串
                    .andReturn().getResponse().getContentAsString();
        } catch (Exception e) {
            Assert.fail("throw exception!");
            e.printStackTrace();
        }
        Assert.assertEquals("{\"errorString\":\"账号长度不能超过20位！\",\"flag\":false,\"data\":null}",
                response);
    }

    /**
     * webLogin接口测试---用户密码长度不合法(超过16个字符或小于6个字符)
     * @author lzy
     * @date 2018/12/1 10:04
     **/
    @Test
    public void doWebLoginWithUserPasswordLengthOutOfBounds() {
        String response = null;
        try {
            response = mockMvc.perform(
                    post("/webLogin")
                            .contentType(mediaType)
                            .param("userAccount","123456")
                            .param("userPassword", "123")
            ).andExpect(status().isOk())
                    //打印出请求和相应的内容
                    //                .andDo(print())
                    //将相应的数据转换为字符串
                    .andReturn().getResponse().getContentAsString();
        } catch (Exception e) {
            Assert.fail("throw exception!");
            e.printStackTrace();
        }
        Assert.assertEquals("{\"errorString\":\"密码长度必须大于6位，且小于16位！\",\"flag\":false,\"data\":null}",
                response);
    }

    /**
     * getProjects接口测试
     * @author lzy
     * @date 2018/12/1 13:21
     **/
    @Test
    public void doGetProjects() {
        String response = null;
        try {
            response = mockMvc.perform(
                    post("/getProjects")
                            .contentType(mediaType)
                            .param("userId","1")
            ).andExpect(status().isOk())
                    //打印出请求和相应的内容
                    //                .andDo(print())
                    //将相应的数据转换为字符串
                    .andReturn().getResponse().getContentAsString();
        } catch (Exception e) {
            Assert.fail("throw exception!");
            e.printStackTrace();
        }
        Assert.assertTrue(response.contains("\"status\":true"));
    }

    /**
     * getProjects接口测试--用户主键标识为空字符串
     * @author lzy
     * @date 2018/12/1 13:21
     **/
    @Test
    public void doGetProjectsWithUserIdEmpty() {
        String response = null;
        try {
            response = mockMvc.perform(
                    post("/getProjects")
                            .contentType(mediaType)
                            .param("userId","")
            ).andExpect(status().isOk())
                    //打印出请求和相应的内容
                    //                .andDo(print())
                    //将相应的数据转换为字符串
                    .andReturn().getResponse().getContentAsString();
        } catch (Exception e) {
            Assert.fail("throw exception!");
            e.printStackTrace();
        }
        Assert.assertEquals("{\"errorString\":\"请提交用户主键标识！\",\"flag\":false,\"data\":null}",
                response);
    }

    /**
     * getProjects接口测试--用户主键标识不存在
     * @author lzy
     * @date 2018/12/1 13:21
     **/
    @Test
    public void doGetProjectsWithUserIdNotExist() {
        String response = null;
        try {
            response = mockMvc.perform(
                    post("/getProjects")
                            .contentType(mediaType)
                            .param("userId","0")
            ).andExpect(status().isOk())
                    //打印出请求和相应的内容
                    //                .andDo(print())
                    //将相应的数据转换为字符串
                    .andReturn().getResponse().getContentAsString();
        } catch (Exception e) {
            Assert.fail("throw exception!");
            e.printStackTrace();
        }
        Assert.assertTrue(response.contains("用户不存在"));
    }

    /**
     * getProjectStatistics接口测试
     * @author lzy
     * @date 2018/12/1 13:31
     **/
    @Test
    public void doGetProjectStatistics() {
        String response = null;
        try {
            response = mockMvc.perform(
                    post("/getProjectStatistics")
                            .contentType(mediaType)
                            .param("projectId","1")
            ).andExpect(status().isOk())
                    //打印出请求和相应的内容
                    //                .andDo(print())
                    //将相应的数据转换为字符串
                    .andReturn().getResponse().getContentAsString();
        } catch (Exception e) {
            Assert.fail("throw exception!");
            e.printStackTrace();
        }
        Assert.assertTrue(response.contains("\"status\":true"));
    }

    /**
     * getProjectStatistics接口测试---projectId为空字符串
     * @author lzy
     * @date 2018/12/1 13:31
     **/
    @Test
    public void doGetProjectStatisticsWithProjectIdEmpty() {
        String response = null;
        try {
            response = mockMvc.perform(
                    post("/getProjectStatistics")
                            .contentType(mediaType)
                            .param("projectId","")
            ).andExpect(status().isOk())
                    //打印出请求和相应的内容
                    //                .andDo(print())
                    //将相应的数据转换为字符串
                    .andReturn().getResponse().getContentAsString();
        } catch (Exception e) {
            Assert.fail("throw exception!");
            e.printStackTrace();
        }
        Assert.assertEquals("{\"errorString\":\"请提交项目主键标识！\",\"flag\":false,\"data\":null}",
                response);
    }

    /**
     * getProjectStatistics接口测试---projectId不存在
     * @author lzy
     * @date 2018/12/1 13:31
     **/
    @Test
    public void doGetProjectStatisticsWithProjectIdNotExist() {
        String response = null;
        try {
            response = mockMvc.perform(
                    post("/getProjectStatistics")
                            .contentType(mediaType)
                            .param("projectId","0")
            ).andExpect(status().isOk())
                    //打印出请求和相应的内容
                    //                .andDo(print())
                    //将相应的数据转换为字符串
                    .andReturn().getResponse().getContentAsString();
        } catch (Exception e) {
            Assert.fail("throw exception!");
            e.printStackTrace();
        }
        Assert.assertTrue(response.contains("项目不存在"));
    }

    /**
     * getUserPendingItems接口测试
     * @author lzy
     * @date 2018/12/1 13:57
     **/
    @Test
    public void doGetUserPendingItems() {
        String response = null;
        try {
            response = mockMvc.perform(
                    post("/getUserPendingItems")
                            .contentType(mediaType)
                            .param("userId","1")
                            .param("currentPage","1")
                            .param("pageSize","5")
            ).andExpect(status().isOk())
                    //打印出请求和相应的内容
                    //                .andDo(print())
                    //将相应的数据转换为字符串
                    .andReturn().getResponse().getContentAsString();
        } catch (Exception e) {
            Assert.fail("throw exception!");
            e.printStackTrace();
        }
        Assert.assertTrue(response.contains("\"status\":true"));
    }

    /**
     * getUserPendingItems接口测试---用户主键标识为空字符串
     * @author lzy
     * @date 2018/12/1 13:57
     **/
    @Test
    public void doGetUserPendingItemsWithUserIdEmpty() {
        String response = null;
        try {
            response = mockMvc.perform(
                    post("/getUserPendingItems")
                            .contentType(mediaType)
                            .param("userId","")
                            .param("currentPage","1")
                            .param("pageSize","5")
            ).andExpect(status().isOk())
                    //打印出请求和相应的内容
                    //                .andDo(print())
                    //将相应的数据转换为字符串
                    .andReturn().getResponse().getContentAsString();
        } catch (Exception e) {
            Assert.fail("throw exception!");
            e.printStackTrace();
        }
        Assert.assertEquals( "{\"errorString\":\"请提交用户主键标识！\",\"flag\":false,\"data\":null}", response);
    }

    /**
     * getUserPendingItems接口测试---当前页为空字符串
     * @author lzy
     * @date 2018/12/1 13:57
     **/
    @Test
    public void doGetUserPendingItemsWithCurrentPageEmpty() {
        String response = null;
        try {
            response = mockMvc.perform(
                    post("/getUserPendingItems")
                            .contentType(mediaType)
                            .param("userId","1")
                            .param("currentPage","")
                            .param("pageSize","5")
            ).andExpect(status().isOk())
                    //打印出请求和相应的内容
                    //                .andDo(print())
                    //将相应的数据转换为字符串
                    .andReturn().getResponse().getContentAsString();
        } catch (Exception e) {
            Assert.fail("throw exception!");
            e.printStackTrace();
        }
        Assert.assertEquals( "{\"errorString\":\"请提交要查询的页数！\",\"flag\":false,\"data\":null}", response);
    }

    /**
     * getUserPendingItems接口测试---当前页页数为0
     * @author lzy
     * @date 2018/12/1 13:57
     **/
    @Test
    public void doGetUserPendingItemsWithCurrentPageIsZero() {
        String response = null;
        try {
            response = mockMvc.perform(
                    post("/getUserPendingItems")
                            .contentType(mediaType)
                            .param("userId","1")
                            .param("currentPage","0")
                            .param("pageSize","5")
            ).andExpect(status().isOk())
                    //打印出请求和相应的内容
                    //                .andDo(print())
                    //将相应的数据转换为字符串
                    .andReturn().getResponse().getContentAsString();
        } catch (Exception e) {
            Assert.fail("throw exception!");
            e.printStackTrace();
        }
        Assert.assertEquals( "{\"errorString\":\"页数需从1开始！\",\"flag\":false,\"data\":null}", response);
    }

    /**
     * getUserPendingItems接口测试---页大小为空字符串
     * @author lzy
     * @date 2018/12/1 13:57
     **/
    @Test
    public void doGetUserPendingItemsWithPageSizeEmpty() {
        String response = null;
        try {
            response = mockMvc.perform(
                    post("/getUserPendingItems")
                            .contentType(mediaType)
                            .param("userId","1")
                            .param("currentPage","1")
                            .param("pageSize","")
            ).andExpect(status().isOk())
                    //打印出请求和相应的内容
                    //                .andDo(print())
                    //将相应的数据转换为字符串
                    .andReturn().getResponse().getContentAsString();
        } catch (Exception e) {
            Assert.fail("throw exception!");
            e.printStackTrace();
        }
        Assert.assertEquals( "{\"errorString\":\"请提交要查询的每页的记录的条数！\",\"flag\":false,\"data\":null}", response);
    }

    @Test
    public void doGetProjectsOverview() {
    }

    @Test
    public void doGetMyJobContent() {
    }

    @Test
    public void doGetProjectStatusList() {
    }
}