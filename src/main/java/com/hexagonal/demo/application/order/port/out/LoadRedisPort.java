package com.hexagonal.demo.application.order.port.out;

import reactor.core.publisher.Mono;

public interface LoadRedisPort {
  Mono<String> find(String key);
}
