package cn.luoyanze.as.mapper;

import cn.luoyanze.as.pojo.SessionPO;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2021/4/24 2:25 下午
 */

@Repository
@Mapper
public interface SessionMapper {

    SessionPO getSession(@Param("sessionId") String sessionId);

    void insertSession(@Param("session") SessionPO session);

    void updateSession(@Param("session") SessionPO session);

    void insert(@Param("sessionId") String sessionId,
                @Param("rsaPriKey") String rsaPriKey,
                @Param("rsaPubKey") String rsaPubKey,
                @Param("clientId") String clientId,
                @Param("desKeyClient") String desKeyClient);

    //void updateRsa(@Param("sessionId") String sessionId,
    //               @Param("pub") String pubKey,
    //               @Param("pri") String priKey);
    //
    //void updateTime(@Param("sessionId") String sessionId,
    //                @Param("time") String timeStamp);
    //
    //void updateClientId(@Param("sessionId") String sessionId,
    //                    @Param("clientId") String clientId);
    //
    //void updateKeyClient(@Param("sessionId") String sessionId,
    //                     @Param("key") String desKeyClient);
    //
    //void updateKeyClientTgs(@Param("sessionId") String sessionId,
    //                        @Param("key") String desKeyClientTgs);
    //
    //void updateKeyClientServer(@Param("sessionId") String sessionId,
    //                           @Param("key") String desKeyClientServer);

}
