package com.challenge.reactive.domain.repository;

import com.challenge.reactive.domain.model.BranchProduct;
import com.challenge.reactive.domain.model.FranchiseBranchOffice;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface FranchiseBranchOfficeRepository {
    Mono<FranchiseBranchOffice> save(FranchiseBranchOffice FranchiseBranchOffice);
    Mono<String> delete(Long id);
    Mono<FranchiseBranchOffice> update(FranchiseBranchOffice FranchiseBranchOffice);
    Flux<FranchiseBranchOffice> findAllByFranchiseId(Long id);
    Flux<BranchProduct> findAllByFranchiseIdWithTopStockProduct(Long id);
}
