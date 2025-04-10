package com.ems.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.ems.dto.EmployeeDto;

public interface EmployeeService {
	
	 EmployeeDto addEmployee(EmployeeDto employeeDto);
	 EmployeeDto getEmployeeById(Long id);
	 List<EmployeeDto> getAllEmployees();
	 //EmployeeDto updateEmployee(Long id , EmployeeDto employeeDto);
	 EmployeeDto updateEmployee(Long id, EmployeeDto employeeDto, MultipartFile file);
	 EmployeeDto createEmployee(EmployeeDto employeeDto,MultipartFile file) throws IOException;
	 void deleteEmployee(Long id);
	 List<EmployeeDto> SearchEmployee(String query);

}
