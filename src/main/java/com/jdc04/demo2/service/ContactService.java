package com.jdc04.demo2.service;

import java.util.List;

import com.jdc04.demo2.entity.Contact;

public interface ContactService {

	public boolean saveContact(Contact contact);

	public List<Contact> getAllContact();

	public Contact getContactById(Integer contactId);

	public boolean deleteContactById(Integer contactId);

}
