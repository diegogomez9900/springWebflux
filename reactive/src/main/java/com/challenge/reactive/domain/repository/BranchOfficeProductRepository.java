package com.challenge.reactive.domain.repository;

import com.challenge.reactive.domain.model.BranchOfficeProduct;
import com.challenge.reactive.domain.model.Product;

public interface BranchOfficeProductRepository {
    Iterable<Long> getAllProductsByBranchOfficeId(Long id);//traer todos los productos de una sucursal
    Long getProductWithMoreStockByBranchOfficeId(Long id);//traer el producto con mas stock de una sucursal
    BranchOfficeProduct save(BranchOfficeProduct branchOfficeProduct);//agregar un producto a una sucursal
    void delete(Long id);//eliminar un producto de una sucursal
    BranchOfficeProduct update(BranchOfficeProduct branchOfficeProduct);//actualizar un producto de una sucursal, puede servir para modificar stock
}
