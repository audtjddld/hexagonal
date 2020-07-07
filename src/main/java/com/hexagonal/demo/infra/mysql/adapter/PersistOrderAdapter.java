package com.hexagonal.demo.infra.mysql.adapter;

import com.hexagonal.demo.order.port.out.PersistOrderPort;
import com.hexagonal.demo.order.domain.Order;
import org.springframework.stereotype.Component;
import javax.transaction.Transactional;

@Component
public class PersistOrderAdapter implements PersistOrderPort {

  private final OrderRepository orderRepository;

  public PersistOrderAdapter(OrderRepository orderRepository) {
    this.orderRepository = orderRepository;
  }

  @Transactional
  @Override
  public Order save(Order order) {
    return orderRepository.save(order);
  }

}
