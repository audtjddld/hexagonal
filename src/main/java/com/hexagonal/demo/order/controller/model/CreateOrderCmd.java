package com.hexagonal.demo.order.controller.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CreateOrderCmd {
  private Long productNo;
}
