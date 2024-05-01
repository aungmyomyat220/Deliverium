package com.four_bro.deliverium.service;

import com.four_bro.deliverium.model.OrderModel;
import com.four_bro.deliverium.repository.OrderRepository;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class OrderService {

  @Autowired
  private OrderRepository orderRepo;

  public List<OrderModel> getOrders() {
    log.info("Order Service Work");

    List<OrderModel> order = orderRepo.findAll();

    return order;
  }
}
