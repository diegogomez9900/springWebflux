package com.challenge.reactive.application.port.franchise;

import com.challenge.reactive.domain.model.Franchise;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface FranchiseOperationsPort {
    Mono<Franchise> createNewFranchise(Franchise franchise);
    Mono<String> deleteFranchise(Long id);
    Mono<Franchise> updateFranchise(Franchise franchise);
    Flux<Franchise> getAll();
    Mono<Franchise> getFranchiseById(Long id);
}
