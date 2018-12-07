package cn.lzy.server.softwareautomationms.dao;

import cn.lzy.server.softwareautomationms.model.ModuleUserRelation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ModuleUserRelationMapper {
    int deleteByPrimaryKey(Integer moduleUserRelationId);

    int insert(ModuleUserRelation record);

    int insertSelective(ModuleUserRelation record);

    ModuleUserRelation selectByPrimaryKey(Integer moduleUserRelationId);

    int updateByPrimaryKeySelective(ModuleUserRelation record);

    int updateByPrimaryKey(ModuleUserRelation record);

    /**
     * 获取某用户所负责的所有模块（未完结的项目的模块）
     * @param projectModuleIdList
     * @param userId
     * @return
     */
    int getAllModuleByUserId(@Param("projectModuleIdList") List<Integer> projectModuleIdList,
            @Param("userId") Integer userId);
}