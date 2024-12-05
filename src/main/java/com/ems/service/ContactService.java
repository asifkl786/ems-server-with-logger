package com.ems.service;

import java.util.List;

import com.ems.dto.ContactDto;

public interface ContactService {
	
	ContactDto addContact(ContactDto contactDto);
	ContactDto getContactById(Long id);
	List<ContactDto> getAllContact(int page, int size);
	ContactDto updateContact(Long id , ContactDto contactDto);
	void deleteContact(Long id);
	List<ContactDto> SearchContact(String query);

}
