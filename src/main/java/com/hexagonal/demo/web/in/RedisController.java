package com.hexagonal.demo.web.in;

import com.hexagonal.demo.application.order.command.RegisterTemporaryOrderCmd;
import com.hexagonal.demo.application.order.port.in.RegisterTemporaryOrderUseCase;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import reactor.core.publisher.Mono;

@RequestMapping(path = "order")
@Controller
public class RedisController {

  private final RegisterTemporaryOrderUseCase registerTemporaryOrderUseCase;

  public RedisController(RegisterTemporaryOrderUseCase registerTemporaryOrderUseCase) {
    this.registerTemporaryOrderUseCase = registerTemporaryOrderUseCase;
  }

  // 임시 주문서 생성
  @PostMapping(path = "temporary")
  public Mono<String> createTemporaryOrder(String key, String value) {
    return registerTemporaryOrderUseCase.register(new RegisterTemporaryOrderCmd(key, value));
  }
}

