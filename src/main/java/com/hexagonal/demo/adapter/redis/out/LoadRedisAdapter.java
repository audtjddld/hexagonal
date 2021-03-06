package com.hexagonal.demo.adapter.redis.out;

import com.hexagonal.demo.application.order.port.out.LoadRedisPort;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class LoadRedisAdapter implements LoadRedisPort {

  private final ReactiveRedisTemplate<String, String> template;

  public LoadRedisAdapter(ReactiveRedisTemplate<String, String> template) {
    this.template = template;
  }

  @Override
  public Mono<String> find(String key) {
    return template.opsForValue().get(key);
  }

}
