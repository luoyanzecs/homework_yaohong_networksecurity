package cn.luoyanze.web.mapper;

import cn.luoyanze.web.pojo.vo.Message;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2021/4/26 10:29 下午
 */


@Mapper
@Repository
public interface MessageMapper {


    @Select("select * from msg where id = #{clientId}")
    List<Message> selectMsg(@Param("clientId") String clientId);

    @Insert("Insert into msg (id, time_stamp, ctx, user_id) values (userId, #{msg.timeStamp}, #{msg.ctx}, #{msg.userId})")
    void insertMsg(@Param("userId") String userId, @Param("msg") Message msg);
}
