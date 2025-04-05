package com.ems.mapper;

import com.ems.dto.EmployeeDto;
import com.ems.entity.Employee;

public class EmployeeMapper {

	 // Convert to Entity	 
	 public static Employee toEntity(EmployeeDto employeeDto) {
		 Employee employee = new Employee();
		 employee.setId(employeeDto.getId());
		 employee.setFirstName(employeeDto.getFirstName());
		 employee.setMiddleName(employeeDto.getMiddleName());
		 employee.setLastName(employeeDto.getLastName());
		 employee.setEmail(employeeDto.getEmail());
		 employee.setMobileNumber(employeeDto.getMobileNumber());
		 employee.setDateofbirth(employeeDto.getDateofbirth());
		 employee.setCountry(employeeDto.getCountry());
		 employee.setGender(employeeDto.getGender());
		 employee.setPicture(employeeDto.getPicture());
		 return employee; 
	 }
	 
	 // Convert to Dto
	 public static EmployeeDto toDto(Employee employee) {
		 EmployeeDto employeeDto = new EmployeeDto();
		 employeeDto.setId(employee.getId());
		 employeeDto.setFirstName(employee.getFirstName());
		 employeeDto.setMiddleName(employee.getMiddleName());
		 employeeDto.setLastName(employee.getLastName());
		 employeeDto.setEmail(employee.getEmail());
		 employeeDto.setMobileNumber(employee.getMobileNumber());
		 employeeDto.setDateofbirth(employee.getDateofbirth());
		 employeeDto.setCountry(employee.getCountry());
		 employeeDto.setGender(employee.getGender());
		 employeeDto.setPicture(employee.getPicture());
		 return employeeDto;
	 }
}
