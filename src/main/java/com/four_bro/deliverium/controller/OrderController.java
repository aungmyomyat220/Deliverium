package com.four_bro.deliverium.controller;

import com.four_bro.deliverium.model.OrderModel;
import com.four_bro.deliverium.service.OrderService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class OrderController {

  @Autowired
  private OrderService orderService;

  @GetMapping("/orderlist")
  public List<OrderModel> order_list() {
    log.info("Order Controller Work");
    List<OrderModel> res = orderService.getOrders();
    return res;
  }
}
