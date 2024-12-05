package com.ems.entity;

import java.util.Arrays;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Table (name = "contact")
@Entity
public class ContactUs {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "message")
	private String message;
	
    @Lob
    private byte[] image;

    @Lob
    private byte[] resume;
    

	public ContactUs() {
		super();
		// TODO Auto-generated constructor stub
	}


	public ContactUs(Long id, String name, String email, String message, byte[] image, byte[] resume) {
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
		return "ContactUs [id=" + id + ", name=" + name + ", email=" + email + ", message=" + message + ", image="
				+ Arrays.toString(image) + ", resume=" + Arrays.toString(resume) + "]";
	}

	
	
	
	

}
