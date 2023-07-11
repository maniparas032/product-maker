package com.electcomm.productmaker.controller;

import com.electcomm.productmaker.model.UserInfo;
import com.electcomm.productmaker.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserInfoService userInfoService;
    @Autowired
    PasswordEncoder passwordEncoder;

    @PostMapping("/add")
    public ResponseEntity<UserInfo> addUser(@RequestBody UserInfo userInfo)
    {
        userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
        UserInfo savedUser = userInfoService.addUser(userInfo);
        return new ResponseEntity<UserInfo>(savedUser, HttpStatus.CREATED);
    }

    @GetMapping("/getbcrypt/{password}")
    public String getBcryptPassword(@PathVariable String password)
    {
        String encodedPassword = passwordEncoder.encode(password);
        return  encodedPassword;
    }
}
