package com.hexagonal.demo.application.order.command;

import lombok.Getter;

@Getter
public class FindOrderCmd {
  private Long id;

  public FindOrderCmd(Long id) {
    this.id = id;
  }

}
