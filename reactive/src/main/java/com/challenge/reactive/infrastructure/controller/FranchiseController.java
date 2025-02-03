package com.challenge.reactive.infrastructure.controller;

import com.challenge.reactive.application.handler.FranchiseHandler;
import com.challenge.reactive.infrastructure.classes.GenericResponse;
import com.challenge.reactive.infrastructure.controller.dto.FranchiseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/franchise")
public class FranchiseController {
    @Autowired
    private FranchiseHandler handler;

    @PostMapping("/create")
    public Mono<FranchiseDto> createFranchise(@RequestBody FranchiseDto franchiseDto) {
        return handler.createNewFranchise(franchiseDto);
    }

    @PutMapping("/update")
    public Mono<FranchiseDto> updateFranchise(@RequestBody FranchiseDto franchiseDto) {
        return handler.updateFranchise(franchiseDto);
    }

    @DeleteMapping("/delete/{id}")
    public Mono<GenericResponse> deleteFranchise(@PathVariable Long id) {
        return handler.deleteFranchise(id);
    }

    @GetMapping("/getAll")
    public Flux<FranchiseDto> getAllFranchises() {
        return handler.getAllFranchises();
    }

    @GetMapping("/getById/{id}")
    public Mono<FranchiseDto> getFranchiseById(@PathVariable Long id) {
        return handler.getFranchiseById(id);
    }
}
