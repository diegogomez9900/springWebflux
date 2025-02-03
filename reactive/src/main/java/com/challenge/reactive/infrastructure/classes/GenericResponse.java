package com.challenge.reactive.infrastructure.classes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GenericResponse {
    private String status;
    private String message;
    private Object data;

    public GenericResponse(String status, String message) {
        this.message = message;
        this.status = status;
    }
}
