package com.hexagonal.demo.order.adapter.out;

import com.hexagonal.demo.order.domain.Order;

public interface LoadOrderPort {
  Order findById(Long id);
}
