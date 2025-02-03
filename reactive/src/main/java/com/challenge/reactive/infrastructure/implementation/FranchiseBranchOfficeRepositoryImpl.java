package com.challenge.reactive.infrastructure.implementation;

import com.challenge.reactive.application.mapper.FranchiseBranchOfficeMapper;
import com.challenge.reactive.domain.model.BranchOfficeProduct;
import com.challenge.reactive.domain.model.BranchProduct;
import com.challenge.reactive.domain.model.FranchiseBranchOffice;
import com.challenge.reactive.domain.repository.FranchiseBranchOfficeRepository;
import com.challenge.reactive.infrastructure.classes.enumclasses.EnumResponses;
import com.challenge.reactive.infrastructure.exception.classes.DeletingException;
import com.challenge.reactive.infrastructure.exception.classes.GettingException;
import com.challenge.reactive.infrastructure.exception.classes.SavingException;
import com.challenge.reactive.infrastructure.exception.classes.UpdatingException;
import com.challenge.reactive.infrastructure.implementation.repository.FranchiseBranchOfficeMySqlAsyncRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class FranchiseBranchOfficeRepositoryImpl implements FranchiseBranchOfficeRepository {

    @Autowired
    private FranchiseBranchOfficeMySqlAsyncRepository repository;
    @Autowired
    private BranchOfficeProductRepositoryImpl branchOfficeProductRepository;
    @Autowired
    private FranchiseBranchOfficeMapper mapper;

    @Override
    public Mono<FranchiseBranchOffice> save(FranchiseBranchOffice franchiseBranchOffice) {
        return repository.save(mapper.domainToEntity(franchiseBranchOffice))
                .map(mapper::entityToDomain)
                .onErrorMap(Exception.class, e -> new SavingException(
                        "Error Saving Franchise: " + (e.getMessage() == null ? EnumResponses.ERROR_004.getMessage() : e.getMessage()))
                );
    }

    @Override
    public Mono<String> delete(Long id) {
        return repository.deleteById(id)
                .then(Mono.just(EnumResponses.SUCCESS_DELETE.getMessage()))
                .onErrorMap(Exception.class, e -> new DeletingException(
                        "Error Deleting Franchise: " + (e.getMessage() == null ? EnumResponses.ERROR_001.getMessage() : e.getMessage()))
                );
    }

    @Override
    public Mono<FranchiseBranchOffice> update(FranchiseBranchOffice franchiseBranchOffice) {
        return repository.findById(franchiseBranchOffice.getId())
                .switchIfEmpty(Mono.error(new Exception("Franchise not found")))
                .flatMap(franchiseBranchOfficeObj -> {
                    franchiseBranchOfficeObj.setFranchiseId(franchiseBranchOffice.getFranchiseId());
                    franchiseBranchOfficeObj.setBranchOfficeId(franchiseBranchOffice.getBranchOfficeId());
                    return repository.save(franchiseBranchOfficeObj);
                })
                .map(mapper::entityToDomain)
                .onErrorMap(Exception.class, e -> new UpdatingException(
                        "Error Updating Franchise: " + (e.getMessage() == null ? EnumResponses.ERROR_002.getMessage() : e.getMessage()))
                );
    }

    @Override
    public Flux<FranchiseBranchOffice> findAllByFranchiseId(Long id) {
        return repository.findAllByFranchiseId(id)
                .map(mapper::entityToDomain)
                .onErrorMap(Exception.class, e -> new GettingException(
                        "Error Getting Franchises: " + (e.getMessage() == null ? EnumResponses.ERROR_003.getMessage() : e.getMessage()))
                );
    }

    @Override
    public Flux<BranchProduct> findAllByFranchiseIdWithTopStockProduct(Long id) {
        return repository.findAllByFranchiseId(id)
                .flatMap(branchOffice -> branchOfficeProductRepository.findFirstByBranchOfficeIdOrderByStockDesc(branchOffice.getBranchOfficeId())
                            .map(branchProduct -> new BranchProduct(branchProduct.getBranchOfficeId(), branchProduct.getProductId(), branchProduct.getStock()))
                )
                .onErrorMap(Exception.class, e -> new GettingException(
                        "Error Getting Top Branch Product From Franchises: " + (e.getMessage() == null ? EnumResponses.ERROR_003.getMessage() : e.getMessage()))
                );
    }
}
