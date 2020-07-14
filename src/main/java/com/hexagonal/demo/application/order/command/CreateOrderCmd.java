package com.hexagonal.demo.application.order.command;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CreateOrderCmd {
  private Long productNo;
}
