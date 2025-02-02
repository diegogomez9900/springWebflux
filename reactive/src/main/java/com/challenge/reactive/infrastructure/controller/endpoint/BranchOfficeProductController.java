package com.challenge.reactive.infrastructure.controller.endpoint;

import com.challenge.reactive.application.handler.BranchOfficeHandler;
import com.challenge.reactive.application.handler.BranchOfficeProductHandler;
import com.challenge.reactive.infrastructure.classes.GenericResponse;
import com.challenge.reactive.infrastructure.controller.dto.BranchOfficeDto;
import com.challenge.reactive.infrastructure.controller.dto.BranchOfficeProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/branchOfficeProduct")
public class BranchOfficeProductController {
    @Autowired
    private BranchOfficeProductHandler handler;

    @PostMapping("/addProduct")
    public Mono<BranchOfficeProductDto> addProductToBranchOffice(@RequestBody BranchOfficeProductDto request) {
        return handler.addProductToBranchOffice(request);
    }

    @DeleteMapping("/deleteProduct/{id}")
    public Mono<GenericResponse> deleteProductFromBranchOffice(@PathVariable Long id) {
        return handler.deleteProductFromBranchOffice(id);
    }

    @PutMapping("/updateProduct")
    public Mono<BranchOfficeProductDto> updateProductFromBranchOffice(@RequestBody BranchOfficeProductDto request) {
        return handler.updateProductFromBranchOffice(request);
    }

    @GetMapping("/getAll/{id}")
    public Flux<BranchOfficeProductDto> getAllProductsFromBranchOffice(@PathVariable Long id) {
        return handler.getAllProductsFromBranchOffice(id);
    }

    @GetMapping("/getTopStockProduct/{id}")
    public Mono<BranchOfficeProductDto> getTopStockProductByBranchOffice(@PathVariable Long id) {
        return handler.getTopStockProductByBranchOffice(id);
    }
}
