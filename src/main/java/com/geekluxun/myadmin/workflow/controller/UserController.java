package com.geekluxun.myadmin.workflow.controller;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.activiti.engine.IdentityService;
import org.activiti.engine.identity.Group;
import org.activiti.engine.identity.User;
import org.activiti.engine.identity.UserQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2019-04-08 16:33
 * @Description:
 * @Other:
 */
@RestController
@RequestMapping("/activiti/user")
@Slf4j
public class UserController {
    
    @Autowired
    private IdentityService identityService;

    @GetMapping("/queryAllUsers")
    @ApiOperation(value = "查询所有用户")
    public Object queryAllUsers(){
        List<User> userList = identityService.createUserQuery().orderByUserId().desc().list();
        return userList;
    }

    @GetMapping("/addUser")
    @ApiOperation(value = "增加用户")
    public Object addUser(@RequestParam("userId") String userId){
        User  user = identityService.newUser(userId);
        identityService.saveUser(user);
        identityService.setUserInfo(userId, "nick", "lu");
        return user;
    }
    
    @GetMapping("/addGroup")
    @ApiOperation(value = "增加组")
    public Object addGroup(@RequestParam String groupId){
        Group group = identityService.newGroup(groupId);
        identityService.saveGroup(group);
        return group;
    }
    
    @GetMapping("/addMemberToGroup")
    @ApiOperation(value = "增加用户到组")
    public Object addMemberToGroup(@RequestParam("userId") String userId, @RequestParam("groupId") String groupId){
        identityService.createMembership(userId, groupId);
        return "把用户" + userId + "加到" + groupId + "成功";
    }


    @GetMapping("/queryMemberByGroup")
    @ApiOperation(value = "查询组成员")
    public Object queryMemberByGroup(@RequestParam("groupId") String groupId){
        List<User> users = identityService.createUserQuery().memberOfGroup(groupId).list();
        return users;
    }
}