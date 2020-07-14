package com.hexagonal.demo.application.order.port.out;

import com.hexagonal.demo.application.order.domain.Order;

public interface PersistOrderPort {
  Order save(Order order);
}
