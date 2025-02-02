package com.challenge.reactive.domain.usecase;

import com.challenge.reactive.application.port.branchoffice.BranchOfficeOperationsPort;
import com.challenge.reactive.domain.model.BranchOffice;
import com.challenge.reactive.domain.repository.BranchOfficeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class BranchOfficeOperationsUseCase implements BranchOfficeOperationsPort {
    @Autowired
    private BranchOfficeRepository branchOfficeRepository;
    @Override
    public Mono<BranchOffice> createNewBranchOffice(BranchOffice BranchOffice) {
        return branchOfficeRepository.save(BranchOffice);
    }

    @Override
    public Mono<String> deleteBranchOffice(Long id) {
        return branchOfficeRepository.delete(id);
    }

    @Override
    public Mono<BranchOffice> updateBranchOffice(BranchOffice BranchOffice) {
        return branchOfficeRepository.update(BranchOffice);
    }

    @Override
    public Flux<BranchOffice> getAll() {
        return branchOfficeRepository.findAll();
    }

    @Override
    public Mono<BranchOffice> getBranchOfficeById(Long id) {
        return branchOfficeRepository.findById(id);
    }
}
