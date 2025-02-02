package com.challenge.reactive.domain.usecase;

import com.challenge.reactive.application.port.franchise.FranchiseOperationsPort;
import com.challenge.reactive.domain.model.Franchise;
import com.challenge.reactive.domain.repository.FranchiseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class FranchiseOperationsUseCase implements FranchiseOperationsPort {

    @Autowired
    private FranchiseRepository repository;

    @Override
    public Mono<Franchise> createNewFranchise(Franchise franchise) {
        return repository.save(franchise);
    }

    @Override
    public Mono<String> deleteFranchise(Long id) {
        return repository.delete(id);
    }

    @Override
    public Mono<Franchise> updateFranchise(Franchise franchise) {
        return repository.update(franchise);
    }

    @Override
    public Flux<Franchise> getAll() {
        return repository.findAll();
    }

    @Override
    public Mono<Franchise> getFranchiseById(Long id) {
        return repository.findById(id);
    }
}
