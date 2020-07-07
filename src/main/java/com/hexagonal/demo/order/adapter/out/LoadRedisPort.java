package com.hexagonal.demo.order.adapter.out;

import reactor.core.publisher.Mono;

public interface LoadRedisPort {
  Mono<String> find(String key);
}
