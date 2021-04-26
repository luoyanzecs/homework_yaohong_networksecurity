package cn.luoyanze.web.mapper;

import cn.luoyanze.web.pojo.UserPO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
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
    @Select("select * from user where id = #{id}")
    UserPO getClientUser(@Param("id") String id);

    @Insert("insert into user value (#{id}, #{pwd})")
    void setClientUser(@Param("id") String id, @Param("pwd") String password);
}
