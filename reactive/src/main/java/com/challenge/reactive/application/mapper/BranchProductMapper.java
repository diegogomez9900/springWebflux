package com.challenge.reactive.application.mapper;

import com.challenge.reactive.domain.model.BranchProduct;
import com.challenge.reactive.infrastructure.controller.dto.BranchProductDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BranchProductMapper {
    BranchProductDto domainToDto(BranchProduct branchProduct);
    BranchProduct dtoToDomain(BranchProductDto branchProductDto);
}
