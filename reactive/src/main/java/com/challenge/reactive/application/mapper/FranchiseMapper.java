package com.challenge.reactive.application.mapper;

import com.challenge.reactive.domain.model.Franchise;
import com.challenge.reactive.infrastructure.controller.dto.FranchiseDto;
import com.challenge.reactive.infrastructure.implementation.entity.mysqlentities.FranchiseEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FranchiseMapper {
    FranchiseDto domainToDto(Franchise franchise);
    Franchise dtoToDomain(FranchiseDto franchiseDto);
    FranchiseEntity domainToEntity(Franchise franchise);
    Franchise entityToDomain(FranchiseEntity franchiseEntity);
}
