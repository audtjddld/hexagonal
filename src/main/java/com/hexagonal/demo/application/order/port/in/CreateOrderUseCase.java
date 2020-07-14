package com.hexagonal.demo.application.order.port.in;

import com.hexagonal.demo.application.order.command.CreateOrderCmd;
import com.hexagonal.demo.application.order.domain.Order;

public interface CreateOrderUseCase {
  Order create(CreateOrderCmd cmd);
}
