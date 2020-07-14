package com.hexagonal.demo.order.application.port.out;

import com.hexagonal.demo.order.domain.Order;

public interface PersistOrderPort {
  Order save(Order order);
}
