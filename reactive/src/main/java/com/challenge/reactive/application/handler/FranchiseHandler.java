package com.challenge.reactive.application.handler;

import com.challenge.reactive.application.mapper.FranchiseMapper;
import com.challenge.reactive.application.port.franchise.FranchiseOperationsPort;
import com.challenge.reactive.infrastructure.classes.GenericResponse;
import com.challenge.reactive.infrastructure.classes.enumclasses.EnumResponses;
import com.challenge.reactive.infrastructure.controller.dto.FranchiseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class FranchiseHandler {
    @Autowired
    private FranchiseOperationsPort franchiseOperationsPort;
    @Autowired
    private FranchiseMapper franchiseMapper;

    public Mono<FranchiseDto> createNewFranchise(FranchiseDto franchiseDto) {
        return franchiseOperationsPort.createNewFranchise(franchiseMapper.dtoToDomain(franchiseDto))
                .map(franchise -> franchiseMapper.domainToDto(franchise));
    }

    public Mono<GenericResponse> deleteFranchise(Long id) {
        return franchiseOperationsPort.deleteFranchise(id)
                .flatMap(response -> {
                    if (response.equals(EnumResponses.SUCCESS_DELETE.getMessage())) {
                        return Mono.just(new GenericResponse(EnumResponses.SUCCESS_DELETE.getCode(), EnumResponses.SUCCESS_DELETE.getMessage()));
                    }
                    return Mono.just(new GenericResponse(EnumResponses.ERROR_001.getCode(), EnumResponses.ERROR_001.getMessage()));
                });
    }

    public Mono<FranchiseDto> updateFranchise(FranchiseDto franchiseDto) {
        return franchiseOperationsPort.updateFranchise(franchiseMapper.dtoToDomain(franchiseDto))
                .map(franchise -> franchiseMapper.domainToDto(franchise));
    }

    public Flux<FranchiseDto> getAllFranchises() {
        return franchiseOperationsPort.getAll()
                .map(franchise -> franchiseMapper.domainToDto(franchise));
    }

    public Mono<FranchiseDto> getFranchiseById(Long id) {
        return franchiseOperationsPort.getFranchiseById(id)
                .map(franchise -> franchiseMapper.domainToDto(franchise));
    }
}
