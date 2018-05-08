package com.search.service;

import com.search.model.User;

import java.util.List;

/**
 * Created by nya on 2018/5/8.
 */
public interface UserService {

    int addUser(User user);

    List<User> findAllUser(int pageNum, int pageSize);

    User selectByPrimaryKey(int id);

    int updateByPrimaryKey(User record);

    int deleteByPrimaryKey(Integer userId);

}
