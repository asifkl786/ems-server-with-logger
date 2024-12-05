package com.ems.mapper;

import com.ems.dto.EmployeeDto;
import com.ems.entity.Employee;

public class EmployeeMapper {
	
	
	 public static EmployeeDto mapToEmployeeDto(Employee employee) {
	        return new EmployeeDto(
	        		employee.getId(),
	        		employee.getFirstName(),
	        		employee.getMiddleName(),
	        		employee.getLastName(),
	        		employee.getEmail(),
	        		employee.getMobileNumber(),
	        		employee.getDateofbirth(),
	        		employee.getGender(),
	        		employee.getCountry(),
	        		employee.getPicture()

	        );
	    }
	 
	 
	 public static Employee mapToEmployee(EmployeeDto employeeDto) {
	        return new Employee(
	        		
	                employeeDto.getId(),
	                employeeDto.getFirstName(),
	                employeeDto.getMiddleName(),
	                employeeDto.getLastName(),
	                employeeDto.getEmail(),
	                employeeDto.getMobileNumber(),
	                employeeDto.getDateofbirth(),
	                employeeDto.getCountry(),
	                employeeDto.getGender(),
	                employeeDto.getPicture()
	        );
	    }

}
