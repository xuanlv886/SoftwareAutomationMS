package cn.lzy.server.softwareautomationms.service.impl;

import cn.lzy.server.softwareautomationms.dao.*;
import cn.lzy.server.softwareautomationms.model.*;
import cn.lzy.server.softwareautomationms.service.WebService;
import cn.lzy.server.softwareautomationms.util.*;
import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * web端接口实现类
 * @author lzy
 * @date 2018/11/22 10:36
 * @version 1.0
 **/
@Service
public class WebServiceImpl implements WebService {

    /**
     * 获取日志操作对象
     **/
    Logger logger = LoggerFactory.getLogger(WebServiceImpl.class);
    @Resource
    private UserMapper userMapper;
    @Resource
    private UserRoleMapper userRoleMapper;
    @Resource
    private ProjectsMapper projectsMapper;
    @Resource
    private ProjectModuleMapper projectModuleMapper;
    @Resource
    private ProjectUserRelationMapper projectUserRelationMapper;
    @Resource
    private ModuleUserRelationMapper moduleUserRelationMapper;
    @Resource
    private TestPlanMapper testPlanMapper;
    @Resource
    private TestPlanUserRelationMapper testPlanUserRelationMapper;
    @Resource
    private BugManagementMapper bugManagementMapper;
    @Resource
    private BugManagementDetailMapper bugManagementDetailMapper;
    @Resource
    private UserPendingItemsMapper userPendingItemsMapper;


    /**
     * 登录接口实现
     * @param userAccount 用户账号
     * @param userPassword 用户密码
     * @return Map<String, Object>
     */
    @Override
    public Map<String, Object> doWebLogin(String userAccount, String userPassword) {
        if (Strings.isNullOrEmpty(userAccount)) {
            throw new NullPointerException(String.valueOf("userAccount can not null"));
        }
        if (Strings.isNullOrEmpty(userPassword)) {
            throw new NullPointerException(String.valueOf("userPassword can not null"));
        }
        if (Utils.ACCOUNT_MAX_LENGTH < userAccount.length()) {
            throw new IllegalArgumentException(String.valueOf("userAccount length error"));
        }
        if (Utils.PASSWORD_MIN_LENGTH > userPassword.length()
                || Utils.PASSWORD_MAX_LENGTH < userPassword.length()) {
            throw new IllegalArgumentException(String.valueOf("userPassword length error"));
        }
        Map<String,Object> map = Maps.newHashMap();
        // 判断是否有该用户
        Optional<User> userOptional = Optional.fromNullable(userMapper
                .selectByAccountAndPassword(userAccount, userPassword));
        if (!userOptional.isPresent()) {
            map.put(Utils.STATUS, false);
            map.put(Utils.ERROR_STRING, Utils.ACCOUNT_ERR);
            return map;
        } else {
            map.put("userId", userOptional.get().getUserId());
            map.put("userRoleId", userOptional.get().getUserRoleId());
            // 获取用户角色
            Optional<UserRole> userRoleOptional = Optional.fromNullable(userRoleMapper
                    .selectByPrimaryKey(userOptional.get().getUserRoleId()));
            if (!userRoleOptional.isPresent()) {
                map.put(Utils.STATUS, false);
                map.put(Utils.ERROR_STRING, "用户角色不存在！");
                return map;
            } else {
                map.put("userRoleName", Utils.transformNullOrEmptyToDefault(
                        Optional.fromNullable(userRoleOptional.get().getUserRoleName())));
                Optional<Integer> userRoleLevel = Optional.fromNullable(
                        userRoleOptional.get().getUserRoleLevel());
                if (!userRoleLevel.isPresent()) {
                    throw new NullPointerException(String.valueOf(
                            "userRoleLevel can not null"));
                } else {
                    map.put("userRoleLevel", userRoleOptional.get().getUserRoleLevel());
                }
            }
            map.put("userName", Utils.transformNullOrEmptyToDefault(
                    Optional.fromNullable(userOptional.get().getUserName())));
            // 更新登录时间和登录次数
            User user = new User();
            user.setUserLastLoginTime(new Date());
            Optional<Integer> visitCount = Optional.fromNullable(
                    userOptional.get().getUserVisitCount());
            if (!visitCount.isPresent()) {
                user.setUserVisitCount(1);
            } else {
                user.setUserVisitCount(userOptional.get().getUserVisitCount() + 1);
            }
            userMapper.updateByPrimaryKeySelective(user);
        }
        map.put(Utils.STATUS, true);
        map.put(Utils.ERROR_STRING, "");
        return map;
    }

