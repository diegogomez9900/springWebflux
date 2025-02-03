package com.challenge.reactive.infrastructure.implementation;

import com.challenge.reactive.application.mapper.BranchOfficeMapper;
import com.challenge.reactive.domain.model.BranchOffice;
import com.challenge.reactive.domain.repository.BranchOfficeRepository;
import com.challenge.reactive.infrastructure.classes.enumclasses.EnumResponses;
import com.challenge.reactive.infrastructure.exception.classes.DeletingException;
import com.challenge.reactive.infrastructure.exception.classes.GettingException;
import com.challenge.reactive.infrastructure.exception.classes.SavingException;
import com.challenge.reactive.infrastructure.exception.classes.UpdatingException;
import com.challenge.reactive.infrastructure.implementation.repository.BranchOfficeMySqlAsyncRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class BranchOfficeRepositoryImpl implements BranchOfficeRepository {

    @Autowired
    private BranchOfficeMySqlAsyncRepository repository;
    @Autowired
    private BranchOfficeMapper mapper;

    @Override
    public Mono<BranchOffice> save(BranchOffice branchOffice) {
        return repository.save(mapper.domainToEntity(branchOffice))
                .map(mapper::entityToDomain)
                .onErrorMap(Exception.class, e -> new SavingException(
                        "Error Saving Branch Office: " + (e.getMessage() == null ? EnumResponses.ERROR_004.getMessage() : e.getMessage()))
                );
    }

    @Override
    public Mono<String> delete(Long id) {
        return repository.deleteById(id)
                .then(Mono.just(EnumResponses.SUCCESS_DELETE.getMessage()))
                .onErrorMap(Exception.class, e -> new DeletingException(
                        "Error Deleting Branch Office: " + (e.getMessage() == null ? EnumResponses.ERROR_001.getMessage() : e.getMessage()))
                );
    }

    @Override
    public Mono<BranchOffice> update(BranchOffice branchOffice) {
        return repository.findById(branchOffice.getId())
                .switchIfEmpty(Mono.error(new Exception("Branch Office not found")))
                .flatMap(branchOfficeObj -> {
                    branchOfficeObj.setName(branchOffice.getName());
                    branchOfficeObj.setDescription(branchOffice.getDescription());
                    branchOfficeObj.setAddress(branchOffice.getAddress());
                    branchOfficeObj.setEmail(branchOffice.getEmail());
                    return repository.save(branchOfficeObj);
                })
                .map(mapper::entityToDomain)
                .onErrorMap(Exception.class, e -> new UpdatingException(
                        "Error Updating Branch Office: " + (e.getMessage() == null ? EnumResponses.ERROR_002.getMessage() : e.getMessage()))
                );
    }

    @Override
    public Flux<BranchOffice> findAll() {
        return repository.findAll()
                .map(mapper::entityToDomain)
                .onErrorMap(Exception.class, e -> new GettingException(
                        "Error Getting Branch Office: " + (e.getMessage() == null ? EnumResponses.ERROR_003.getMessage() : e.getMessage()))
                );
    }

    @Override
    public Mono<BranchOffice> findById(Long id) {
        return repository.findById(id)
                .switchIfEmpty(Mono.error(new Exception("Branch Office not found")))
                .map(mapper::entityToDomain)
                .onErrorMap(Exception.class, e -> new GettingException(
                        "Error Getting Branch Office: " + (e.getMessage() == null ? EnumResponses.ERROR_003.getMessage() : e.getMessage()))
                );
    }
}
