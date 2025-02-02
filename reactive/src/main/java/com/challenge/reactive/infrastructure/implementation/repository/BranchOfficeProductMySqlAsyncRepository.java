package com.challenge.reactive.infrastructure.implementation.repository;

import com.challenge.reactive.infrastructure.implementation.entity.mysqlentities.BranchOfficeProductEntity;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface BranchOfficeProductMySqlAsyncRepository extends R2dbcRepository<BranchOfficeProductEntity, Long> {
    Flux<BranchOfficeProductEntity> findAllByBranchOfficeId(Long id);
    Mono<BranchOfficeProductEntity> findFirstByBranchOfficeIdOrderByStockDesc(Long id);
}
