package com.ems.dto;

import java.util.Arrays;

public class ContactDto {
	
	private Long id;
	private String name;
	private String email;
	private String message;
    private byte[] image;
    private byte[] resume;
    
    
	public ContactDto() {
		super();
		// TODO Auto-generated constructor stub
	}


	public ContactDto(Long id, String name, String email, String message, byte[] image, byte[] resume) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.message = message;
		this.image = image;
		this.resume = resume;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public byte[] getImage() {
		return image;
	}


	public void setImage(byte[] image) {
		this.image = image;
	}


	public byte[] getResume() {
		return resume;
	}


	public void setResume(byte[] resume) {
		this.resume = resume;
	}


	@Override
	public String toString() {
		return "ContactDto [id=" + id + ", name=" + name + ", email=" + email + ", message=" + message + ", image="
				+ Arrays.toString(image) + ", resume=" + Arrays.toString(resume) + "]";
	}
	
}
