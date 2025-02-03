package com.challenge.reactive.application.handler;

import com.challenge.reactive.application.mapper.BranchOfficeMapper;
import com.challenge.reactive.application.mapper.BranchOfficeProductMapper;
import com.challenge.reactive.application.port.branchoffice.BranchOfficeOperationsPort;
import com.challenge.reactive.application.port.branchoffice.BranchOfficeProductOperationsPort;
import com.challenge.reactive.infrastructure.classes.GenericResponse;
import com.challenge.reactive.infrastructure.classes.enumclasses.EnumResponses;
import com.challenge.reactive.infrastructure.controller.dto.BranchOfficeProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class BranchOfficeProductHandler {
    @Autowired
    private BranchOfficeProductOperationsPort branchOfficeProductOperationsPort;
    @Autowired
    private BranchOfficeProductMapper branchOfficeProductMapper;

    public Mono<BranchOfficeProductDto> addProductToBranchOffice(BranchOfficeProductDto branchOfficeProductDto) {
        return branchOfficeProductOperationsPort.addProductToBranchOffice(branchOfficeProductMapper.dtoToDomain(branchOfficeProductDto))
                .map(branchOfficeProduct -> branchOfficeProductMapper.domainToDto(branchOfficeProduct));
    }

    public Mono<GenericResponse> deleteProductFromBranchOffice(Long id) {
        return branchOfficeProductOperationsPort.deleteProductFromBranchOffice(id)
                .flatMap(response -> {
                    if (response.equals(EnumResponses.SUCCESS_DELETE.getMessage())) {
                        return Mono.just(new GenericResponse(EnumResponses.SUCCESS_DELETE.getCode(), EnumResponses.SUCCESS_DELETE.getMessage()));
                    }
                    return Mono.just(new GenericResponse(EnumResponses.ERROR_001.getCode(), EnumResponses.ERROR_001.getMessage()));
                });
    }

    public Mono<BranchOfficeProductDto> updateProductFromBranchOffice(BranchOfficeProductDto branchOfficeProductDto) {
        return branchOfficeProductOperationsPort.updateProductFromBranchOffice(branchOfficeProductMapper.dtoToDomain(branchOfficeProductDto))
                .map(branchOfficeProduct -> branchOfficeProductMapper.domainToDto(branchOfficeProduct));
    }

    public Flux<BranchOfficeProductDto> getAllProductsFromBranchOffice(Long id) {
        return branchOfficeProductOperationsPort.getAllProductsFromBranchOffice(id)
                .map(branchOfficeProduct -> branchOfficeProductMapper.domainToDto(branchOfficeProduct));
    }

    public Mono<BranchOfficeProductDto> getTopStockProductByBranchOffice(Long id) {
        return branchOfficeProductOperationsPort.getTopStockProductByBranchOffice(id)
                .map(branchOfficeProduct -> branchOfficeProductMapper.domainToDto(branchOfficeProduct));
    }
}
