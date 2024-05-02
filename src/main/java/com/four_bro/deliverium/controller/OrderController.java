package com.four_bro.deliverium.controller;

import com.four_bro.deliverium.model.OrderModel;
import com.four_bro.deliverium.service.OrderService;
import jakarta.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
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

  @PostMapping(value = "/change_order_status")
  public String changeStatusOfOrder(@RequestBody Map<String, Object> request) {
    Integer id = (Integer) request.get("id");
    Integer status = (Integer) request.get("status");
    // log.info("status*****************" + status);
    // log.info("id*****************" + id);
    String data = orderService.changeStatusOfOrder(
      Integer.valueOf(id),
      Integer.valueOf(status)
    );
    return data;
  }
}
