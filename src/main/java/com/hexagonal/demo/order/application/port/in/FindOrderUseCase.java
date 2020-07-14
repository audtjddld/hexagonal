package com.hexagonal.demo.order.application.port.in;

import com.hexagonal.demo.order.port.command.FindOrderCmd;
import com.hexagonal.demo.order.domain.Order;

public interface FindOrderUseCase {
  Order find(FindOrderCmd cmd);
}
