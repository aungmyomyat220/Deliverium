package com.four_bro.deliverium.controller;

import com.four_bro.deliverium.model.ProductModel;
import com.four_bro.deliverium.service.ProductService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
// @RestController
@RequestMapping("/product")
public class ProductController {

  @Autowired
  private ProductService productService;

  @GetMapping("/productlist")
  public String allProducts(HttpServletRequest request, Model model) {
    HttpSession session = request.getSession(false);
    if (session != null && session.getAttribute("AUTH_CHECK") != null) {
      List<ProductModel> res = productService.getAllProducts();
      session.getAttribute("AUTH_CHECK");
      String userName = (String) session.getAttribute("USER_NAME");
      model.addAttribute("res", res);
      model.addAttribute("activeTab", "products");
      model.addAttribute("adminName", userName);
    }

    return "product/list";
  }

  @RequestMapping(value = "/create", method = RequestMethod.GET)
  public String createProduct(Model model) {
    return "product/create"; // Return the logical view name
  }
}
