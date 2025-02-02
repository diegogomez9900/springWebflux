package com.challenge.reactive.infrastructure.implementation.entity.mysqlentities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table("BRANCH_OFFICE_PRODUCT")
public class BranchOfficeProductEntity {
    @Id
    private Long id;
    private Long branchOfficeId;
    private Long productId;
    private String stock;
}
