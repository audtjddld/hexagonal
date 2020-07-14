package com.hexagonal.demo.application.order.port.out;

import com.hexagonal.demo.application.order.domain.Order;

public interface LoadOrderPort {
  Order findById(Long id);
}
