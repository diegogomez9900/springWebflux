package com.challenge.reactive.infrastructure.controller;

import com.challenge.reactive.application.handler.FranchiseBranchOfficeHandler;
import com.challenge.reactive.domain.model.BranchProduct;
import com.challenge.reactive.infrastructure.classes.GenericResponse;
import com.challenge.reactive.infrastructure.controller.dto.BranchOfficeProductDto;
import com.challenge.reactive.infrastructure.controller.dto.BranchProductDto;
import com.challenge.reactive.infrastructure.controller.dto.FranchiseBranchOfficeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/franchiseBranchOffice")
public class FranchiseBranchOfficeController {
    @Autowired
    private FranchiseBranchOfficeHandler handler;

    @PostMapping("/addBranch")
    public Mono<FranchiseBranchOfficeDto> addBranchToFranchise(@RequestBody FranchiseBranchOfficeDto request) {
        return handler.addBranchToFranchise(request);
    }

    @DeleteMapping("/deleteBranch/{id}")
    public Mono<GenericResponse> deleteBranchFromFranchise(@PathVariable Long id) {
        return handler.deleteBranchFromFranchise(id);
    }

    @PutMapping("/updateBranch")
    public Mono<FranchiseBranchOfficeDto> updateBranchFromFranchise(@RequestBody FranchiseBranchOfficeDto request) {
        return handler.updateBranchFromFranchise(request);
    }

    @GetMapping("/getAll/{id}")
    public Flux<FranchiseBranchOfficeDto> getAllBranchesFromFranchise(@PathVariable Long id) {
        return handler.getAllBranchesFromFranchise(id);
    }

    @GetMapping("/getAllTopStock/{id}")
    public Flux<BranchProductDto> getAllBranchesWithTopStockProductFromFranchise(@PathVariable Long id) {
        return handler.getAllBranchesWithTopStockProductFromFranchise(id);
    }

}
