package com.hexagonal.demo.application.order.port.in;

import com.hexagonal.demo.application.order.command.FindOrderCmd;
import com.hexagonal.demo.application.order.domain.Order;

public interface FindOrderUseCase {
  Order find(FindOrderCmd cmd);
}
