package com.four_bro.deliverium.controller;

import org.springframework.web.bind.annotation.RestController;

import com.four_bro.deliverium.model.UserModel;
import com.four_bro.deliverium.service.UserService;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class ApiController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
     public String login(@RequestBody Map<String, Object> param,Model model) {
        List <UserModel> res=userService.login(param);
        model.addAttribute("users",res);
        return "200 ok";
    } 
}
