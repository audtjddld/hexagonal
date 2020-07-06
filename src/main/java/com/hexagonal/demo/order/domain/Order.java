package com.hexagonal.demo.order.domain;

import lombok.Getter;
import java.util.List;

@Getter
public class Order {

  private Long id;
  private List<OrderItem> orderItems;

  protected Order() {

  }

  public Order(List<OrderItem> orderItems) {
    this.orderItems = orderItems;
  }

}
