package com.ems.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EmployeeDepartmentDistributionResponseDto {
	
	private String department;
	private Long noOfEmployee;

}
