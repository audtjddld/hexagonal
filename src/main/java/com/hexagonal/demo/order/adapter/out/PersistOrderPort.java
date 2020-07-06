package com.hexagonal.demo.order.adapter.out;

import com.hexagonal.demo.order.domain.Order;

public interface PersistOrderPort {
  Order save(Order order);
}
