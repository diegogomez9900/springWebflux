package com.challenge.reactive.infrastructure.implementation.repository;

import com.challenge.reactive.infrastructure.implementation.entity.mysqlentities.FranchiseEntity;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FranchiseMySqlAsyncRepository extends R2dbcRepository<FranchiseEntity, Long> {
}