    /**
     * 项目列表接口实现
     * @param userId 用户主键标识
     * @return Map<String, Object>
     */
    @Override
    public Map<String, Object> doGetProjects(String userId) {
        if (Strings.isNullOrEmpty(userId)) {
            throw new NullPointerException(String.valueOf("userId can not null"));
        }
        Map<String,Object> map = Maps.newHashMap();
        Optional<User> userOptional = Optional.fromNullable(userMapper.selectByPrimaryKey(
                Integer.valueOf(userId)));
        // 判断是否存在该用户
        if (!userOptional.isPresent()) {
            map.put(Utils.STATUS, false);
            map.put(Utils.ERROR_STRING, "用户不存在！");
            return map;
        } else {
            // 获取全部项目列表
            Optional<List<Projects>> projectsOptional = Optional.fromNullable(
                    projectsMapper.selectAllProjects());
            if (!projectsOptional.isPresent()) {
                // 尚无项目 返回null
                map.put("projects", null);
            } else {
                List<Map<String,Object>> projectsMap = Lists.newArrayList();
                for (Projects project : projectsOptional.get()) {
                    Map<String,Object> projectMap = Maps.newHashMap();
                    projectMap.put("projectId", project.getProjectId());
                    projectMap.put("projectName", Utils.transformNullOrEmptyToDefault(
                            Optional.fromNullable(project.getProjectName())));
                    projectsMap.add(projectMap);
                }
                // 返回项目列表
                map.put("projects", projectsMap);
            }
        }
        map.put(Utils.STATUS, true);
        map.put(Utils.ERROR_STRING, "");
        return map;
    }

