package com.hexagonal.demo.infra.mysql.adapter;

import com.hexagonal.demo.order.adapter.out.LoadOrderPort;
import com.hexagonal.demo.order.domain.Order;
import org.springframework.stereotype.Component;

@Component
public class LoadOrderAdapter implements LoadOrderPort {

  private final OrderRepository orderRepository;

  public LoadOrderAdapter(OrderRepository orderRepository) {
    this.orderRepository = orderRepository;
  }

  @Override
  public Order findById(Long id) {
    return orderRepository.findById(id).get();
  }

}
