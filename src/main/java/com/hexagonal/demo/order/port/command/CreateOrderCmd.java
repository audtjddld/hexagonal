package com.hexagonal.demo.order.port.command;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CreateOrderCmd {
  private Long productNo;
}
