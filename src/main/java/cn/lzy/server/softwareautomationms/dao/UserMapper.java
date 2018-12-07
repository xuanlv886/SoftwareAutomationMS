package cn.lzy.server.softwareautomationms.dao;

import cn.lzy.server.softwareautomationms.model.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User selectByAccountAndPassword(@Param("userAccount") String userAccount,
                                    @Param("userPassword") String userPassword);
}