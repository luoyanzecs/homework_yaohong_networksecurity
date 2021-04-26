package cn.luoyanze.tgs.mapper;

import cn.luoyanze.as.pojo.ServerKeyParent;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2021/4/24 2:11 下午
 */

@Repository
@Mapper
public interface ServerKeyMapper {

    @Select("select * from server_key")
    ServerKeyParent getServerKey();
}
