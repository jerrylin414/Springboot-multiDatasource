package com.lzy.pnaWeb.controller;

import com.lzy.pnaWeb.common.CommonResult;
import com.lzy.pnaWeb.dto.UserDto;
import com.lzy.pnaWeb.entity.User1;
import com.lzy.pnaWeb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public CommonResult login(@RequestBody UserDto userDto){
        // String token = TokenUtil.getToken(appUser.getId(), appUser.getPassword());

        List<User1> list = userService.findList();

        return CommonResult.success(null);
    }

    @GetMapping("/test")
    public CommonResult test(){
        // String token = TokenUtil.getToken(appUser.getId(), appUser.getPassword());
        List<User1> list = userService.findList();

        return CommonResult.success(null);
    }


    //Test rollback
    @GetMapping("test2")
    public void test2(){
        userService.insertOne();
    }

}
