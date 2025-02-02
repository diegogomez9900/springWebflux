package com.challenge.reactive.infrastructure.implementation.repository;

import com.challenge.reactive.application.mapper.ProductMapper;
import com.challenge.reactive.domain.model.Product;
import com.challenge.reactive.domain.repository.ProductRepository;
import com.challenge.reactive.infrastructure.implementation.entity.ProductEntity;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbAsyncTable;

@Repository
public class ProductRepositoryWithDynamoDB implements ProductRepository {
    private final DynamoDbAsyncTable<ProductEntity> productTable;
    private ProductMapper mapper;

    public ProductRepositoryWithDynamoDB(DynamoDbAsyncTable<ProductEntity> productTable, ProductMapper mapper) {
        this.productTable = productTable;
        this.mapper = mapper;
    }

    public Mono<Product> findById(String id) {
        return Mono.fromFuture(() -> productTable.getItem(r -> r.key(k -> k.partitionValue(id))))
                .map(mapper::entityToDomain);
    }

    public Flux<Product> findAll() {
        return Flux.from(productTable.scan().items())
                .map(mapper::entityToDomain);
    }

    @Override
    public Mono<Product> save(Product product) {
        return Mono.fromFuture(() -> productTable.putItem(mapper.domainToEntity(product)))
                .thenReturn(product);
    }

    @Override
    public Mono<Product> delete(String id) {
        return Mono.fromFuture(() -> productTable.deleteItem(r -> r.key(k -> k.partitionValue(id))))
                .map(mapper::entityToDomain);
    }

    @Override
    public Mono<Product> update(Product product) {
        return Mono.fromFuture(() -> productTable.updateItem(mapper.domainToEntity(product)))
                .map(mapper::entityToDomain);
    }
}
