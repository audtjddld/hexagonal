package com.hexagonal.demo.order.controller.model;

import lombok.Getter;

@Getter
public class FindOrderCmd {
  private Long id;

  public FindOrderCmd(Long id) {
    this.id = id;
  }

}
