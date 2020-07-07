package com.hexagonal.demo.order.port.out;

import reactor.core.publisher.Mono;

public interface PersistRedisPort {
  Mono<String> save(String key, String value);
}
