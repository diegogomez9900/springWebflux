package com.challenge.reactive.infrastructure.controller;

import com.challenge.reactive.application.handler.ProductHandler;
import com.challenge.reactive.infrastructure.classes.GenericResponse;
import com.challenge.reactive.infrastructure.controller.dto.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductHandler handler;

    @PostMapping("/create")
    public Mono<ProductDto> createNewProduct(@RequestBody ProductDto request) {
        return handler.createNewProduct(request);
    }

    @DeleteMapping("/delete/{id}")
    public Mono<ProductDto> deleteProduct(@PathVariable String id) {
        return handler.deleteProduct(id);
    }

    @PutMapping("/update")
    public Mono<ProductDto> updateProduct(@RequestBody ProductDto request) {
        return handler.updateProduct(request);
    }

    @GetMapping("/getAll")
    public Flux<ProductDto> getAllProducts() {
        return handler.getAllProducts();
    }

    @GetMapping("/getById/{id}")
    public Mono<ProductDto> getProductById(@PathVariable String id) {
        return handler.getProductById(id);
    }
}
