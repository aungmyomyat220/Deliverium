package com.four_bro.deliverium.controller;

import org.springframework.web.bind.annotation.RestController;
import com.four_bro.deliverium.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import java.util.Map;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
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
    public boolean login(@RequestBody Map<String,Object> param, HttpServletRequest request,Model model) {
        String username = (String)param.get("username");
        String password = (String)param.get("password");
        
        boolean isAuthenticated = userService.login(username, password);
        if (isAuthenticated) {
            String uuid = UUID.randomUUID().toString();
            HttpSession session = request.getSession();
            session.setAttribute("AUTH_CHECK",uuid );
            session.setAttribute("USER_NAME",username );
        }
        return isAuthenticated;
}


}
