package com.ems.mapper;

import com.ems.dto.ContactDto;
import com.ems.entity.ContactUs;

public class ContactMapper {
    
 // Convert to Entity	 
 	 public static ContactUs convertToEntity(ContactDto contactDto) {
 		ContactUs contact = new ContactUs();
 		contact.setId(contactDto.getId());
 		contact.setName(contactDto.getName());
 		contact.setEmail(contactDto.getEmail());
 		contact.setMessage(contactDto.getMessage());
 		contact.setImage(contactDto.getImage());
 		contact.setResume(contactDto.getResume());
 		 return contact; 
 	 }
 	 
 	 // Convert to Dto
 	 public static ContactDto convertToDTO(ContactUs contactus) {
 		ContactDto contactDto = new ContactDto();
 		contactDto.setId(contactus.getId());
 		contactDto.setName(contactus.getName());
 		contactDto.setEmail(contactus.getEmail());
 		contactDto.setMessage(contactus.getMessage());
 		contactDto.setImage(contactus.getImage());
 		contactDto.setResume(contactus.getResume());
 		 return contactDto;
 	 }

}
