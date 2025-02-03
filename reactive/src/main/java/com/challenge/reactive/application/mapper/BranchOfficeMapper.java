package com.challenge.reactive.application.mapper;

import com.challenge.reactive.domain.model.BranchOffice;
import com.challenge.reactive.infrastructure.controller.dto.BranchOfficeDto;
import com.challenge.reactive.infrastructure.implementation.entity.mysqlentities.BranchOfficeEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BranchOfficeMapper {
    BranchOfficeDto domainToDto(BranchOffice branchOffice);
    BranchOffice dtoToDomain(BranchOfficeDto branchOfficeDto);
    BranchOffice entityToDomain(BranchOfficeEntity branchOfficeEntity);
    BranchOfficeEntity domainToEntity(BranchOffice branchOffice);
}
