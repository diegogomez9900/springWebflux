package com.challenge.reactive.domain.repository;

import com.challenge.reactive.domain.model.Franchise;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface FranchiseRepository {
    Mono<Franchise> save(Franchise Franchise);
    Mono<String> delete(Long id);
    Mono<Franchise> update(Franchise Franchise);
    Flux<Franchise> findAll();
    Mono<Franchise> findById(Long id);
}
