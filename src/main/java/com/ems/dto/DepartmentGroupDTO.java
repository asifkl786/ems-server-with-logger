package com.ems.dto;

import com.ems.entity.Employee;

import lombok.Data;

import java.util.List;

@Data
public class DepartmentGroupDTO {
    private String department;
    private int totalCount;
    private List<Employee> employees;

    public DepartmentGroupDTO(String department, List<Employee> employees) {
        this.department = department;
        this.employees = employees;
        this.totalCount = employees.size();
    }

}
