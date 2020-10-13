package com.example.employee.internal.repository;

import java.util.UUID;


public class Employee {

    public static final String FIND_ALL = "select id, name, retired from employee";
    public static final String FIND_BY_ID = "select id, name, retired from employee where id = '%s'";

    private UUID id;
    private String name;
    private Boolean retired;

    public Employee(UUID id, String name, Boolean retired) {
        this.id = id;
        this.name = name;
        this.retired = retired;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Boolean getRetired() {
        return retired;
    }

}
