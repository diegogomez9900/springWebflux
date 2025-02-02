package com.challenge.reactive.domain.usecase;

import com.challenge.reactive.application.port.branchoffice.BranchOfficeProductOperationsPort;
import com.challenge.reactive.domain.model.BranchOfficeProduct;
import com.challenge.reactive.domain.repository.BranchOfficeProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class BranchOfficeProductOperationsUseCase implements BranchOfficeProductOperationsPort {
    @Autowired
    private BranchOfficeProductRepository branchOfficeProductRepository;

    @Override
    public Mono<BranchOfficeProduct> addProductToBranchOffice(BranchOfficeProduct branchOfficeProduct) {
        return branchOfficeProductRepository.save(branchOfficeProduct);
    }

    @Override
    public Mono<String> deleteProductFromBranchOffice(Long id) {
        return branchOfficeProductRepository.delete(id);
    }

    @Override
    public Mono<BranchOfficeProduct> updateProductFromBranchOffice(BranchOfficeProduct branchOfficeProduct) {
        return branchOfficeProductRepository.update(branchOfficeProduct);
    }

    @Override
    public Flux<BranchOfficeProduct> getAllProductsFromBranchOffice(Long id) {
        return branchOfficeProductRepository.findAllByBranchOfficeId(id);
    }

    @Override
    public Mono<BranchOfficeProduct> getTopStockProductByBranchOffice(Long id) {
        return branchOfficeProductRepository.findFirstByBranchOfficeIdOrderByStockDesc(id);
    }
}
