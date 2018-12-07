package cn.lzy.server.softwareautomationms.dao;

import cn.lzy.server.softwareautomationms.model.TestPlan;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TestPlanMapper {
    int deleteByPrimaryKey(Integer planId);

    int insert(TestPlan record);

    int insertSelective(TestPlan record);

    TestPlan selectByPrimaryKey(Integer planId);

    int updateByPrimaryKeySelective(TestPlan record);

    int updateByPrimaryKey(TestPlan record);

    /**
     * 某项目的总测试计划数 (不包含未激活、已弃用状态的测试计划)
     * @param projectId
     * @param notActive
     * @param abandoned
     * @return
     */
    List<TestPlan> selectByProjectId(@Param("projectId") Integer projectId,
                                     @Param("notActive")Integer notActive,
                                     @Param("abandoned")Integer abandoned);

    /**
     * 根据状态获取所有测试计划数
     * @param planStatus
     * @return
     */
    int getAllTestPlanByStatus(Integer planStatus);

    /**
     * 获取某些项目的测试计划 (不包含未激活、已弃用状态的测试计划)
     * @param projectIdList
     * @param notActive
     * @param abandoned
     * @return
     */
    List<TestPlan> getAllTestPlanByProjectIdList(
            @Param("projectIdList") List<Integer> projectIdList,
            @Param("notActive")Integer notActive,
            @Param("abandoned")Integer abandoned);
}