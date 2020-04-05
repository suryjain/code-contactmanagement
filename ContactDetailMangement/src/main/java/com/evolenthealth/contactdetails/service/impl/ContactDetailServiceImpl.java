package com.evolenthealth.contactdetails.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.evolenthealth.contactdetails.domain.Contact;
import com.evolenthealth.contactdetails.domain.StatusEnum;
import com.evolenthealth.contactdetails.service.ContactDetailService;

@Service
public class ContactDetailServiceImpl implements ContactDetailService {

	private static List<Contact> contactList = new ArrayList<Contact>();
	
	static {
	contactList.add(new Contact("Test123","TestFirst","Testlast","test@test.com","4353453",StatusEnum.ACTIVE));
	};
	
	@Override
	public Contact addContactRequest(Contact contact) {
		// TODO Auto-generated method stub
		if(contact.getContactID()==null || contact.getContactID().trim().equals("")){
			contact.setContactID(contact.getFirstName() +  new Random().nextInt(10000));
			contact.setStatus(StatusEnum.ACTIVE);
			contactList.add(contact);
			return contact;
		}else {
			return null;
		}
	}

	@Override
	public List<Contact> retrieveContactList() {
		// TODO Auto-generated method stub
		return contactList;
	}

	
	@Override
	public Contact retrieveContactRequest(String contactID) {
		// TODO Auto-generated method stub
		for(Contact contact : contactList) {
			if(contact.getContactID().equals(contactID)) {
				return contact;
			}
		}
		return null;
	}

	@Override
	public Contact updateContactRequest(Contact contact) {
		for(Contact contactdata : contactList) {
			if(contact.getContactID().equals(contactdata.getContactID())) {
				contactList.remove(contactdata);
				contact.setStatus(contactdata.getStatus());
				contactList.add(contact);
				return contact;
			}
		}
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Contact updateContactStatusRequest(String contactID) {
		// TODO Auto-generated method stub
		for(Contact contact : contactList) {
			if(contact.getContactID().equals(contactID) && contact.getStatus().equals(StatusEnum.ACTIVE)) {
				contactList.remove(contact);
				contact.setStatus(StatusEnum.INACTIVE);
				contactList.add(contact);
				return contact;
			}
		}
		return null;
	}

	
}
