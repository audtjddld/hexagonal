package com.hexagonal.demo.order.application.port.in;

import com.hexagonal.demo.order.port.command.CreateOrderCmd;
import com.hexagonal.demo.order.domain.Order;

public interface CreateOrderUseCase {
  Order create(CreateOrderCmd cmd);
}
