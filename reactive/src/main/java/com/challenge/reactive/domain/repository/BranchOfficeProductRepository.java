package com.challenge.reactive.domain.repository;

import com.challenge.reactive.domain.model.BranchOfficeProduct;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BranchOfficeProductRepository {
    Mono<BranchOfficeProduct> save(BranchOfficeProduct BranchOffice);
    Mono<String> delete(Long id);
    Mono<BranchOfficeProduct> update(BranchOfficeProduct BranchOffice);
    Flux<BranchOfficeProduct> findAllByBranchOfficeId(Long id);
    Mono<BranchOfficeProduct> findFirstByBranchOfficeIdOrderByStockDesc(Long id);
}
