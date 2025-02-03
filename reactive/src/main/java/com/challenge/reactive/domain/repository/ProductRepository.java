package com.challenge.reactive.domain.repository;

import com.challenge.reactive.domain.model.Product;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductRepository {
    Mono<Product> save(Product product);
    Mono<Product> delete(String id);
    Mono<Product> update(Product product);
    Flux<Product> findAll();
    Mono<Product> findById(String id);
}
