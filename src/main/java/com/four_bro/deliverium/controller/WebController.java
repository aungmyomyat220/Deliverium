package com.four_bro.deliverium.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {
    @GetMapping("/")
    public String auth(){
        return "auth/login";
    }

    @GetMapping("/home")
    public String home(){
        return "home";
    }
    
}
