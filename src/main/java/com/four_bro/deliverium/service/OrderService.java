package com.four_bro.deliverium.service;

import com.four_bro.deliverium.model.OrderModel;
import com.four_bro.deliverium.repository.OrderRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

  private final OrderRepository orderRepository;

  @Autowired
  public OrderService(OrderRepository orderRepository) {
    this.orderRepository = orderRepository;
  }

  public List<OrderModel> getAllOrders() {
    return orderRepository.findAllOrders();
  }
}
