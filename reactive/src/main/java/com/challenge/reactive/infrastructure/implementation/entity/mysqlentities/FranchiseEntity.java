package com.challenge.reactive.infrastructure.implementation.entity.mysqlentities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table("FRANCHISE")
public class FranchiseEntity {
    @Id
    private Long id;
    private String name;
    private String description;
}
