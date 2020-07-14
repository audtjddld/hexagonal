package com.hexagonal.demo.order.application.port.out;

import reactor.core.publisher.Mono;

public interface LoadRedisPort {
  Mono<String> find(String key);
}
