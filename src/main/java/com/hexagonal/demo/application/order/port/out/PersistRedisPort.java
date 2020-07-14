package com.hexagonal.demo.application.order.port.out;

import reactor.core.publisher.Mono;

public interface PersistRedisPort {
  Mono<String> save(String key, String value);
}
