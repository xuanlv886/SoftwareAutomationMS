package cn.lzy.server.softwareautomationms.service;

import java.util.Map;

/**
 * web端接口
 * @author lzy
 * @date 2018/11/22 10:36
 * @version 1.0
 **/
public interface WebService {


    /**
     * 登录接口
     * @param userAccount 用户账号
     * @param userPassword 用户密码
     * @return Map<String, Object>
     */
    Map<String, Object> doWebLogin(String userAccount,  String userPassword);

    /**
     * 项目列表接口
     * @param userId 用户主键标识
     * @return Map<String, Object>
     */
    Map<String, Object> doGetProjects(String userId);

    /**
     * 项目统计接口
     * @param projectId 项目主键标识
     * @return Map<String, Object>
     */
    Map<String, Object> doGetProjectStatistics(String projectId);


    /**
     * 用户待办事项接口
     * @param userId 用户主键标识
     * @param currentPage 当前页，从1开始
     * @param pageSize 页大小
     * @return Map<String, Object>
     */
    Map<String, Object> doGetUserPendingItems(String userId, String currentPage,
                                              String pageSize);

    /**
     * 项目总览接口
     * @param userId 用户主键标识
     * @return Map<String, Object>
     */
    Map<String, Object> doGetProjectsOverview(String userId);

    /**
     * 工作内容接口
     * @param userId 用户主键标识
     * @param userRoleLevel 用户角色等级
     * @return Map<String, Object>
     */
    Map<String, Object> doGetMyJobContent(String userId, String userRoleLevel);

    /**
     * 项目状态列表接口
     * @param userId 用户主键标识
     * @return Map<String, Object>
     */
    Map<String, Object> doGetProjectStatusList(String userId);
}
