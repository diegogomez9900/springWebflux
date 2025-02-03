package com.challenge.reactive.application.handler;

import com.challenge.reactive.application.mapper.ProductMapper;
import com.challenge.reactive.application.port.products.ProductOperationsPort;
import com.challenge.reactive.infrastructure.controller.dto.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class ProductHandler {
    @Autowired
    private ProductOperationsPort productOperationsPort;
    @Autowired
    private ProductMapper productMapper;

    public Mono<ProductDto> createNewProduct(ProductDto productDto) {
        return productOperationsPort.createNewProduct(productMapper.dtoToDomain(productDto))
                .map(product -> productMapper.domainToDto(product));
    }

    public Mono<ProductDto> deleteProduct(String id) {
        return productOperationsPort.deleteProduct(id)
                .map(product -> productMapper.domainToDto(product));
    }

    public Mono<ProductDto> updateProduct(ProductDto productDto) {
        return productOperationsPort.updateProduct(productMapper.dtoToDomain(productDto))
                .map(product -> productMapper.domainToDto(product));
    }

    public Flux<ProductDto> getAllProducts() {
        return productOperationsPort.getAllProducts()
                .map(product -> productMapper.domainToDto(product));
    }

    public Mono<ProductDto> getProductById(String id) {
        return productOperationsPort.getProductById(id)
                .map(product -> productMapper.domainToDto(product));
    }
}
