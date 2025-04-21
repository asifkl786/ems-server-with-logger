package com.ems.service;

import java.io.IOException;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

import com.ems.dto.EmployeeDto;

public interface EmployeeService {
	
	 EmployeeDto createEmployee(EmployeeDto employeeDto,MultipartFile file) throws IOException;
	 EmployeeDto getEmployeeById(Long id);
	// List<EmployeeDto> getAllEmployees();
	 Page<EmployeeDto> getAllEmployeesWithPagination(int page, int size);
	 EmployeeDto updateEmployee(Long id, EmployeeDto employeeDto, MultipartFile file); 
	 void deleteEmployee(Long id);
	 List<EmployeeDto> SearchEmployee(String query);

}
