package com.hexagonal.demo.application.order.service;

import com.hexagonal.demo.application.order.port.in.CreateOrderUseCase;
import com.hexagonal.demo.application.order.port.out.PersistOrderPort;
import com.hexagonal.demo.application.order.domain.Order;
import com.hexagonal.demo.application.order.domain.OrderItem;
import com.hexagonal.demo.application.order.command.CreateOrderCmd;
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
