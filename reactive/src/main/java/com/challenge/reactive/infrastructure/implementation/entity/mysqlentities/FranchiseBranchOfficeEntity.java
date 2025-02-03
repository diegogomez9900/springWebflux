package com.challenge.reactive.infrastructure.implementation.entity.mysqlentities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table("FRANCHISE_BRANCH_OFFICE")
public class FranchiseBranchOfficeEntity {
    @Id
    private Long id;
    private Long franchiseId;
    private Long branchOfficeId;
}
