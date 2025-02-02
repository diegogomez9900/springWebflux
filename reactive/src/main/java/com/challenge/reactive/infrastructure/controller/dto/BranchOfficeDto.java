package com.challenge.reactive.infrastructure.controller.dto;

public class BranchOfficeDto {
    private Long id;
    private String name;
    private String description;
    private String address;
    private String email;

    public BranchOfficeDto() {
    }

    public BranchOfficeDto(Long id, String name, String description, String address, String email) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.address = address;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
