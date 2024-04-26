package com.four_bro.deliverium.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/users")
public class UserController {

  @RequestMapping(value = "/all_users", method = RequestMethod.GET)
  public String users(HttpServletRequest request, Model model) {
    HttpSession session = request.getSession(false);
    if (session != null && session.getAttribute("AUTH_CHECK") != null) {
      session.getAttribute("AUTH_CHECK");
      String userName = (String) session.getAttribute("USER_NAME");
      model.addAttribute("adminName", userName);
      model.addAttribute("activeTab", "users");
      return "users/user";
    }
    return "auth/login";
  }
}
