package com.hexagonal.demo.application.order.service;

import com.hexagonal.demo.application.order.port.in.FindOrderUseCase;
import com.hexagonal.demo.application.order.port.out.LoadOrderPort;
import com.hexagonal.demo.application.order.command.FindOrderCmd;
import com.hexagonal.demo.application.order.domain.Order;
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