    /**
     * 项目统计接口实现
     * @param projectId 项目主键标识
     * @return Map<String, Object>
     */
    @Override
    public Map<String, Object> doGetProjectStatistics(String projectId) {
        if (Strings.isNullOrEmpty(projectId)) {
            throw new NullPointerException(String.valueOf("projectId can not null"));
        }
        Map<String,Object> map = Maps.newHashMap();
        // 获取某项目的数据
        Optional<Projects> projectOptional = Optional.fromNullable(projectsMapper
                .selectByPrimaryKey(Integer.valueOf(projectId)));
        if (!projectOptional.isPresent()) {
            map.put(Utils.STATUS, false);
            map.put(Utils.ERROR_STRING, "项目不存在！");
            return map;
        } else {
            // 预计的项目周期 单位：天
            int estimatedDays = projectOptional.get()
                    .getProjectLifecycle();
            map.put("estimatedDays", estimatedDays);
            // 已消耗的天数
            int consumedDays = 0;
            try {
                consumedDays = Utils.dateBetweenIncludeToday(projectOptional.get()
                        .getCreateTime(), new Date());
            } catch (ParseException e) {
                logger.error("get consumedDays error!");
                e.printStackTrace();
            }
            map.put("consumedDays", consumedDays);
            // 剩余的天数
            map.put("leftDays", estimatedDays - consumedDays);
            // 总测试计划数 (不包含未激活、已弃用状态的测试计划)
            Optional<List<TestPlan>> testPlans = Optional.fromNullable(
                    testPlanMapper.selectByProjectId(projectOptional.get().getProjectId(),
                            TestPlanStatus.NOT_ACTIVE.getStatusCode(),
                    TestPlanStatus.ABANDONED.getStatusCode()));
            if (!testPlans.isPresent()) {
                logger.info("do not have testPlan!");
                map.put("totalTestPlan", 0);
                map.put("unCompleteTestPlan", 0);
                map.put("yesterdayCompleteTestPlan", 0);
            } else {
                map.put("totalTestPlan", testPlans.get().size());
                // 未完成的测试计划数
                List<Integer> planIdList = Lists.transform(testPlans.get(),
                        new Function<TestPlan, Integer>() {
                            @Override
                            @Nullable
                            public Integer apply(@Nullable TestPlan testPlan) {
                                return testPlan != null ? testPlan.getPlanId() : null;
                            }
                        });
                map.put("unCompleteTestPlan", testPlanUserRelationMapper
                        .getTotalTestPlan(planIdList,
                                TestPlanUserRelationStatus.ABANDONED.getStatusCode()));
                // 昨日完成的测试计划数
                map.put("yesterdayCompleteTestPlan", testPlanUserRelationMapper
                        .getYesterdayCompleteTestPlan(planIdList,
                                TestPlanUserRelationStatus.WAIT_TEST.getStatusCode(),
                                TestPlanUserRelationStatus.PASS.getStatusCode()));
            }
            // 总缺陷数
            map.put("totalBug", bugManagementMapper.getTotalBugCount(
                    Integer.valueOf(projectId)));
            // 未完成缺陷数
            map.put("unCompleteBug", bugManagementMapper.getUnCompleteBugCount(
                    Integer.valueOf(projectId), BugStatus.PROCESSED.getStatusCode()));
            // 昨日解决的缺陷数
            map.put("yesterdayCompleteBug", bugManagementMapper
                    .getYesterdayCompleteBugCount(Integer.valueOf(projectId),
                            BugStatus.PROCESSED.getStatusCode()));
        }
        map.put(Utils.STATUS, true);
        map.put(Utils.ERROR_STRING, "");
        return map;
    }

    /**
     * 用户待办事项接口实现
     * @param userId 用户主键标识
     * @return Map<String, Object>
     */
    @Override
    public Map<String, Object> doGetUserPendingItems(String userId, String currentPage,
                                                     String pageSize) {
        if (Strings.isNullOrEmpty(userId)) {
            throw new NullPointerException(String.valueOf("userId can not null"));
        }
        if (Strings.isNullOrEmpty(currentPage)) {
            throw new NullPointerException(String.valueOf("currentPage can not null"));
        }
        if (Strings.isNullOrEmpty(pageSize)) {
            throw new NullPointerException(String.valueOf("pageSize can not null"));
        }
        Map<String,Object> map = Maps.newHashMap();
        // 获取某用户的待办事项
        int start = (Integer.valueOf(currentPage) - 1) * Integer.valueOf(pageSize);
        Optional<List<UserPendingItems>> itemsOptional = Optional.fromNullable(
                userPendingItemsMapper.selectByUserId(Integer.valueOf(userId), start,
                        Integer.valueOf(pageSize)));
        if (itemsOptional.isPresent()) {
            List<Map<String,Object>> itemsMap = Lists.newArrayList();
            for (UserPendingItems item : itemsOptional.get()) {
                Map<String,Object> itemMap = Maps.newHashMap();
                itemMap.put("itemContent", item.getItemContent());
                itemMap.put("itemWorkTime", item.getItemWorkTime());
                itemMap.put("itemStatus", item.getItemStatus());
                itemMap.put("createTime", item.getCreateTime());
                itemMap.put("updateTime", item.getUpdateTime());
                itemsMap.add(itemMap);
            }
            // 返回待办事项列表
            map.put("pendingItems", itemsMap);
        } else {
            map.put("pendingItems", null);
        }
        map.put(Utils.STATUS, true);
        map.put(Utils.ERROR_STRING, "");
        return map;
    }

