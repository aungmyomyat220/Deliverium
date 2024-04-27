package com.four_bro.deliverium.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class WebController {

  @GetMapping("/")
  public String auth(HttpServletRequest request, Model model) {
    HttpSession session = request.getSession(false);
    if (session != null && session.getAttribute("AUTH_CHECK") != null) {
      session.getAttribute("AUTH_CHECK");
      String userName = (String) session.getAttribute("USER_NAME");
      model.addAttribute("adminName", userName);
      return "dashboard/dashboard";
    }
    return "auth/login";
  }

  @GetMapping("/dashboard")
  public String home(HttpServletRequest request, Model model) {
    HttpSession session = request.getSession(false);
    if (session != null && session.getAttribute("AUTH_CHECK") != null) {
      session.getAttribute("AUTH_CHECK");
      String userName = (String) session.getAttribute("USER_NAME");
      model.addAttribute("adminName", userName);
      model.addAttribute("activeTab", "dashboard");
      return "dashboard/dashboard";
    }
    return "auth/login";
  }

  @GetMapping("/product/productlist")
  public String allProducts(HttpServletRequest request, Model model) {
    HttpSession session = request.getSession(false);
    if (session != null && session.getAttribute("AUTH_CHECK") != null) {
      session.getAttribute("AUTH_CHECK");
      String userName = (String) session.getAttribute("USER_NAME");
      model.addAttribute("activeTab", "products");
      model.addAttribute("adminName", userName);
      return "product/list";
    }
    return "auth/login";
  }

  @GetMapping("/product/create")
  public String createProduct(HttpServletRequest request, Model model) {
    HttpSession session = request.getSession(false);
    if (session != null && session.getAttribute("AUTH_CHECK") != null) {
      session.getAttribute("AUTH_CHECK");
      String userName = (String) session.getAttribute("USER_NAME");
      model.addAttribute("activeTab", "products");
      model.addAttribute("adminName", userName);
      return "product/create"; // Return the logical view name
    }
    return "auth/login";
  }

}
