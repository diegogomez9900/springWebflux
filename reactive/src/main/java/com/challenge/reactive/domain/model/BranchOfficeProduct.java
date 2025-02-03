package com.challenge.reactive.domain.model;

public class BranchOfficeProduct {
    private Long id;
    private Long branchOfficeId;
    private String productId;
    private Long stock;

    public BranchOfficeProduct() {
    }

    public BranchOfficeProduct(Long id, Long branchOfficeId, String productId, Long stock) {
        this.id = id;
        this.branchOfficeId = branchOfficeId;
        this.productId = productId;
        this.stock = stock;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBranchOfficeId() {
        return branchOfficeId;
    }

    public void setBranchOfficeId(Long branchOfficeId) {
        this.branchOfficeId = branchOfficeId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public Long getStock() {
        return stock;
    }

    public void setStock(Long stock) {
        this.stock = stock;
    }
}
