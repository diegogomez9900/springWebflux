package com.challenge.reactive.infrastructure.implementation;

import com.challenge.reactive.application.mapper.BranchOfficeProductMapper;
import com.challenge.reactive.domain.model.BranchOfficeProduct;
import com.challenge.reactive.domain.repository.BranchOfficeProductRepository;
import com.challenge.reactive.infrastructure.classes.enumclasses.EnumResponses;
import com.challenge.reactive.infrastructure.exception.classes.DeletingException;
import com.challenge.reactive.infrastructure.exception.classes.GettingException;
import com.challenge.reactive.infrastructure.exception.classes.SavingException;
import com.challenge.reactive.infrastructure.exception.classes.UpdatingException;
import com.challenge.reactive.infrastructure.implementation.repository.BranchOfficeProductMySqlAsyncRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class BranchOfficeProductRepositoryImpl implements BranchOfficeProductRepository {

    @Autowired
    private BranchOfficeProductMySqlAsyncRepository repository;
    @Autowired
    private BranchOfficeProductMapper mapper;

    @Override
    public Mono<BranchOfficeProduct> save(BranchOfficeProduct branchOfficeProduct) {
        return repository.save(mapper.domainToEntity(branchOfficeProduct))
                .map(mapper::entityToDomain)
                .onErrorMap(Exception.class, e -> new SavingException(
                        "Error Saving Branch Product: " + (e.getMessage() == null ? EnumResponses.ERROR_004.getMessage() : e.getMessage()))
                )
                .onErrorMap(Throwable.class, e -> new SavingException(
                        "Error Saving Branch Product: " + (e.getMessage() == null ? EnumResponses.ERROR_004.getMessage() : e.getMessage()))
                );
    }

    @Override
    public Mono<String> delete(Long id) {
        return repository.deleteById(id)
                .then(Mono.just(EnumResponses.SUCCESS_DELETE.getMessage()))
                .onErrorMap(Exception.class, e -> new DeletingException(
                        "Error Deleting Branch Product: " + (e.getMessage() == null ? EnumResponses.ERROR_001.getMessage() : e.getMessage()))
                );
    }

    @Override
    public Mono<BranchOfficeProduct> update(BranchOfficeProduct branchOfficeProduct) {
        return repository.findById(branchOfficeProduct.getId())
                .switchIfEmpty(Mono.error(new Exception("Branch Office not found")))
                .flatMap(branchOfficeObj -> {
                    branchOfficeObj.setProductId(branchOfficeProduct.getProductId());
                    branchOfficeObj.setBranchOfficeId(branchOfficeProduct.getBranchOfficeId());
                    branchOfficeObj.setStock(branchOfficeProduct.getStock());
                    return repository.save(branchOfficeObj);
                })
                .map(mapper::entityToDomain)
                .onErrorMap(Exception.class, e -> new UpdatingException(
                        "Error Updating Branch Product: " + (e.getMessage() == null ? EnumResponses.ERROR_002.getMessage() : e.getMessage()))
                );
    }

    @Override
    public Flux<BranchOfficeProduct> findAllByBranchOfficeId(Long id) {
        return repository.findAllByBranchOfficeId(id)
                .map(mapper::entityToDomain)
                .onErrorMap(Exception.class, e -> new GettingException(
                        "Error Getting Branch Products: " + (e.getMessage() == null ? EnumResponses.ERROR_003.getMessage() : e.getMessage()))
                );
    }

    @Override
    public Mono<BranchOfficeProduct> findFirstByBranchOfficeIdOrderByStockDesc(Long id) {
        return repository.findFirstByBranchOfficeIdOrderByStockDesc(id)
                .switchIfEmpty(Mono.error(new Exception("Branch Office has not associated products")))
                .map(mapper::entityToDomain)
                .onErrorMap(Exception.class, e -> new GettingException(
                        "Error Getting Branch Product: " + (e.getMessage() == null ? EnumResponses.ERROR_003.getMessage() : e.getMessage()))
                );
    }
}
