package com.hexagonal.demo.order.adapter.out;

import reactor.core.publisher.Mono;

public interface PersistRedisPort {
  Mono<String> save(String key, String value);
}
