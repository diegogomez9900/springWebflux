package com.challenge.reactive.application.mapper;

import com.challenge.reactive.domain.model.Product;
import com.challenge.reactive.infrastructure.controller.dto.ProductDto;
import com.challenge.reactive.infrastructure.implementation.entity.dynamoentities.ProductEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductDto domainToDto(Product product);
    Product dtoToDomain(ProductDto productDto);
    ProductEntity domainToEntity(Product product);
    Product entityToDomain(ProductEntity productEntity);
}
