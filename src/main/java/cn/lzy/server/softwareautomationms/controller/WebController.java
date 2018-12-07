package cn.lzy.server.softwareautomationms.controller;

import cn.lzy.server.softwareautomationms.service.WebService;
import cn.lzy.server.softwareautomationms.util.Utils;
import com.google.common.base.Strings;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Map;

/**
 * web端API控制器
 * @author lzy
 * @date 2018/11/22 10:34
 * @version 1.0
 **/
@Controller
public class WebController {

    @Resource
    private WebService webService;
    /**
     * 用户登录接口
     * @author lzy
     * @date 2018/11/22 14:01
     * @param userAccount 用户账号
     * @param userPassword 用户密码
     * @return java.util.Map<java.lang.String,java.lang.Object>
     **/
    @RequestMapping(value="/webLogin")
    @ResponseBody
    public Map<String,Object> doWebLogin (String userAccount, String userPassword){
        if (Strings.isNullOrEmpty(userAccount)) {
            return Utils.packageResponseData(false,
                    "账号不能为空！", null);
        }
        if (Strings.isNullOrEmpty(userPassword)) {
            return Utils.packageResponseData(false,
                    "密码不能为空！", null);
        }
        if (Utils.ACCOUNT_MAX_LENGTH < userAccount.length()) {
            return Utils.packageResponseData(false,
                    "账号长度不能超过20位！", null);
        }
        if (Utils.PASSWORD_MIN_LENGTH > userPassword.length()
                || Utils.PASSWORD_MAX_LENGTH < userPassword.length()) {
            return Utils.packageResponseData(false,
                    "密码长度必须大于6位，且小于16位！", null);
        }
        return Utils.generatorResponseData(webService.doWebLogin(userAccount, userPassword));
    }

    /**
     * 项目列表接口
     * @author lzy
     * @date 2018/11/26 16:31
     * @param userId 用户主键标识
     * @return java.util.Map<java.lang.String,java.lang.Object>
     **/
    @RequestMapping(value="/getProjects")
    @ResponseBody
    public Map<String,Object> doGetProjects (String userId){
        if (Strings.isNullOrEmpty(userId)) {
            return Utils.packageResponseData(false,
                    "请提交用户主键标识！", null);
        }
        return Utils.generatorResponseData(webService.doGetProjects(userId));
    }

    /**
     * 项目统计接口
     * @author lzy
     * @date 2018/11/26 14:42
     * @param projectId 项目主键标识
     * @return java.util.Map<java.lang.String,java.lang.Object>
     **/
    @RequestMapping(value="/getProjectStatistics")
    @ResponseBody
    public Map<String,Object> doGetProjectStatistics (String projectId){
        if (Strings.isNullOrEmpty(projectId)) {
            return Utils.packageResponseData(false,
                    "请提交项目主键标识！", null);
        }
        return Utils.generatorResponseData(webService.doGetProjectStatistics(projectId));
    }

    /**
     * 用户待办事项接口
     * @author lzy
     * @date 2018/11/27 16:03
     * @param userId 用户主键标识
     * @param currentPage 当前页，从1开始
     * @param pageSize 页大小
     * @return java.util.Map<java.lang.String,java.lang.Object>
     **/
    @RequestMapping(value="/getUserPendingItems")
    @ResponseBody
    public Map<String,Object> doGetUserPendingItems (String userId, String currentPage,
                                                     String pageSize){
        if (Strings.isNullOrEmpty(userId)) {
            return Utils.packageResponseData(false,
                    "请提交用户主键标识！", null);
        }
        if (Strings.isNullOrEmpty(currentPage)) {
            return Utils.packageResponseData(false,
                    "请提交要查询的页数！", null);
        }
        if (1 > Integer.valueOf(currentPage)) {
            return Utils.packageResponseData(false,
                    "页数需从1开始！", null);
        }
        if (Strings.isNullOrEmpty(pageSize)) {
            return Utils.packageResponseData(false,
                    "请提交要查询的每页的记录的条数！", null);
        }
        if (1 > Integer.valueOf(pageSize)) {
            return Utils.packageResponseData(false,
                    "要查询的每页的记录条数不能小于1！", null);
        }
        return Utils.generatorResponseData(webService.doGetUserPendingItems(userId,
                currentPage, pageSize));
    }

    /**
     * 项目总览接口
     * @author lzy
     * @date 2018/11/27 16:30
     * @param userId 用户主键标识
     * @return java.util.Map<java.lang.String,java.lang.Object>
     **/
    @RequestMapping(value="/getProjectsOverview")
    @ResponseBody
    public Map<String,Object> doGetProjectsOverview (String userId){
        if (Strings.isNullOrEmpty(userId)) {
            return Utils.packageResponseData(false,
                    "请提交用户主键标识！", null);
        }
        return Utils.generatorResponseData(webService.doGetProjectsOverview(userId));
    }

    /**
     * 工作内容接口
     * @author lzy
     * @date 2018/11/27 17:03
     * @param userId 用户主键标识
     * @param userRoleLevel 用户角色等级
     * @return java.util.Map<java.lang.String,java.lang.Object>
     **/
    @RequestMapping(value="/getMyJobContent")
    @ResponseBody
    public Map<String,Object> doGetMyJobContent (String userId, String userRoleLevel){
        if (Strings.isNullOrEmpty(userId)) {
            return Utils.packageResponseData(false,
                    "请提交用户主键标识！", null);
        }
        if (Strings.isNullOrEmpty(userRoleLevel)) {
            return Utils.packageResponseData(false,
                    "请提交用户角色等级！", null);
        }
        return Utils.generatorResponseData(webService.doGetMyJobContent(userId, userRoleLevel));
    }

    /**
     * 获取项目状态列表
     * @author lzy
     * @date 2018/11/28 17:18
     * @param userId 用户主键标识
     * @return java.util.Map<java.lang.String,java.lang.Object>
     **/
    @RequestMapping(value="/getProjectStatusList")
    @ResponseBody
    public Map<String,Object> doGetProjectStatusList (String userId){
        if (Strings.isNullOrEmpty(userId)) {
            return Utils.packageResponseData(false,
                    "请提交用户主键标识！", null);
        }
        return Utils.generatorResponseData(webService.doGetProjectStatusList(userId));
    }
}
