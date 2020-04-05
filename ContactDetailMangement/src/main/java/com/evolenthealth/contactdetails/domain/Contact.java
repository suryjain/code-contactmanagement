package com.evolenthealth.contactdetails.domain;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

public class Contact {

	private String contactID;
	@Size(min = 2 ,max = 20 , message="First Name shoud be in between 2 and 20 character.")
	private String firstName;
	@Size(min = 2 ,max = 20 , message="Last Name shoud be in between 2 and 20 character.")
	private String lastName;

	@Email(message="Email id should be valid")
	private String email;
	private String phone;
	private StatusEnum status;
	
	public Contact(String contactID, String firstName, String lastName, String email, String phone, StatusEnum status) {
		super();
		this.contactID = contactID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.status = status;
	}
	
	public String getContactID() {
		return contactID;
	}
	public void setContactID(String contactID) {
		this.contactID = contactID;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public StatusEnum getStatus() {
		return status;
	}
	public void setStatus(StatusEnum status) {
		this.status = status;
	}
	
}
