package com.challenge.reactive.domain.usecase;

import com.challenge.reactive.application.port.franchise.FranchiseBranchOfficeOperationsPort;
import com.challenge.reactive.domain.model.BranchProduct;
import com.challenge.reactive.domain.model.FranchiseBranchOffice;
import com.challenge.reactive.domain.repository.FranchiseBranchOfficeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class FranchiseBranchOfficeOperationsUseCase implements FranchiseBranchOfficeOperationsPort {
    @Autowired
    private FranchiseBranchOfficeRepository repository;

    @Override
    public Mono<FranchiseBranchOffice> addBranchToFranchise(FranchiseBranchOffice franchiseBranchOffice) {
        return repository.save(franchiseBranchOffice);
    }

    @Override
    public Mono<String> deleteBranchFromFranchise(Long id) {
        return repository.delete(id);
    }

    @Override
    public Mono<FranchiseBranchOffice> updateBranchFromFranchise(FranchiseBranchOffice franchiseBranchOffice) {
        return repository.update(franchiseBranchOffice);
    }

    @Override
    public Flux<FranchiseBranchOffice> getAllBranchesFromFranchise(Long id) {
        return repository.findAllByFranchiseId(id);
    }

    @Override
    public Flux<BranchProduct> getAllBranchesWithTopStockProductFromFranchise(Long id) {
        return repository.findAllByFranchiseIdWithTopStockProduct(id);
    }
}
