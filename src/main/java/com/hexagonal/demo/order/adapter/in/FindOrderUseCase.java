package com.hexagonal.demo.order.adapter.in;

import com.hexagonal.demo.order.controller.model.FindOrderCmd;
import com.hexagonal.demo.order.domain.Order;

public interface FindOrderUseCase {
  Order find(FindOrderCmd cmd);
}
