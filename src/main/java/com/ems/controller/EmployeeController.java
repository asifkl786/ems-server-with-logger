package com.ems.controller;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ems.dto.EmployeeDto;
import com.ems.service.EmployeeService;


import lombok.AllArgsConstructor;

//@CrossOrigin("*")
@CrossOrigin(origins = "https://ems-curd.netlify.app")
@AllArgsConstructor
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
	
	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	
	public static String uploadDirectory = System.getProperty("user.dir") + "/src/main/resources/static";
	
	@Autowired
	private EmployeeService employeeService;

    // Build addEmployee REST API
	/*
    @PostMapping
    public ResponseEntity<EmployeeDto> addEmployee(@RequestBody EmployeeDto employeeDto) {
    	logger.info("Received request to create Employee Whose Name : {}", employeeDto.getFirstName());
        EmployeeDto savedEmployee = employeeService.addEmployee(employeeDto);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    } */
	
	 // Build addEmployee REST API
    @PostMapping
    public ResponseEntity<EmployeeDto> addEmployee(
    		@ModelAttribute("employeeDto") EmployeeDto employeeDto, @RequestParam("file") MultipartFile file) throws IOException {
    	// Log file name
    	logger.info("Received request to create Employee Whose Name : {}", employeeDto.getFirstName());
    	
    	// Save the uploaded file
    	String orignalFileName = file.getOriginalFilename();
		Path fileNameAndPath = Paths.get(uploadDirectory,orignalFileName);
		Files.write(fileNameAndPath, file.getBytes());
		
		// Set picture field in EmployeeDto
		employeeDto.setPicture(orignalFileName);
		
		// Call employeeService 
        EmployeeDto savedEmployee = employeeService.addEmployee(employeeDto);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }
    
    // Build Get Employee By Id REST API
    @GetMapping("{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") Long id) {
    	logger.info("Received request to fetch Employee with ID: {}", id);
        EmployeeDto employeeDto = employeeService.getEmployeeById(id);
        return ResponseEntity.ok(employeeDto);
    }
    
   // Build GetAll All employee
    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployees() {
    	logger.info("Received request to fetch all Employee");
        List<EmployeeDto> employeeDtoList = employeeService.getAllEmployees();
        return ResponseEntity.ok(employeeDtoList);
    }
    
   // Build Update employee
    @PutMapping(value = "/{id}", consumes = "multipart/form-data")
    public ResponseEntity<EmployeeDto> updateEmployee(
    		@PathVariable("id") Long id,
            @ModelAttribute EmployeeDto employeeDto,
            @RequestParam(value = "file", required = false) MultipartFile file) {
    	
    	logger.info("Received request to update Employee with ID: {}", id);
        EmployeeDto updatedEmployee = employeeService.updateEmployee(id, employeeDto,file);
        return ResponseEntity.ok(updatedEmployee);
    }
    
    // Build Create employee REST API
    @PostMapping(value = "/create", consumes = "multipart/form-data")
    public ResponseEntity<EmployeeDto> createEmployee(
            @ModelAttribute EmployeeDto employeeDto,
            @RequestParam(value = "file", required = false) MultipartFile file) throws IOException {
    	logger.info("Received request to create Employee with Name:: {}", employeeDto.getFirstName());
        EmployeeDto createdEmployee = employeeService.createEmployee(employeeDto, file);
        return new ResponseEntity<>(createdEmployee,HttpStatus.CREATED);
    }
    
    // Build Delete Employee REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long id) {
    	logger.info("Received request to delete Employee with ID: {}", id);
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>("Employee deleted Successfully", HttpStatus.OK);
    }
    
    // Build Search Employee REST API
    @GetMapping("/search")
    public ResponseEntity<List<EmployeeDto>> getEmployeeByQuery(@RequestParam("query") String query) {
    	logger.info("Received request to search Employee with query: {}", query);
        List<EmployeeDto> searchEmployeeDtoList = employeeService.SearchEmployee(query);
        return ResponseEntity.ok(searchEmployeeDtoList);
    }
    
    
}
