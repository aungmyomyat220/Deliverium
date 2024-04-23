package com.four_bro.deliverium.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class WebController {
    @GetMapping("/")
    public String auth(HttpServletRequest request,Model model){
        HttpSession session = request.getSession(false); 
        if (session != null && session.getAttribute("AUTH_CHECK") != null) {
            session.getAttribute("AUTH_CHECK");
            String userName = (String) session.getAttribute("USER_NAME");
            model.addAttribute("adminName",userName);
            return "home"; 
        }
        return "auth/login"; 
    }


    @GetMapping("/home")
    public String home(HttpServletRequest request,Model model){
        HttpSession session = request.getSession(false); 
        if (session != null && session.getAttribute("AUTH_CHECK") != null) {
            session.getAttribute("AUTH_CHECK");
            String userName = (String) session.getAttribute("USER_NAME");
            model.addAttribute("adminName",userName);
            return "home"; 
        }
        return "auth/login"; 
    }
    
}
