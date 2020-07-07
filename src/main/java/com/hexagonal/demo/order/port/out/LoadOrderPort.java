package com.hexagonal.demo.order.port.out;

import com.hexagonal.demo.order.domain.Order;

public interface LoadOrderPort {
  Order findById(Long id);
}
