package com.evolenthealth.contactdetails.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.evolenthealth.contactdetails.domain.Contact;
import com.evolenthealth.contactdetails.exception.ContactDetailNotFoundException;
import com.evolenthealth.contactdetails.service.ContactDetailService;

@RestController
public class ContactDetailsController {

	@Autowired
	private ContactDetailService contactDetailService;
	
	@RequestMapping(value="/contactdetails", method = RequestMethod.POST  )
	public ResponseEntity<Object> addContactDetails(@Valid @RequestBody Contact contact ) {
		Contact contactData =  contactDetailService.addContactRequest(contact);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(contactData.getContactID()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@RequestMapping(value="/contactdetails/{contactID}", method = RequestMethod.GET)
	public Contact getContactDetails(@PathVariable("contactID") String contactID ) {
		Contact contact = contactDetailService.retrieveContactRequest(contactID);
		if(contact==null) {
			throw new ContactDetailNotFoundException("Contact ID : "+ contactID);
		}
		return contact;
	}
	
	@RequestMapping(value="/contactdetails", method = RequestMethod.GET)
	public List<Contact> getContactDetails() {
		return contactDetailService.retrieveContactList();
	}
	
	@RequestMapping(value="/contactdetails/{contactID}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteContactDetails(@PathVariable("contactID") String contactID ) {
		Contact contact = contactDetailService.updateContactStatusRequest(contactID);
		if(contact==null) {
			throw new ContactDetailNotFoundException("Contact ID : "+ contactID);
		}
	}
}
