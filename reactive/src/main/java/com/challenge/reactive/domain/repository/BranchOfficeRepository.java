package com.challenge.reactive.domain.repository;

import com.challenge.reactive.domain.model.BranchOffice;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BranchOfficeRepository {
    Mono<BranchOffice> save(BranchOffice BranchOffice);
    Mono<String> delete(Long id);
    Mono<BranchOffice> update(BranchOffice BranchOffice);
    Flux<BranchOffice> findAll();
    Mono<BranchOffice> findById(Long id);
}
