package com.four_bro.deliverium.controller;

import com.four_bro.deliverium.model.OrderModel;
import com.four_bro.deliverium.model.ProductModel;
import com.four_bro.deliverium.service.OrderService;
import com.four_bro.deliverium.service.ProductService;
import jakarta.servlet.http.HttpServletRequest;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
// @Controller
@RestController
public class OrderController {

  @Autowired
  private OrderService orderService;

  @GetMapping("/getAllOrders")
  public List<OrderModel> getAllOrders(
    HttpServletRequest request,
    Model model
  ) {
    List<OrderModel> orderList = orderService.getAllOrders();
    return orderList;
  }
}
