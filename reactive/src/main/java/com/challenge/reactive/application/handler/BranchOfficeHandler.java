package com.challenge.reactive.application.handler;

import com.challenge.reactive.application.mapper.BranchOfficeMapper;
import com.challenge.reactive.application.mapper.ProductMapper;
import com.challenge.reactive.application.port.branchoffice.BranchOfficeOperationsPort;
import com.challenge.reactive.application.port.products.ProductOperationsPort;
import com.challenge.reactive.infrastructure.classes.GenericResponse;
import com.challenge.reactive.infrastructure.classes.enumclasses.EnumResponses;
import com.challenge.reactive.infrastructure.controller.dto.BranchOfficeDto;
import com.challenge.reactive.infrastructure.controller.dto.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class BranchOfficeHandler {
    @Autowired
    private BranchOfficeOperationsPort branchOfficeOperationsPort;
    @Autowired
    private BranchOfficeMapper branchOfficeMapper;

    public Mono<BranchOfficeDto> createNewBranchOffice(BranchOfficeDto branchOfficeDto) {
        return branchOfficeOperationsPort.createNewBranchOffice(branchOfficeMapper.dtoToDomain(branchOfficeDto))
                .map(branchOffice -> branchOfficeMapper.domainToDto(branchOffice));
    }

    public Mono<GenericResponse> deleteBranchOffice(Long id) {
        return branchOfficeOperationsPort.deleteBranchOffice(id)
                .flatMap(response -> {
                    if (response.equals(EnumResponses.SUCCESS_DELETE.getMessage())) {
                        return Mono.just(new GenericResponse(EnumResponses.SUCCESS_DELETE.getCode(), EnumResponses.SUCCESS_DELETE.getMessage()));
                    }
                    return Mono.just(new GenericResponse(EnumResponses.ERROR_001.getCode(), EnumResponses.ERROR_001.getMessage()));
                });
    }

    public Mono<BranchOfficeDto> updateBranchOffice(BranchOfficeDto branchOfficeDto) {
        return branchOfficeOperationsPort.updateBranchOffice(branchOfficeMapper.dtoToDomain(branchOfficeDto))
                .map(branchOffice -> branchOfficeMapper.domainToDto(branchOffice));
    }

    public Flux<BranchOfficeDto> getAllBranchOffices() {
        return branchOfficeOperationsPort.getAll()
                .map(branchOffice -> branchOfficeMapper.domainToDto(branchOffice));
    }

    public Mono<BranchOfficeDto> getBranchOfficeById(Long id) {
        return branchOfficeOperationsPort.getBranchOfficeById(id)
                .map(branchOffice -> branchOfficeMapper.domainToDto(branchOffice));
    }
}
