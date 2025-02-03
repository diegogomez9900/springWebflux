package com.challenge.reactive.application.mapper;

import com.challenge.reactive.domain.model.FranchiseBranchOffice;
import com.challenge.reactive.infrastructure.controller.dto.FranchiseBranchOfficeDto;
import com.challenge.reactive.infrastructure.implementation.entity.mysqlentities.FranchiseBranchOfficeEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FranchiseBranchOfficeMapper {
    FranchiseBranchOfficeDto domainToDto(FranchiseBranchOffice franchiseBranchOffice);
    FranchiseBranchOffice dtoToDomain(FranchiseBranchOfficeDto franchiseBranchOfficeDto);
    FranchiseBranchOffice entityToDomain(FranchiseBranchOfficeEntity franchiseBranchOfficeEntity);
    FranchiseBranchOfficeEntity domainToEntity(FranchiseBranchOffice franchiseBranchOffice);
}
