package com.challenge.reactive.application.port.branchoffice;

import com.challenge.reactive.domain.model.BranchOfficeProduct;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BranchOfficeProductOperationsPort {
    Mono<BranchOfficeProduct> addProductToBranchOffice(BranchOfficeProduct branchOfficeProduct);
    Mono<String> deleteProductFromBranchOffice(Long id);
    Mono<BranchOfficeProduct> updateProductFromBranchOffice(BranchOfficeProduct branchOfficeProduct);
    Flux<BranchOfficeProduct> getAllProductsFromBranchOffice(Long id);
    Mono<BranchOfficeProduct> getTopStockProductByBranchOffice(Long id);
}
