package com.ems.service.Imple;



import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ems.dto.EmployeeDto;

import com.ems.entity.Employee;
import com.ems.exception.ResourceNotFoundException;
import com.ems.mapper.EmployeeMapper;
import com.ems.repository.EmployeeRepository;
import com.ems.service.EmployeeService;

import jakarta.annotation.PostConstruct;


@Service
//@AllArgsConstructor
public class EmployeeServiceImple implements EmployeeService  {
	private static final Logger logger = LoggerFactory.getLogger(EmployeeServiceImple.class);
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	//@Value("${upload.directory}")
    //private String uploadDir;
    
	
	@Value("${upload.directory}")
	private String uploadDirProp;

	private Path uploadDir;

	// ye jo method h ye employee update nahi ho raha tha 
	@PostConstruct
	public void initUploadDir() {
	    // Resolve relative path to absolute
	    this.uploadDir = Paths.get(uploadDirProp).toAbsolutePath().normalize();
	    try {
	        Files.createDirectories(this.uploadDir);
	        System.out.println("Resolved Upload Directory: " + this.uploadDir);
	    } catch (IOException e) {
	        throw new RuntimeException("Could not create upload directory", e);
	    }
	}

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
	        return EmployeeMapper.toDto(employee);
	}
    
	
	// Get All Employee 
	@Override
	public List<EmployeeDto> getAllEmployees() {
		 List<Employee> employees = employeeRepository.findAll();
		 logger.info("{}:: Employee Successfully fetch ",employees.size());
	        return employees.stream().map(EmployeeMapper::toDto)
	                .collect(Collectors.toUnmodifiableList());
	}
    
	
	// Update Employee By Id
	@Override
	public EmployeeDto updateEmployee(Long id, EmployeeDto employeeDto, MultipartFile file) {
	    // Fetch employee or throw if not found
	    Employee employee = employeeRepository.findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("Employee does not exist with ID: " + id));

	    // Update base fields
	    employee.setFirstName(employeeDto.getFirstName());
	    employee.setLastName(employeeDto.getLastName());
	    employee.setEmail(employeeDto.getEmail());
	    employee.setMobileNumber(employeeDto.getMobileNumber());
	    employee.setCountry(employeeDto.getCountry());
	    employee.setGender(employeeDto.getGender());
	    employee.setDateofbirth(employeeDto.getDateofbirth());

	    // File upload logic
	    if (file != null && !file.isEmpty()) {
	        // Delete old file if present
	        String oldFileName = employee.getPicture();
	        if (oldFileName != null) {
	            Path oldFilePath = uploadDir.resolve(oldFileName);
	            File oldFile = oldFilePath.toFile();
	            if (oldFile.exists()) oldFile.delete();
	        }

	        // Generate new unique file name
	        String fileName = UUID.randomUUID() + "_" + file.getOriginalFilename();
	        Path filePath = uploadDir.resolve(fileName);

	        try {
	            Files.createDirectories(uploadDir); // ensure directory
	            file.transferTo(filePath.toFile());
	            employee.setPicture(fileName);
	        } catch (IOException e) {
	            e.printStackTrace();
	            throw new RuntimeException("File upload failed", e);
	        }
	    }

	    // Save Employee into Repository
	    Employee updatedEmployee = employeeRepository.save(employee);
	    logger.info("{} :: Employee Successfully Updated", updatedEmployee.getFirstName());
	    return EmployeeMapper.toDto(updatedEmployee);
	}


	// Create Employee 
	/*
		@Override
		public EmployeeDto createEmployee(EmployeeDto employeeDto,MultipartFile file) throws IOException {
			logger.info("{} :: Employee Try to Creating...", employeeDto.getFirstName());
			// Save the uploaded file
	    	String orignalFileName = file.getOriginalFilename();
			Path fileNameAndPath = Paths.get(uploadDir,orignalFileName);
			Files.write(fileNameAndPath, file.getBytes());
			
			// Set picture field in EmployeeDto
			employeeDto.setPicture(orignalFileName);
	        
			
			// This code for Directory created or not 
	        if (file != null && !file.isEmpty()) {
	            String fileName = UUID.randomUUID() + "_" + file.getOriginalFilename();
	        	//String fileName = file.getOriginalFilename();
	            File saveFile = new File(uploadDir + File.separator + fileName);
	            
	            // Ensure upload directory exists
	            File uploadPath = new File(uploadDir);
	            if (!uploadPath.exists()) {
	                uploadPath.mkdirs();
	            }
	            
	            // File transfer code to directory
	                try {
						file.transferTo(saveFile);
					} catch (IllegalStateException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	            
	        }
	        Employee employee = EmployeeMapper.toEntity(employeeDto);
	        // save employee in the repository
	        Employee createdEmployee = employeeRepository.save(employee);
	        logger.info("{}:: Employee Successfully Created",createdEmployee.getFirstName());
	        return EmployeeMapper.toDto(createdEmployee);
		} */
    
	
	// Create Employee chatgpt bala method
	@Override
	public EmployeeDto createEmployee(EmployeeDto employeeDto, MultipartFile file) throws IOException {
	    logger.info("{} :: Employee Try to Creating...", employeeDto.getFirstName());

	    if (file != null && !file.isEmpty()) {
	        // Ensure directory exists
	        Files.createDirectories(uploadDir);

	        // Create unique file name
	        String fileName = UUID.randomUUID() + "_" + file.getOriginalFilename();
	        Path filePath = uploadDir.resolve(fileName);

	        // Save file
	        file.transferTo(filePath.toFile());

	        // Set image name in DTO
	        employeeDto.setPicture(fileName);
	    }

	    Employee employee = EmployeeMapper.toEntity(employeeDto);
	    Employee createdEmployee = employeeRepository.save(employee);
	    logger.info("{} :: Employee Successfully Created", createdEmployee.getFirstName());
	    return EmployeeMapper.toDto(createdEmployee);
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
	        return employees.stream().map((emp) -> EmployeeMapper.toDto(emp))
	                .collect(Collectors.toUnmodifiableList());
	}
	
	
}
