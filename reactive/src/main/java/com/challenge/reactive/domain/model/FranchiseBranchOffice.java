package com.challenge.reactive.domain.model;

public class FranchiseBranchOffice {
    private Long id;
    private Long franchiseId;
    private Long branchOfficeId;

    public FranchiseBranchOffice() {
    }

    public FranchiseBranchOffice(Long id, Long franchiseId, Long branchOfficeId) {
        this.id = id;
        this.franchiseId = franchiseId;
        this.branchOfficeId = branchOfficeId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFranchiseId() {
        return franchiseId;
    }

    public void setFranchiseId(Long franchiseId) {
        this.franchiseId = franchiseId;
    }

    public Long getBranchOfficeId() {
        return branchOfficeId;
    }

    public void setBranchOfficeId(Long branchOfficeId) {
        this.branchOfficeId = branchOfficeId;
    }
}
