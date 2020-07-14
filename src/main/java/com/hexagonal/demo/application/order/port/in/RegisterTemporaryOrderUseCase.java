package com.hexagonal.demo.application.order.port.in;

import com.hexagonal.demo.application.order.command.RegisterTemporaryOrderCmd;
import reactor.core.publisher.Mono;

public interface RegisterTemporaryOrderUseCase {
  Mono<String> register(RegisterTemporaryOrderCmd cmd);
}
