package cn.lzy.server.softwareautomationms.dao;

import cn.lzy.server.softwareautomationms.model.TestPlanUserRelation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TestPlanUserRelationMapper {
    int deleteByPrimaryKey(Integer planUserRelationId);

    int insert(TestPlanUserRelation record);

    int insertSelective(TestPlanUserRelation record);

    TestPlanUserRelation selectByPrimaryKey(Integer planUserRelationId);

    int updateByPrimaryKeySelective(TestPlanUserRelation record);

    int updateByPrimaryKey(TestPlanUserRelation record);

    /**
     * 总测试计划数 (不包含已弃用状态的测试计划)
     * @param planIdList
     * @param abandoned
     * @return
     */
    int getTotalTestPlan(@Param("planIdList") List<Integer> planIdList,
                         @Param("abandoned")Integer abandoned);

    /**
     * 昨日完成的测试计划数 (只包含待测试、已完成、状态的测试计划)
     * @param planIdList
     * @return
     */
    int getYesterdayCompleteTestPlan(@Param("planIdList")List<Integer> planIdList,
                                     @Param("activated")Integer activated,
                                     @Param("pass")Integer pass);

    /**
     * 根据状态获取测试计划数
     * @param status
     * @return
     */
    int getAllTestPlanByStatus(Integer status);

    /**
     * 根据条件获取某用户所有的测试计划数（不包含未激活、已弃用状态的测试计划）
     * @param planIdList
     * @param userId
     * @return
     */
    int getAllTestPlanByUserIdAndPlanIdList(
            @Param("planIdList")List<Integer> planIdList,
            @Param("userId")Integer userId);

    /**
     * 根据条件获取某用户所有的测试计划数（不包含未激活、已弃用状态的测试计划）
     * @param planIdList
     * @param userId
     * @param status
     * @return
     */
    int getTestPlanByUserIdAndPlanIdListAndStatus(
            @Param("planIdList")List<Integer> planIdList,
            @Param("userId")Integer userId,
            @Param("status")Integer status);

}