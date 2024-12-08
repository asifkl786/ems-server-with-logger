package com.ems.service.Imple;



import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ems.dto.EmployeeDto;

import com.ems.entity.Employee;
import com.ems.exception.ResourceNotFoundException;
import com.ems.mapper.EmployeeMapper;
import com.ems.repository.EmployeeRepository;
import com.ems.service.EmployeeService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeServiceImple implements EmployeeService  {
	private static final Logger logger = LoggerFactory.getLogger(EmployeeServiceImple.class);
	
	@Autowired
	private EmployeeRepository employeeRepository;
    
	// Add Employee 
	@Override
	public EmployeeDto addEmployee(EmployeeDto employeeDto) {
		logger.info("Creating Employee: {}", employeeDto);
		Employee employee = EmployeeMapper.toEntity(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.toDto(savedEmployee);
	}
    
	// Get Employee By Id
	@Override
	public EmployeeDto getEmployeeById(Long id) {
		logger.info("Fetching Employee with ID: {}", id);
		 Employee employee = employeeRepository.findById(id)
	                .orElseThrow(() -> new ResourceNotFoundException("Employee is not exists with given id" + id));
	        return EmployeeMapper.mapToEmployeeDto(employee);
	}
    
	
	// Get All Employee 
	@Override
	public List<EmployeeDto> getAllEmployees() {
		 logger.info("Fetching all Employee");
		 List<Employee> employees = employeeRepository.findAll();
	        return employees.stream().map(EmployeeMapper::mapToEmployeeDto)
	                .collect(Collectors.toUnmodifiableList());
	}
    
	
	// Update Employee By Id
	@Override
	public EmployeeDto updateEmployee(Long id, EmployeeDto employeeDto) {
		logger.info("Updating Employee with ID: {}", id);
		// get employee from the repository
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee is not exists with given id" + id));
        // update employee
        employee.setFirstName(employeeDto.getFirstName());
        employee.setLastName(employeeDto.getLastName());
        employee.setEmail(employeeDto.getEmail());
        employee.setMobileNumber(employeeDto.getMobileNumber());
        employee.setCountry(employeeDto.getCountry());
        employee.setGender(employeeDto.getGender());
        employee.setDateofbirth(employeeDto.getDateofbirth());
        employee.setPicture(employeeDto.getPicture());
        // save employee in the repository
        Employee updatedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(updatedEmployee);
	}
    
	// Delete Employee By Id 
	@Override
	public void deleteEmployee(Long id) {
		logger.info("Deleting Employee with ID: {}", id);
		 Employee employee = employeeRepository.findById(id)
	                .orElseThrow(() -> new ResourceNotFoundException("Employee is not exists with given id" + id));
	        employeeRepository.deleteById(id);
		
	}

	// Search Employee By Id
	@Override
	public List<EmployeeDto> SearchEmployee(String query) {
		logger.info("Search Employee with ID: {}", query);
		 List<Employee> employees = employeeRepository.SearchEmployee(query);

	        return employees.stream().map((emp) -> EmployeeMapper.mapToEmployeeDto(emp))
	                .collect(Collectors.toUnmodifiableList());
	}
	
	
}
