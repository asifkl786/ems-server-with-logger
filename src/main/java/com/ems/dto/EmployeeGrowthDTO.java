package com.ems.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EmployeeGrowthDTO {
    private String month;
    private Long employees;
}
