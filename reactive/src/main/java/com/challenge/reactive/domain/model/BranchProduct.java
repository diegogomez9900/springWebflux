package com.challenge.reactive.domain.model;

public class BranchProduct {
    private Long branchOfficeId;
    private String productId;
    private Long stock;

    public BranchProduct(Long branchOfficeId, String productId, Long stock) {
        this.branchOfficeId = branchOfficeId;
        this.productId = productId;
        this.stock = stock;
    }

    public BranchProduct() {
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
