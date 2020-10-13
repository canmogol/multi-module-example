package com.example.demo.rest;

import java.util.UUID;

public class EmployeeDTO {

    private UUID id;
    private String name;
    private Boolean retired;

    public EmployeeDTO() {
    }

    public EmployeeDTO(UUID id, String name, Boolean retired) {
        this.id = id;
        this.name = name;
        this.retired = retired;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getRetired() {
        return retired;
    }

    public void setRetired(Boolean retired) {
        this.retired = retired;
    }
}
