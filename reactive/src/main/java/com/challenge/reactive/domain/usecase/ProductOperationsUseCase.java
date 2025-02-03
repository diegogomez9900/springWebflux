package com.challenge.reactive.domain.usecase;

import com.challenge.reactive.application.port.products.ProductOperationsPort;
import com.challenge.reactive.domain.model.Product;
import com.challenge.reactive.domain.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class ProductOperationsUseCase implements ProductOperationsPort {

    @Autowired
    private ProductRepository productRepository;
    @Override
    public Mono<Product> createNewProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Mono<Product> deleteProduct(String id) {
        return productRepository.delete(id);
    }

    @Override
    public Mono<Product> updateProduct(Product product) {
        return productRepository.update(product);
    }

    @Override
    public Flux<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Mono<Product> getProductById(String id) {
        return productRepository.findById(id);
    }
}
