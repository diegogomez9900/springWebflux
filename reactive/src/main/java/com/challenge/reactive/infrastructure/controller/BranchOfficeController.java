package com.challenge.reactive.infrastructure.controller;

import com.challenge.reactive.application.handler.BranchOfficeHandler;
import com.challenge.reactive.infrastructure.classes.GenericResponse;
import com.challenge.reactive.infrastructure.controller.dto.BranchOfficeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/branchoffice")
public class BranchOfficeController {
    @Autowired
    private BranchOfficeHandler handler;

    @PostMapping("/create")
    public Mono<BranchOfficeDto> createNewProduct(@RequestBody BranchOfficeDto request) {
        return handler.createNewBranchOffice(request);
    }

    @DeleteMapping("/delete/{id}")
    public Mono<GenericResponse> deleteBranchOffice(@PathVariable Long id) {
        return handler.deleteBranchOffice(id);
    }

    @PutMapping("/update/{id}")
    public Mono<BranchOfficeDto> updateBranchOffice(@RequestBody BranchOfficeDto request) {
        return handler.updateBranchOffice(request);
    }

    @GetMapping("/getAll")
    public Flux<BranchOfficeDto> getAllBranchOffices() {
        return handler.getAllBranchOffices();
    }

    @GetMapping("/getById/{id}")
    public Mono<BranchOfficeDto> getBranchOfficeById(@PathVariable Long id) {
        return handler.getBranchOfficeById(id);
    }
}
