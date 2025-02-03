package com.challenge.reactive.application.port.products;

import com.challenge.reactive.domain.model.Product;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductOperationsPort {
    Mono<Product> createNewProduct(Product product);
    Mono<Product> deleteProduct(String id);
    Mono<Product> updateProduct(Product product);
    Flux<Product> getAllProducts();
    Mono<Product> getProductById(String id);
}
