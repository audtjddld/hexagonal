package com.hexagonal.demo.order.application.service;

import com.hexagonal.demo.order.application.port.in.CreateOrderUseCase;
import com.hexagonal.demo.order.application.port.out.PersistOrderPort;
import com.hexagonal.demo.order.port.command.CreateOrderCmd;
import com.hexagonal.demo.order.domain.Order;
import com.hexagonal.demo.order.domain.OrderItem;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CreateOrderService implements CreateOrderUseCase {

  private final PersistOrderPort persistOrderPort;

  public CreateOrderService(PersistOrderPort persistOrderPort) {
    this.persistOrderPort = persistOrderPort;
  }

  @Override
  public Order create(CreateOrderCmd cmd) {
    OrderItem orderItem = new OrderItem(cmd.getProductNo());
    Order order = new Order(List.of(orderItem));
    persistOrderPort.save(order);
    return order;
  }

}
