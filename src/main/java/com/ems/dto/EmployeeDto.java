package com.ems.dto;

import lombok.Data;

@Data
public class EmployeeDto {
	
	
	    private Long id;
	    private String firstName;
	    private String middleName;
	    private String lastName;
	    private String email;
	    private String mobileNumber;
	    private String dateofbirth;
	    private String gender;
	    private String country;
	    private String picture;  // This will store the file name
	   // private MultipartFile file; // or call it picture, but make sure names match!

}
