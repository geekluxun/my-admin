package com.geekluxun.myadmin.workflow.controller;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.activiti.engine.IdentityService;
import org.activiti.engine.identity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
        List<User> userList = identityService.createUserQuery().orderByUserId().list();
        return userList;
    }
}
