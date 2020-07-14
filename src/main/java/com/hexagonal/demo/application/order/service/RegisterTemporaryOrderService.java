package com.hexagonal.demo.application.order.service;

import com.hexagonal.demo.application.order.command.RegisterTemporaryOrderCmd;
import com.hexagonal.demo.application.order.port.in.RegisterTemporaryOrderUseCase;
import com.hexagonal.demo.application.order.port.out.LoadRedisPort;
import com.hexagonal.demo.application.order.port.out.PersistRedisPort;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import java.util.Objects;

@Service
public class RegisterTemporaryOrderService implements RegisterTemporaryOrderUseCase {

  private final LoadRedisPort loadRedisPort;
  private final PersistRedisPort persistRedisPort;

  public RegisterTemporaryOrderService(LoadRedisPort loadRedisPort, PersistRedisPort persistRedisPort) {
    this.loadRedisPort = loadRedisPort;
    this.persistRedisPort = persistRedisPort;
  }

  @Override
  public Mono<String> register(RegisterTemporaryOrderCmd cmd) {
    return loadRedisPort.find(cmd.getKey())
        .flatMap(this::existPreviousOrder)
        .flatMap(exist -> {
          if (!exist) {
            return persistRedisPort.save(cmd.getKey(), cmd.getValue());
          } else {
            return Mono.just("이미 생성된 주문서가 존재합니다.");
          }
        });
  }

  private Mono<? extends Boolean> existPreviousOrder(String s) {
    if (Objects.isNull(s)) {
      return Mono.just(false);
    } else {
      return Mono.just(true);
    }
  }
}
