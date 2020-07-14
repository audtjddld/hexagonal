package com.hexagonal.demo.order.application.service;

import com.hexagonal.demo.order.application.port.in.FindOrderUseCase;
import com.hexagonal.demo.order.application.port.out.LoadOrderPort;
import com.hexagonal.demo.order.port.command.FindOrderCmd;
import com.hexagonal.demo.order.domain.Order;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FindOrderService implements FindOrderUseCase {

  private final LoadOrderPort loadOrderPort;

  public FindOrderService(LoadOrderPort loadOrderPort) {
    this.loadOrderPort = loadOrderPort;
  }

  @Transactional(readOnly = true)
  @Override
  public Order find(FindOrderCmd cmd) {
    return loadOrderPort.findById(cmd.getId());
  }

}