    /**
     * 项目总览接口实现
     * @param userId 用户主键标识
     * @return Map<String, Object>
     */
    @Override
    public Map<String, Object> doGetProjectsOverview(String userId) {
        if (Strings.isNullOrEmpty(userId)) {
            throw new NullPointerException(String.valueOf("userId can not null"));
        }
        Map<String,Object> map = Maps.newHashMap();
        // 获取全部项目列表
        Optional<List<Projects>> projectsOptional = Optional.fromNullable(
                projectsMapper.selectAllProjects());
        // 立项状态的项目
        int approvalProjects = 0;
        // 开发中状态的项目
        int developingProjects = 0;
        // 系统联调状态的项目
        int systemTestProjects = 0;
        // 待反馈状态的项目
        int pendingFeedbackProjects = 0;
        // 版本迭代状态的项目
        int versionIterationProjects = 0;
        // 已完结状态的项目
        int completeProjects = 0;
        // 已挂起状态的项目
        int suspendedProjects = 0;
        // 已延时状态的项目
        int delayProjects = 0;
        if (projectsOptional.isPresent()) {
            // 项目总数
            int totalProjects = projectsOptional.get().size();
            for (Projects project : projectsOptional.get()) {
                switch (project.getProjectStatus()) {
                    case 0:
                        approvalProjects += 1;
                        break;
                    case 1:
                        developingProjects += 1;
                        break;
                    case 2:
                        systemTestProjects += 1;
                        break;
                    case 3:
                        pendingFeedbackProjects += 1;
                        break;
                    case 4:
                        versionIterationProjects += 1;
                        break;
                    case 5:
                        completeProjects += 1;
                        break;
                    case 6:
                        suspendedProjects += 1;
                        break;
                    case 7:
                        delayProjects += 1;
                        break;
                    default:
                        break;
                }
            }
            map.put("totalProjects", totalProjects);
        } else {
            // 尚无项目
            map.put("totalProjects", 0);
        }
        map.put("approvalProjects", approvalProjects);
        map.put("developingProjects", developingProjects);
        map.put("systemTestProjects", systemTestProjects);
        map.put("pendingFeedbackProjects", pendingFeedbackProjects);
        map.put("versionIterationProjects", versionIterationProjects);
        map.put("completeProjects", completeProjects);
        map.put("suspendedProjects", suspendedProjects);
        map.put("delayProjects", delayProjects);
        map.put(Utils.STATUS, true);
        map.put(Utils.ERROR_STRING, "");
        return map;
    }

