package cn.lzy.server.softwareautomationms.dao;

import cn.lzy.server.softwareautomationms.model.UserPendingItems;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserPendingItemsMapper {
    int deleteByPrimaryKey(Integer itemId);

    int insert(UserPendingItems record);

    int insertSelective(UserPendingItems record);

    UserPendingItems selectByPrimaryKey(Integer itemId);

    int updateByPrimaryKeySelective(UserPendingItems record);

    int updateByPrimaryKey(UserPendingItems record);

    /**
     * 获取某用户的待办事项
     * @param userId
     * @param start
     * @param pageSize
     * @return
     */
    List<UserPendingItems> selectByUserId(@Param("userId")Integer userId,
                                          @Param("start")Integer start,
                                          @Param("pageSize")Integer pageSize);
}