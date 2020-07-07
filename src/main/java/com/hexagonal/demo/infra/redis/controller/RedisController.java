package com.hexagonal.demo.infra.redis.controller;

import com.hexagonal.demo.order.port.out.LoadRedisPort;
import com.hexagonal.demo.order.port.out.PersistRedisPort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import reactor.core.publisher.Mono;
import java.util.Objects;

@RequestMapping(path = "order")
@Controller
public class RedisController {

  private final LoadRedisPort loadRedisPort;

  private final PersistRedisPort persistRedisPort;

  public RedisController(LoadRedisPort loadRedisPort, PersistRedisPort persistRedisPort) {
    this.loadRedisPort = loadRedisPort;
    this.persistRedisPort = persistRedisPort;
  }


  @PostMapping(path = "temporary")
  public Mono<String> createTemporaryOrder(String key, String value) {
    return loadRedisPort.find(key)
        .flatMap(this::existPreviousOrder)
        .flatMap(exist -> {
          if (!exist) {
            return persistRedisPort.save(key, value);
          } else {
            return Mono.just("이미 생성된 주문서가 존재합니다.");
          }
        });
  }

  private Mono<? extends Boolean> existPreviousOrder(String s) {
    if (Objects.isNull(s)) {
      return Mono.just(true);
    } else {
      return Mono.just(false);
    }
  }

}

