package com.challenge.reactive.application.port.franchise;

import com.challenge.reactive.domain.model.BranchProduct;
import com.challenge.reactive.domain.model.FranchiseBranchOffice;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface FranchiseBranchOfficeOperationsPort {
    Mono<FranchiseBranchOffice> addBranchToFranchise(FranchiseBranchOffice franchiseBranchOffice);
    Mono<String> deleteBranchFromFranchise(Long id);
    Mono<FranchiseBranchOffice> updateBranchFromFranchise(FranchiseBranchOffice franchiseBranchOffice);
    Flux<FranchiseBranchOffice> getAllBranchesFromFranchise(Long id);
    Flux<BranchProduct> getAllBranchesWithTopStockProductFromFranchise(Long id);
}