    /**
     * 工作内容接口实现类
     * @author lzy
     * @date 2018/11/27 17:37
     * @param userId 用户主键标识
     * @param userRoleLevel 用户角色等级
     * @return Map<String, Object>
     **/
    @Override
    public Map<String, Object> doGetMyJobContent(String userId, String userRoleLevel) {
        if (Strings.isNullOrEmpty(userId)) {
            throw new NullPointerException(String.valueOf("userId can not null"));
        }
        if (Strings.isNullOrEmpty(userRoleLevel)) {
            throw new NullPointerException(String.valueOf("userRoleLevel can not null"));
        }

        // ------项目经理身份-----
        // 未修复的缺陷数
        int pmUnFixBugs = 0;
        // 新增的缺陷
        int pmNewBugs = 0;
        // 待申领的缺陷
        int pmWaitApplyBugs = 0;
        // 待指派的测试计划
        int pmUnAssignedTestPlans = 0;
        // 待反馈的测试计划
        int pmPendingFeedbackTestPlans = 0;

        // ------研发人员身份-----
        // 负责的模块
        int developerModules = 0;
        // 测试计划
        int developerTestPlans = 0;
        // 缺陷
        int developerBugs = 0;
        // 进行中的项目
        int developerProcessingProjects = 0;

        // ------测试人员身份-----
        // 负责的模块
        int testerModules = 0;
        // 待测试计划
        int testerTestPlans = 0;
        // 发现的且开发人员尚未解决的缺陷
        int testerBugs = 0;
        // 待复测的缺陷
        int testerWaitRetestBugs = 0;
        // 进行中的项目
        int testerProcessingProjects = 0;

        Map<String,Object> map = Maps.newHashMap();
        switch (Integer.valueOf(userRoleLevel)) {
            case Utils.ADMIN:
                break;
            case Utils.PM:
                // 获取所有未修复的缺陷数（状态不为 已处理）
                pmUnFixBugs = bugManagementMapper.getAllUnprocessedBugCount(
                        BugStatus.PROCESSED.getStatusCode());
                // 获取所有新增的缺陷数（状态为 新增）
                pmNewBugs = bugManagementMapper.getAllBugCountByStatus(
                        BugStatus.NEW.getStatusCode());
                // 获取所有待申领的缺陷数（状态为 待申领）
                pmWaitApplyBugs = bugManagementMapper.getAllBugCountByStatus(
                        BugStatus.WAIT_APPLY.getStatusCode());
                // 获取所有待指派的测试计划数（状态为 待指派）
                pmUnAssignedTestPlans = testPlanMapper.getAllTestPlanByStatus(
                        TestPlanStatus.UNASSIGNED.getStatusCode());
                // 获取所有待反馈的测试计划数（状态为 待反馈）
                pmPendingFeedbackTestPlans = testPlanUserRelationMapper
                        .getAllTestPlanByStatus(TestPlanUserRelationStatus
                                .PENDING_FEEDBACK.getStatusCode());
                break;
            case Utils.DEVELOPER:
                // 获取用户负责的模块
                developerModules = getAllUnCompleteProjectModuleCountByUserId(
                        Integer.valueOf(userId));
                if (getAllUnCompleteProjects().isPresent()) {
                    // 获取用户的测试计划
                    // 获取所有未完结的项目的测试计划
                    Optional<List<TestPlan>> plansOptional = Optional.fromNullable(
                            testPlanMapper.getAllTestPlanByProjectIdList(
                                    getAllUnCompleteProjectIdList(),
                            TestPlanStatus.NOT_ACTIVE.getStatusCode(),
                            TestPlanStatus.ABANDONED.getStatusCode()));
                    if (plansOptional.isPresent()) {
                        // 获取某用户的所有测试计划（未完结的项目的测试计划，
                        //              不包含未激活、已弃用状态的测试计划）
                        List<Integer> planIds = Lists.transform(plansOptional.get(),
                                new Function<TestPlan, Integer>() {
                                    @Nullable
                                    @Override
                                    public Integer apply(@Nullable TestPlan
                                                                 testPlan) {
                                        return testPlan != null ? testPlan
                                                .getPlanId() : null;
                                }
                        });
                        developerTestPlans = testPlanUserRelationMapper
                                .getAllTestPlanByUserIdAndPlanIdList(planIds,
                                        Integer.valueOf(userId));
                    }
                    // 获取用户的缺陷
                    // 获取所有未完结的项目的已指派且未修复的缺陷
                    Optional<List<BugManagement>> bugsOptional = Optional.fromNullable(
                            bugManagementMapper.getAllProcessingBug(
                                    getAllUnCompleteProjectIdList()));
                    if (bugsOptional.isPresent()) {
                        // 获取某用户的所有缺陷（未完结的项目的已指派且未修复的缺陷，
                        //       不包含新增、已处理状态的缺陷）
                        List<Integer> bugIds = Lists.transform(bugsOptional.get(),
                                new Function<BugManagement, Integer>() {
                                    @Nullable
                                    @Override
                                    public Integer apply(@Nullable BugManagement
                                                                 bugManagement) {
                                        return bugManagement != null ? bugManagement
                                                .getBugId() : null;
                                    }
                                });
                        developerBugs = bugManagementDetailMapper.getAllBugByUserId(bugIds,
                                Integer.valueOf(userId));
                    }
                    // 用户进行中的项目
                    developerProcessingProjects = getProcessingProjectsBuUserId(
                            Integer.valueOf(userId));
                }
                break;
            case Utils.TESTER:
                // 获取用户负责的模块
                testerModules = getAllUnCompleteProjectModuleCountByUserId(
                        Integer.valueOf(userId));
                // 待测试计划
                if (getAllUnCompleteProjects().isPresent()) {
                    // 获取所有未完结的项目的测试计划
                    Optional<List<TestPlan>> plansOptional = Optional.fromNullable(
                            testPlanMapper.getAllTestPlanByProjectIdList(
                                    getAllUnCompleteProjectIdList(),
                                    TestPlanStatus.NOT_ACTIVE.getStatusCode(),
                                    TestPlanStatus.ABANDONED.getStatusCode()));
                    if (plansOptional.isPresent()) {
                        // 获取某用户的所有测试计划（未完结的项目的测试计划，
                        //              不包含未激活、已弃用状态的测试计划）
                        List<Integer> planIds = Lists.transform(plansOptional.get(),
                                new Function<TestPlan, Integer>() {
                                    @Nullable
                                    @Override
                                    public Integer apply(@Nullable TestPlan
                                                                 testPlan) {
                                        return testPlan != null ? testPlan
                                                .getPlanId() : null;
                                    }
                                });
                        testerTestPlans = testPlanUserRelationMapper
                                .getTestPlanByUserIdAndPlanIdListAndStatus(planIds,
                                        Integer.valueOf(userId),
                                        TestPlanUserRelationStatus.WAIT_TEST
                                                .getStatusCode());
                    }
                    // 获取未解决的缺陷
                    // 获取所有未完结的项目的未修复的缺陷
                    Optional<List<BugManagement>> bugsOptional = Optional.fromNullable(
                            bugManagementMapper.getAllProcessingBugWithNewAdd(
                                    getAllUnCompleteProjectIdList()));
                    if (bugsOptional.isPresent()) {
                        testerBugs = bugsOptional.get().size();
                    }
                    // 获取待复测的缺陷
                    Optional<List<BugManagement>> waitRetestBugOptional = Optional
                            .fromNullable(bugManagementMapper.getAllWaitRetestBug(
                                    getAllUnCompleteProjectIdList()));
                    if (waitRetestBugOptional.isPresent()) {
                        testerWaitRetestBugs = waitRetestBugOptional.get().size();
                    }
                    // 进行中的项目
                    testerProcessingProjects = getProcessingProjectsBuUserId(
                            Integer.valueOf(userId));
                }
                break;
            case Utils.UI:
                break;
            case Utils.VISITOR:
                break;
            default:
                break;
        }
        map.put("pmUnFixBugs", pmUnFixBugs);
        map.put("pmNewBugs", pmNewBugs);
        map.put("pmWaitApplyBugs", pmWaitApplyBugs);
        map.put("pmUnAssignedTestPlans", pmUnAssignedTestPlans);
        map.put("pmPendingFeedbackTestPlans", pmPendingFeedbackTestPlans);
        map.put("developerModules", developerModules);
        map.put("developerTestPlans", developerTestPlans);
        map.put("developerBugs", developerBugs);
        map.put("developerProcessingProjects", developerProcessingProjects);
        map.put("testerModules", testerModules);
        map.put("testerTestPlans", testerTestPlans);
        map.put("testerBugs", testerBugs);
        map.put("testerWaitRetestBugs", testerWaitRetestBugs);
        map.put("testerProcessingProjects", testerProcessingProjects);
        map.put(Utils.STATUS, true);
        map.put(Utils.ERROR_STRING, "");
        return map;
    }

