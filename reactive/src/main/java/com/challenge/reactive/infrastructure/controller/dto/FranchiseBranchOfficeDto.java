package com.challenge.reactive.infrastructure.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FranchiseBranchOfficeDto {
    private Long id;
    private Long franchiseId;
    private Long branchOfficeId;
}
