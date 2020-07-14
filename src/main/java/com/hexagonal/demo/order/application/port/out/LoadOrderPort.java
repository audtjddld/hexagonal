package com.hexagonal.demo.order.application.port.out;

import com.hexagonal.demo.order.domain.Order;

public interface LoadOrderPort {
  Order findById(Long id);
}