    /**
     * 获取项目状态列表接口实现
     * @author lzy
     * @date 2018/11/28 17:19
     * @param userId 用户主键标识
     * @return Map<String, Object>
     **/
    @Override
    public Map<String, Object> doGetProjectStatusList(String userId) {
        if (Strings.isNullOrEmpty(userId)) {
            throw new NullPointerException(String.valueOf("userId can not null"));
        }
        Map<String,Object> map = Maps.newHashMap();
        List<Map<String,Object>> status = Lists.newArrayList();
        for (ProjectStatus projectStatus : ProjectStatus.values()) {
            Map<String,Object> statusMap = Maps.newHashMap();
            statusMap.put("statusName", projectStatus.getStatusName());
            statusMap.put("statusCode", projectStatus.getStatusCode());
            status.add(statusMap);
        }
        map.put("projectStatus", status);
        map.put(Utils.STATUS, true);
        map.put(Utils.ERROR_STRING, "");
        return map;
    }

    /**
     * 获取所有未完结的项目（状态不为 已完结 已挂起）
     * @author lzy
     * @date 2018/11/28 15:59
     * @return com.google.common.base.Optional<java.util.List
     * <cn.lzy.server.softwareautomationms.model.Projects>>
     **/
    private Optional<List<Projects>> getAllUnCompleteProjects() {
        return Optional.fromNullable(
                projectsMapper.selectAllUnCompleteProjects());
    }

