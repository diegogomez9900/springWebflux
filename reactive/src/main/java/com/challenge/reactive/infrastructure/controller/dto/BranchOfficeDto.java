package com.challenge.reactive.infrastructure.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BranchOfficeDto {
    private Long id;
    private String name;
    private String description;
    private String address;
    private String email;
}
