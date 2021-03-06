package com.example.employee.external.model;

import java.util.UUID;

public class EmployeeData {

    private UUID id;
    private String name;
    private Boolean retired;

    public EmployeeData() {
    }

    public EmployeeData(UUID id, String name, Boolean retired) {
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
