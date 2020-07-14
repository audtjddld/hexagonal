package com.hexagonal.demo.application.order.command;

import lombok.Getter;

@Getter
public class RegisterTemporaryOrderCmd {

  private final String key;
  private final String value;

  public RegisterTemporaryOrderCmd(String key, String value) {
    this.key = key;
    this.value = value;
  }

}
