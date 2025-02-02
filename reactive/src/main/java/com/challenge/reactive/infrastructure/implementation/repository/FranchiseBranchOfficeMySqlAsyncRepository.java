package com.challenge.reactive.infrastructure.implementation.repository;

import com.challenge.reactive.infrastructure.implementation.entity.mysqlentities.FranchiseBranchOfficeEntity;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface FranchiseBranchOfficeMySqlAsyncRepository extends R2dbcRepository<FranchiseBranchOfficeEntity, Long> {
    Flux<FranchiseBranchOfficeEntity> findAllByFranchiseId(Long id);
}
