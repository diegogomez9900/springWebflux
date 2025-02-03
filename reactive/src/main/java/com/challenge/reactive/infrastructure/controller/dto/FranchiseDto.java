package com.challenge.reactive.infrastructure.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FranchiseDto {
    private Long id;
    private String name;
    private String description;
}
