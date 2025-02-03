package com.challenge.reactive.application.handler;

import com.challenge.reactive.application.mapper.BranchProductMapper;
import com.challenge.reactive.application.mapper.FranchiseBranchOfficeMapper;
import com.challenge.reactive.application.port.franchise.FranchiseBranchOfficeOperationsPort;
import com.challenge.reactive.domain.model.BranchProduct;
import com.challenge.reactive.infrastructure.classes.GenericResponse;
import com.challenge.reactive.infrastructure.classes.enumclasses.EnumResponses;
import com.challenge.reactive.infrastructure.controller.dto.BranchProductDto;
import com.challenge.reactive.infrastructure.controller.dto.FranchiseBranchOfficeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class FranchiseBranchOfficeHandler {
    @Autowired
    private FranchiseBranchOfficeOperationsPort franchiseBranchOfficeOperationsPort;
    @Autowired
    private FranchiseBranchOfficeMapper franchiseBranchOfficeMapper;
    @Autowired
    private BranchProductMapper branchProductMapper;

    public Mono<FranchiseBranchOfficeDto> addBranchToFranchise(FranchiseBranchOfficeDto franchiseBranchOfficeDto) {
        return franchiseBranchOfficeOperationsPort.addBranchToFranchise(franchiseBranchOfficeMapper.dtoToDomain(franchiseBranchOfficeDto))
                .map(franchiseBranchOffice -> franchiseBranchOfficeMapper.domainToDto(franchiseBranchOffice));
    }

    public Mono<GenericResponse> deleteBranchFromFranchise(Long id) {
        return franchiseBranchOfficeOperationsPort.deleteBranchFromFranchise(id)
                .flatMap(response -> {
                    if (response.equals(EnumResponses.SUCCESS_DELETE.getMessage())) {
                        return Mono.just(new GenericResponse(EnumResponses.SUCCESS_DELETE.getCode(), EnumResponses.SUCCESS_DELETE.getMessage()));
                    }
                    return Mono.just(new GenericResponse(EnumResponses.ERROR_001.getCode(), EnumResponses.ERROR_001.getMessage()));
                });
    }

    public Mono<FranchiseBranchOfficeDto> updateBranchFromFranchise(FranchiseBranchOfficeDto franchiseBranchOfficeDto) {
        return franchiseBranchOfficeOperationsPort.updateBranchFromFranchise(franchiseBranchOfficeMapper.dtoToDomain(franchiseBranchOfficeDto))
                .map(franchiseBranchOffice -> franchiseBranchOfficeMapper.domainToDto(franchiseBranchOffice));
    }

    public Flux<FranchiseBranchOfficeDto> getAllBranchesFromFranchise(Long id) {
        return franchiseBranchOfficeOperationsPort.getAllBranchesFromFranchise(id)
                .map(franchiseBranchOffice -> franchiseBranchOfficeMapper.domainToDto(franchiseBranchOffice));
    }

    public Flux<BranchProductDto> getAllBranchesWithTopStockProductFromFranchise(Long id) {
        return franchiseBranchOfficeOperationsPort.getAllBranchesWithTopStockProductFromFranchise(id)
                .map(branchProduct -> branchProductMapper.domainToDto(branchProduct));
    }
}
