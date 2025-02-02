package com.challenge.reactive.infrastructure.configuration;

import com.challenge.reactive.application.mapper.ProductMapper;
import com.challenge.reactive.infrastructure.implementation.entity.ProductEntity;
import com.challenge.reactive.infrastructure.implementation.repository.ProductRepositoryWithDynamoDB;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbAsyncTable;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedAsyncClient;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbAsyncClient;

@Configuration
public class DynamoDBConfig {

    @Value("${aws.accessKeyId}")
    private String accessKeyId;

    @Value("${aws.secretAccessKey}")
    private String secretAccessKey;

    @Value("${aws.region}")
    private String region;

    @Bean
    public DynamoDbAsyncClient getDynamoDbAsyncClient() {
        return DynamoDbAsyncClient.builder()
                .region(Region.of(region))
                .credentialsProvider(StaticCredentialsProvider.create(
                        AwsBasicCredentials.create(accessKeyId, secretAccessKey)
                ))
                .build();
    }

    @Bean
    public DynamoDbEnhancedAsyncClient getDynamoDbEnhancedAsyncClient(DynamoDbAsyncClient dynamoDbAsyncClient) {
        return DynamoDbEnhancedAsyncClient.builder()
                .dynamoDbClient(dynamoDbAsyncClient)
                .build();
    }

    @Bean
    public DynamoDbAsyncTable<ProductEntity> productsTable(DynamoDbEnhancedAsyncClient enhancedAsyncClient) {
        return enhancedAsyncClient.table("products", TableSchema.fromBean(ProductEntity.class));
    }

    @Bean
    public ProductRepositoryWithDynamoDB productRepository(DynamoDbAsyncTable<ProductEntity> productTable, ProductMapper mapper) {
        return new ProductRepositoryWithDynamoDB(productTable, mapper);
    }
}
