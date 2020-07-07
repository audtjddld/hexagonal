package com.hexagonal.demo.infra.redis.adapter;

import com.hexagonal.demo.order.port.out.PersistRedisPort;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class PersistRedisAdapter implements PersistRedisPort {

  private final ReactiveRedisTemplate<String, String> template;

  public PersistRedisAdapter(ReactiveRedisTemplate<String, String> template) {
    this.template = template;
  }

  @Override
  public Mono<String> save(String key, String value) {
    return template.opsForValue().set(key, value)
        .flatMap(result -> {
          if (result) {
            return Mono.just("임시 주문서가 생성 되었습니다.");
          } else {
            return Mono.just("임시 주문서 생성에 실패하였습니다.");
          }
        });
  }

}
