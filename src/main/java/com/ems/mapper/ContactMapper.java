package com.ems.mapper;

import com.ems.dto.ContactDto;
import com.ems.entity.ContactUs;

public class ContactMapper {
	
	// Convert Contact entity to ContactDTO
	public static ContactDto convertToDTO(ContactUs contactus) {
        if (contactus == null) {
            return null;
        }
        return new ContactDto(
            contactus.getId(),
            contactus.getName(),
            contactus.getEmail(),
            contactus.getMessage(),
            contactus.getImage(),
            contactus.getResume()
        );
    }
	
	// Convert ContactDTO to ContactUs entity
    public static ContactUs convertToEntity(ContactDto contactDto) {
        if (contactDto == null) {
            return null;
        }
        return new ContactUs(
           contactDto.getId(),
           contactDto.getName(),
           contactDto.getEmail(),
           contactDto.getMessage(),
           contactDto.getImage(),
           contactDto.getResume()
        );
    }


}
