package com.challenge.reactive.application.mapper;

import com.challenge.reactive.domain.model.BranchOfficeProduct;
import com.challenge.reactive.infrastructure.controller.dto.BranchOfficeProductDto;
import com.challenge.reactive.infrastructure.implementation.entity.mysqlentities.BranchOfficeProductEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BranchOfficeProductMapper {
    BranchOfficeProductDto domainToDto(BranchOfficeProduct branchOfficeProduct);
    BranchOfficeProduct dtoToDomain(BranchOfficeProductDto branchOfficeProductDto);
    BranchOfficeProduct entityToDomain(BranchOfficeProductEntity branchOfficeProductEntity);
    BranchOfficeProductEntity domainToEntity(BranchOfficeProduct branchOfficeProduct);
}