    /**
     * 获取所有未完结的项目的主键列表（状态不为 已完结 已挂起）
     * @author lzy
     * @date 2018/11/28 16:06
     * @return java.util.List<java.lang.Integer>
     **/
    private List<Integer> getAllUnCompleteProjectIdList() {
        if (getAllUnCompleteProjects().isPresent()) {
            return Lists.transform(getAllUnCompleteProjects().get(),
                    new Function<Projects, Integer>() {
                        @Nullable
                        @Override
                        public Integer apply(@Nullable Projects projects) {
                            return projects != null ? projects.getProjectId() : null;
                        }
                    });
        }
        logger.error("do not have unComplete project ?");
        return null;
    }

    /**
     * 根据userId获取用户负责的模块
     * @author lzy
     * @date 2018/11/28 16:06
     * @return java.lang.Integer
     **/
    private Integer getAllUnCompleteProjectModuleCountByUserId(Integer userId) {
        Optional<List<ProjectModule>> projectModules = Optional.fromNullable(
                projectModuleMapper.getAllProjectModuleByProjectId(
                        getAllUnCompleteProjectIdList()));
        if (projectModules.isPresent()) {
            // 获取某用户所负责的所有模块（未完结的项目的模块）
            List<Integer> projectModulesId = Lists.transform(projectModules.get(),
                    new Function<ProjectModule, Integer>() {
                        @Nullable
                        @Override
                        public Integer apply(@Nullable ProjectModule
                                                     projectModule) {
                            return projectModule != null ? projectModule
                                    .getProjectModuleId() : null;
                        }
                    });
            return moduleUserRelationMapper.getAllModuleByUserId(
                    projectModulesId, userId);
        }
        logger.error("do not have unComplete project's module ?");
        return 0;
    }

    /**
     * 根据userId获取进行中的项目
     * @author lzy
     * @date 2018/11/28 16:21
     * @param userId 用户主键标识
     * @return java.lang.Integer
     **/
    private Integer getProcessingProjectsBuUserId(Integer userId) {
         Optional<List<Integer>> projectIdList = Optional.fromNullable(
                 getAllUnCompleteProjectIdList());
         if (projectIdList.isPresent()) {
             return projectUserRelationMapper
                     .getAllProjectByUserIdAndProjectIdList(projectIdList.get(),
                             userId);
         }
        logger.error("do not have processing project ?");
        return 0;
    }

}
