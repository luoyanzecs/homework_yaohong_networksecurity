package cn.luoyanze.as.mapper;

import cn.luoyanze.as.pojo.ServerKeyPO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2021/4/24 2:11 下午
 */

@Repository
@Mapper
public interface ServerKeyMapper {
    public ServerKeyPO getServerKey();
}
