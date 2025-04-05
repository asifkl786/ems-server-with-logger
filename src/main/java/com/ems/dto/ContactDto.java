package com.ems.dto;

import lombok.Data;

@Data
public class ContactDto {
	
	private Long id;
	private String name;
	private String email;
	private String message;
    private byte[] image;
    private byte[] resume;
    
}
