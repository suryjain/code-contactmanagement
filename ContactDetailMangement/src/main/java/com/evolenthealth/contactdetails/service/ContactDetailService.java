package com.evolenthealth.contactdetails.service;

import java.util.List;

import com.evolenthealth.contactdetails.domain.Contact;

public interface ContactDetailService {

	public Contact addContactRequest(Contact contact);
	
	public List<Contact> retrieveContactList();
	
	public Contact retrieveContactRequest(String contactID);
	
	public Contact updateContactRequest(Contact contact);
	
	public Contact updateContactStatusRequest(String contactID);
	
	
}
