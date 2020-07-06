package com.hexagonal.demo.order.application;

import com.hexagonal.demo.order.adapter.in.FindOrderUseCase;
import com.hexagonal.demo.order.adapter.out.LoadOrderPort;
import com.hexagonal.demo.order.controller.model.FindOrderCmd;
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
