package com.challenge.reactive.domain.model;

public class BranchOfficeProduct {
    private Long id;
    private Long branchOfficeId;
    private Long productId;
    private String stock;

    public BranchOfficeProduct() {
    }

    public BranchOfficeProduct(Long id, Long branchOfficeId, Long productId, String stock) {
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

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }
}
