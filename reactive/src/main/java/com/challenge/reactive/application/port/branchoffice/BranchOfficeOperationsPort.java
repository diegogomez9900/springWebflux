package com.challenge.reactive.application.port.branchoffice;

import com.challenge.reactive.domain.model.BranchOffice;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BranchOfficeOperationsPort {
    Mono<BranchOffice> createNewBranchOffice(BranchOffice BranchOffice);
    Mono<String> deleteBranchOffice(Long id);
    Mono<BranchOffice> updateBranchOffice(BranchOffice BranchOffice);
    Flux<BranchOffice> getAll();
    Mono<BranchOffice> getBranchOfficeById(Long id);
}
