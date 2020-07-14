package com.hexagonal.demo.web.in;

import com.hexagonal.demo.application.order.port.in.CreateOrderUseCase;
import com.hexagonal.demo.application.order.port.in.FindOrderUseCase;
import com.hexagonal.demo.application.order.domain.Order;
import com.hexagonal.demo.application.order.command.CreateOrderCmd;
import com.hexagonal.demo.application.order.command.FindOrderCmd;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@RequestMapping(path = "orders")
@Controller
public class OrderController {

  private final CreateOrderUseCase createOrderUseCase;
  private final FindOrderUseCase findOrderUseCase;

  public OrderController(CreateOrderUseCase createOrderUseCase, FindOrderUseCase findOrderUseCase) {
    this.createOrderUseCase = createOrderUseCase;
    this.findOrderUseCase = findOrderUseCase;
  }

  @PostMapping
  public ResponseEntity<Void> createOrder(CreateOrderCmd cmd) {
    createOrderUseCase.create(cmd);
    return ResponseEntity.ok().build();
  }

  @GetMapping(path = "{id}")
  private ResponseEntity<Order> findOrder(@PathVariable("id") Long id) {
    FindOrderCmd cmd = new FindOrderCmd(id);
    Order order = findOrderUseCase.find(cmd);
    return ResponseEntity.ok(order);
  }
}
