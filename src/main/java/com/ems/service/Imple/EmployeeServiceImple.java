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
		Employee employee = EmployeeMapper.toEntity(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);
        logger.info("{} :: Employee Successfully Created", employeeDto.getFirstName());
        return EmployeeMapper.toDto(savedEmployee);
	}
    
	// Get Employee By Id
	@Override
	public EmployeeDto getEmployeeById(Long id) {
		 Employee employee = employeeRepository.findById(id)
	                .orElseThrow(() -> new ResourceNotFoundException("Employee is not exists with given id" + id));
		 logger.info("Employee Successfully Fetch with ID: {}", id);
	        return EmployeeMapper.mapToEmployeeDto(employee);
	}
    
	
	// Get All Employee 
	@Override
	public List<EmployeeDto> getAllEmployees() {
		 List<Employee> employees = employeeRepository.findAll();
		 logger.info("{}:: Employee Successfully fetch ",employees.size());
	        return employees.stream().map(EmployeeMapper::mapToEmployeeDto)
	                .collect(Collectors.toUnmodifiableList());
	}
    
	
	// Update Employee By Id
	@Override
	public EmployeeDto updateEmployee(Long id, EmployeeDto employeeDto) {
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
        logger.info("{}:: Employee Successfully Updated",updatedEmployee.getFirstName());
        return EmployeeMapper.mapToEmployeeDto(updatedEmployee);
	}
    
	// Delete Employee By Id 
	@Override
	public void deleteEmployee(Long id) {
		 Employee employee = employeeRepository.findById(id)
	                .orElseThrow(() -> new ResourceNotFoundException("Employee is not exists with given id" + id));
	        employeeRepository.deleteById(id);
	        logger.info("Employee Successfully delete with ID: {}", id);
	}

	// Search Employee By Id
	@Override
	public List<EmployeeDto> SearchEmployee(String query) {
		 List<Employee> employees = employeeRepository.SearchEmployee(query);
		 logger.info("Successfully Search Employee with ID: {}", query);
	        return employees.stream().map((emp) -> EmployeeMapper.mapToEmployeeDto(emp))
	                .collect(Collectors.toUnmodifiableList());
	}
	
	
}
