package cn.lzy.server.softwareautomationms.dao;

import cn.lzy.server.softwareautomationms.model.BugManagementDetail;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BugManagementDetailMapper {
    int deleteByPrimaryKey(Integer bugManagementDetailId);

    int insert(BugManagementDetail record);

    int insertSelective(BugManagementDetail record);

    BugManagementDetail selectByPrimaryKey(Integer bugManagementDetailId);

    int updateByPrimaryKeySelective(BugManagementDetail record);

    int updateByPrimaryKey(BugManagementDetail record);

    /**
     * 根据bugIdList获取某用户的所有缺陷
     * @param bugIdList
     * @param userId
     * @return
     */
    int getAllBugByUserId(@Param("bugIdList") List<Integer>bugIdList,
                          @Param("userId") Integer userId);
}