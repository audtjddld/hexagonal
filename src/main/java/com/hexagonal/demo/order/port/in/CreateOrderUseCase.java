package com.hexagonal.demo.order.port.in;

import com.hexagonal.demo.order.controller.model.CreateOrderCmd;
import com.hexagonal.demo.order.domain.Order;

public interface CreateOrderUseCase {
  Order create(CreateOrderCmd cmd);
}
