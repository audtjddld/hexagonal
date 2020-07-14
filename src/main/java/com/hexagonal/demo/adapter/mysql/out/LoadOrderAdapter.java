package com.hexagonal.demo.adapter.mysql.out;

import com.hexagonal.demo.adapter.mysql.OrderRepository;
import com.hexagonal.demo.application.order.port.out.LoadOrderPort;
import com.hexagonal.demo.application.order.domain.Order;
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
