package com.djcps.validator.user.controller;

import com.djcps.validator.user.model.AddUserModel;
import com.djcps.validator.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author yhc
 * @create 2020-05-06 20:18
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("add")
    public String add(@RequestBody @Valid AddUserModel model){
        userService.addUser(model);
        return "ok";
    }

}
