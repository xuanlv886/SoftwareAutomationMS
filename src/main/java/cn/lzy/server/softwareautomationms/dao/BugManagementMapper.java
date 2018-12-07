package cn.lzy.server.softwareautomationms.dao;

import cn.lzy.server.softwareautomationms.model.BugManagement;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BugManagementMapper {
    int deleteByPrimaryKey(Integer bugId);

    int insert(BugManagement record);

    int insertSelective(BugManagement record);

    BugManagement selectByPrimaryKey(Integer bugId);

    int updateByPrimaryKeySelective(BugManagement record);

    int updateByPrimaryKey(BugManagement record);

    /**
     * 获取某项目的总缺陷数
     * @param projectId
     * @return
     */
    int getTotalBugCount(Integer projectId);

    /**
     * 获取某项目未完成的缺陷数（状态不为 已处理）
     * @param projectId
     * @return
     */
    int getUnCompleteBugCount(@Param("projectId")Integer projectId,
                              @Param("processed")Integer processed);

    /**
     * 获取某项目昨日解决的缺陷数（状态为 已处理）
     * @param projectId
     * @param processed
     * @return
     */
    int getYesterdayCompleteBugCount(@Param("projectId")Integer projectId,
                                     @Param("processed")Integer processed);

    /**
     * 获取所有未修复的缺陷数（状态不为 已处理）
     * @param processed
     * @return
     */
    int getAllUnprocessedBugCount(Integer processed);

    /**
     * 根据状态获取所有缺陷数
     * @param bugStatus
     * @return
     */
    int getAllBugCountByStatus(Integer bugStatus);


    /**
     * 获取所有未完结项目中已指派且未修复（状态不为 新增、已处理）的缺陷
     * @param projectIdList
     * @return
     */
    List<BugManagement> getAllProcessingBug(List<Integer> projectIdList);

    /**
     * 获取所有未完结项目中未修复（状态不为 已处理）的缺陷
     * @param projectIdList
     * @return
     */
    List<BugManagement> getAllProcessingBugWithNewAdd(List<Integer> projectIdList);

    /**
     * 获取所有未完结项目中待复测（状态为 待复测）的缺陷
     * @param projectIdList
     * @return
     */
    List<BugManagement> getAllWaitRetestBug(List<Integer> projectIdList);
}