package com.search.controller;

import com.search.model.User;
import com.search.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.thymeleaf.util.ListUtils;

import java.util.List;

/**
 * Created by nya on 2018/5/8.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping(value = "/add", produces = {"application/json;charset=UTF-8"})
    public int addUser(User user){
        logger.info("---user---param--"+user.toString());
        return userService.addUser(user);
    }

    @ResponseBody
    @RequestMapping(value = "/all/{pageNum}/{pageSize}", produces = {"application/json;charset=UTF-8"})
    public Object findAllUser(@PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize){
        Object object = userService.findAllUser(pageNum,pageSize);
        List<User> list = (List<User>) object;
        if (!ListUtils.isEmpty(list)){
            for (int i = 0 ; i < list.size() ; i ++) {
                logger.info("----result---list--"+ i + "--" + list.get(i).toString());
            }
        }

        return object;
    }

    @ResponseBody
    @RequestMapping(value = "/update", produces = {"application/json;charset=UTF-8"})
    public int updateUser(User user){
        logger.info("---user---param--"+user.toString());
        return userService.updateByPrimaryKey(user);
    }

    @ResponseBody
    @RequestMapping(value = "/one/{userId}", produces = {"application/json;charset=UTF-8"})
    public Object getOne(@PathVariable("userId") int userId){
        return userService.selectByPrimaryKey(userId);
    }

    @ResponseBody
    @RequestMapping(value = "/del/{userId}", produces = {"application/json;charset=UTF-8"})
    public int delUser(@PathVariable("userId") int userId){
        return userService.deleteByPrimaryKey(userId);
    }

}
