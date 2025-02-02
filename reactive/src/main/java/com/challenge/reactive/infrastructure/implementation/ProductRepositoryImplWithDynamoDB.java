package com.challenge.reactive.infrastructure.implementation;

import com.challenge.reactive.application.mapper.ProductMapper;
import com.challenge.reactive.domain.model.Product;
import com.challenge.reactive.domain.repository.ProductRepository;
import com.challenge.reactive.infrastructure.classes.enumclasses.EnumResponses;
import com.challenge.reactive.infrastructure.exception.classes.DeletingException;
import com.challenge.reactive.infrastructure.exception.classes.GettingException;
import com.challenge.reactive.infrastructure.exception.classes.SavingException;
import com.challenge.reactive.infrastructure.exception.classes.UpdatingException;
import com.challenge.reactive.infrastructure.implementation.entity.dynamoentities.ProductEntity;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbAsyncTable;

@Repository
public class ProductRepositoryImplWithDynamoDB implements ProductRepository {
    private final DynamoDbAsyncTable<ProductEntity> productTable;
    private ProductMapper mapper;

    public ProductRepositoryImplWithDynamoDB(DynamoDbAsyncTable<ProductEntity> productTable, ProductMapper mapper) {
        this.productTable = productTable;
        this.mapper = mapper;
    }

    public Mono<Product> findById(String id) {
        return Mono.fromFuture(() -> productTable.getItem(r -> r.key(k -> k.partitionValue(id))))
                .switchIfEmpty(Mono.error(new Exception("Product not found")))
                .map(mapper::entityToDomain)
                .onErrorMap(Exception.class, e -> new GettingException(
                        "Error Getting Product: " + (e.getMessage() == null ? EnumResponses.ERROR_003.getMessage() : e.getMessage()))
                );
    }

    public Flux<Product> findAll() {
        return Flux.from(productTable.scan().items())
                .map(mapper::entityToDomain)
                .onErrorMap(Exception.class, e -> new GettingException(
                        "Error Getting Products: " + (e.getMessage() == null ? EnumResponses.ERROR_003.getMessage() : e.getMessage()))
                );
    }

    @Override
    public Mono<Product> save(Product product) {
        return Mono.fromFuture(() -> productTable.putItem(mapper.domainToEntity(product)))
                .thenReturn(product)
                .onErrorMap(Exception.class, e -> new SavingException(
                        "Error Saving Product: " + (e.getMessage() == null ? EnumResponses.ERROR_004.getMessage() : e.getMessage()))
                );
    }

    @Override
    public Mono<Product> delete(String id) {
        return Mono.fromFuture(() -> productTable.deleteItem(r -> r.key(k -> k.partitionValue(id))))
                .map(mapper::entityToDomain)
                .onErrorMap(Exception.class, e -> new DeletingException(
                        "Error Deleting Product: " + (e.getMessage() == null ? EnumResponses.ERROR_001.getMessage() : e.getMessage()))
                );
    }

    @Override
    public Mono<Product> update(Product product) {
        return Mono.fromFuture(() -> productTable.updateItem(mapper.domainToEntity(product)))
                .map(mapper::entityToDomain)
                .onErrorMap(Exception.class, e -> new UpdatingException(
                        "Error Updating Product: " + (e.getMessage() == null ? EnumResponses.ERROR_002.getMessage() : e.getMessage()))
                );
    }
}
