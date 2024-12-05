package com.ems.service.Imple;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import com.ems.dto.ContactDto;
import com.ems.entity.ContactUs;
import com.ems.exception.ResourceNotFoundException;
import com.ems.mapper.ContactMapper;
import com.ems.repository.ContactUsRepository;
import com.ems.service.ContactService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ContactServiceImple implements ContactService {
	private static final Logger logger = LoggerFactory.getLogger(ContactServiceImple.class);
	
	@Autowired
	private ContactUsRepository contactUsRepository;
	
    // Add Contact
	@Override
	public ContactDto addContact(ContactDto contactDto) {
		logger.info("Creating Contact: {}", contactDto);
        ContactUs contactus = ContactMapper.convertToEntity(contactDto);
        ContactUs savedContact = contactUsRepository.save(contactus);
		return ContactMapper.convertToDTO(savedContact);
	}

	// Get Contact By Id
	@Override
	public ContactDto getContactById(Long id) {
		logger.info("Fetching Contact with ID: {}", id);
       ContactUs contact = contactUsRepository.findById(id)
    		   .orElseThrow(() -> new ResourceNotFoundException("contact is not exists with given id" + id));
		return ContactMapper.convertToDTO(contact);
	}

	/*
	 * @Override
	 *  public List<ContactDto> getAllContact() { 
	 *      List<ContactUs> allContact = contactUsRepository.findAll();
	 *      return allContact.stream().map(ContactMapper::convertToDTO).collect(Collectors.toList());
	 * 
	 *  }
	 */
	
	// Get All Contact
	@Override 
	  public List<ContactDto> getAllContact(int page, int size) { 
		logger.info("Fetching all Contact");
           Page<ContactUs> pageContact = contactUsRepository.findAll(PageRequest.of(page, size));
           List<ContactUs> allContact = pageContact.getContent();
	        return allContact.stream().map(ContactMapper::convertToDTO).collect(Collectors.toList()); 
	  }
	 
	 
	// Delete Contact 
	@Override
	public void deleteContact(Long id) {
		logger.info("Deleting Contact with ID: {}", id);
		 ContactUs contact = contactUsRepository.findById(id)
	                .orElseThrow(() -> new ResourceNotFoundException("Employee is not exists with given id" + id));
	        contactUsRepository.deleteById(id);
		
	}

	
	// Search Contact By query
	@Override
	public List<ContactDto> SearchContact(String query) {
		logger.info("Search Contact with ID: {}", query);
	   List<ContactUs> contact = contactUsRepository.SearchContact(query);
		return contact.stream().map((x) -> ContactMapper.convertToDTO(x)).collect(Collectors.toList());
	}

	
	// Update Contact By Id
	@Override
	public ContactDto updateContact(Long id, ContactDto contactDto) {
		logger.info("Updating Contact with ID: {}", id);
		 ContactUs contact = contactUsRepository.findById(id)
	    		   .orElseThrow(() -> new ResourceNotFoundException("contact is not exists with given id" + id));
		 contact.setName(contactDto.getName());
		 contact.setEmail(contactDto.getEmail());
		 contact.setMessage(contactDto.getMessage());
		 contact.setImage(contactDto.getImage());
		 contact.setResume(contactDto.getResume());
		 
		// save employee in the repository
	         ContactUs updatedContact = contactUsRepository.save(contact);
	         return ContactMapper.convertToDTO(updatedContact);
	}

}
