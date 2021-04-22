package com.example.as.dao;

import com.example.as.pojo.ClientUser;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2021/4/22 6:05 下午
 */

public interface UserDao {

    /**
     * select client user from database,
     * if not exist return null,
     * else return com.example.as.pojo.ClientUser Object.
     *
     * @param id:  clientUserId
     * @return: com.example.as.pojo.ClientUser
     */
    ClientUser getClientUser(String id);
}
