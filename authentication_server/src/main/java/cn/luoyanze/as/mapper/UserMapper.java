package cn.luoyanze.as.mapper;

import cn.luoyanze.as.pojo.ClientUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2021/4/22 6:05 下午
 */

@Mapper
@Repository
public interface UserMapper {

    /**
     * select client user from database,
     * if not exist return null,
     * else return com.example.as.pojo.ClientUser Object.
     *
     * @param id:  clientUserId
     * @return: com.example.as.pojo.ClientUser
     */
    ClientUser getClientUser(@Param("id") String id);

    void setClientUser(@Param("id") String id, @Param("pwd") String password);
}
