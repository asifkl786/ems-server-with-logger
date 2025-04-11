package com.ems.controller;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ems.dto.ContactDto;
import com.ems.service.ContactService;


import lombok.AllArgsConstructor;

//@CrossOrigin("*")
@CrossOrigin(origins = "https://ems-curd.netlify.app")
@AllArgsConstructor
@RestController
@RequestMapping("/api/contact")
public class ContactController {
	
	private static final Logger logger = LoggerFactory.getLogger(ContactController.class);
	
	@Autowired
	private ContactService contactService;
	

    // Build addContact REST API
	   /*  @PostMapping
	    public ResponseEntity<ContactDto> addContact(@RequestBody ContactDto contactDto) {
	    logger.info("Received request to create Contact: {}", contactDto);
	    	ContactDto savedContact = contactService.addContact(contactDto);
	        return new ResponseEntity<>(savedContact, HttpStatus.CREATED);
	    }
	    */
	
	// Build add Contact REST API
	  @PostMapping
	  public ResponseEntity<ContactDto> addContact(
			 
			  @RequestParam("name") String name,
			  @RequestParam("email") String email,
			  @RequestParam("message") String message,
			  @RequestParam(value = "image", required = false) MultipartFile image,
			  @RequestParam(value = "resume",required = false) MultipartFile resume) throws IOException {
		  logger.info("Received request to create Contact: {}", name,email);
		  
		  ContactDto contactDto = new ContactDto();
		    contactDto.setName(name);
		    contactDto.setEmail(email);
		    contactDto.setMessage(message);
		    
		    if(image != null) {
		    	contactDto.setImage(image.getBytes());
		    }
		    
		    if(resume != null) {
		    	contactDto.setResume(resume.getBytes());
		    }
		    
		  ContactDto addContact = contactService.addContact(contactDto);
		  return new ResponseEntity<>(addContact,HttpStatus.CREATED);
	  }
	  
	
    // Build Get Contact By Id REST API
    @GetMapping("{id}")
    public ResponseEntity<ContactDto> getContactById(@PathVariable Long id){
    	logger.info("Received request to fetch Contact with ID: {}", id);
     ContactDto getedContact = contactService.getContactById(id);
    	return new ResponseEntity<>(getedContact, HttpStatus.OK);
    }
    
    // Build Get All Contact REST API
	
	  @GetMapping
      public ResponseEntity<List<ContactDto>> getAllContact(
    		  @RequestParam(defaultValue = "0") int page,
              @RequestParam(defaultValue = "5") int size){
		  logger.info("Received request to fetch all Contact with page and size : {}", page,size);
	  List<ContactDto> allContact = contactService.getAllContact(page, size);
	  return new ResponseEntity<>(allContact, HttpStatus.OK); }

    
    // Build update contact REST API
    @PutMapping("{id}")
    public ResponseEntity <ContactDto> updateEmployee(@PathVariable Long id, @RequestBody ContactDto contactDto){
    	logger.info("Received request to update Contact with ID: {}", id);
     ContactDto updatedContact = contactService.updateContact(id, contactDto);
    	return new ResponseEntity<>(updatedContact,HttpStatus.OK);
    }
    
    // Build Delete Contact REST API
    @DeleteMapping("{id}")
	public ResponseEntity<String> deleteContact(@PathVariable Long id){
    	logger.info("Received request to delete Contact with ID: {}", id);
		contactService.deleteContact(id);
		 return new ResponseEntity<>("Contact deleted Successfully", HttpStatus.OK);
	}
    
    // Build Search Contact REST API
    @GetMapping("/search")
    public ResponseEntity<List<ContactDto>> getContactByQuery(@RequestParam("query") String query) {
    	logger.info("Received request to search Contact with query: {}", query);
        List<ContactDto> searchContactDtoList = contactService.SearchContact(query);
        return ResponseEntity.ok(searchContactDtoList);
    }

}
