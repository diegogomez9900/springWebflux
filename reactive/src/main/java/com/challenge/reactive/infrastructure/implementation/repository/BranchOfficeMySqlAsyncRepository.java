package com.challenge.reactive.infrastructure.implementation.repository;

import com.challenge.reactive.infrastructure.implementation.entity.mysqlentities.BranchOfficeEntity;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BranchOfficeMySqlAsyncRepository extends R2dbcRepository<BranchOfficeEntity, Long> {
}
