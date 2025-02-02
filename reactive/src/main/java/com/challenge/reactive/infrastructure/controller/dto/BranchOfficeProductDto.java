package com.challenge.reactive.infrastructure.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BranchOfficeProductDto {
    private Long id;
    private Long branchOfficeId;
    private Long productId;
    private String stock;
}
