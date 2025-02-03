package com.challenge.reactive.infrastructure.implementation;

import com.challenge.reactive.application.mapper.FranchiseMapper;
import com.challenge.reactive.domain.model.Franchise;
import com.challenge.reactive.domain.repository.FranchiseRepository;
import com.challenge.reactive.infrastructure.classes.enumclasses.EnumResponses;
import com.challenge.reactive.infrastructure.exception.classes.DeletingException;
import com.challenge.reactive.infrastructure.exception.classes.GettingException;
import com.challenge.reactive.infrastructure.exception.classes.SavingException;
import com.challenge.reactive.infrastructure.exception.classes.UpdatingException;
import com.challenge.reactive.infrastructure.implementation.repository.FranchiseMySqlAsyncRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class FranchiseRepositoryImpl implements FranchiseRepository {
    @Autowired
    private FranchiseMySqlAsyncRepository repository;
    @Autowired
    private FranchiseMapper mapper;

    @Override
    public Mono<Franchise> save(Franchise franchise) {
        return repository.save(mapper.domainToEntity(franchise))
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
    public Mono<Franchise> update(Franchise franchise) {
        return repository.findById(franchise.getId())
                .switchIfEmpty(Mono.error(new Exception("Franchise not found")))
                .flatMap(franchiseObj -> {
                    franchiseObj.setName(franchise.getName());
                    franchiseObj.setDescription(franchise.getDescription());
                    return repository.save(franchiseObj);
                })
                .map(mapper::entityToDomain)
                .onErrorMap(Exception.class, e -> new UpdatingException(
                        "Error Updating Franchise: " + (e.getMessage() == null ? EnumResponses.ERROR_002.getMessage() : e.getMessage()))
                );
    }

    @Override
    public Flux<Franchise> findAll() {
        return repository.findAll()
                .map(mapper::entityToDomain)
                .onErrorMap(Exception.class, e -> new GettingException(
                        "Error Getting Franchise: " + (e.getMessage() == null ? EnumResponses.ERROR_003.getMessage() : e.getMessage()))
                );
    }

    @Override
    public Mono<Franchise> findById(Long id) {
        return repository.findById(id)
                .switchIfEmpty(Mono.error(new Exception("Franchise not found")))
                .map(mapper::entityToDomain)
                .onErrorMap(Exception.class, e -> new GettingException(
                        "Error Getting Franchise: " + (e.getMessage() == null ? EnumResponses.ERROR_003.getMessage() : e.getMessage()))
                );
    }
}
