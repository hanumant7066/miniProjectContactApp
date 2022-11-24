package com.jdc04.demo2.serviceImpl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.jdc04.demo2.entity.Contact;
import com.jdc04.demo2.repository.ContactRepository;
import com.jdc04.demo2.service.ContactService;

@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactRepository contactRepository;

	@Override
	public boolean saveContact(Contact contact) {

		LocalDate todaysDate = java.time.LocalDate.now();
		if (contact.getContactId() != null) {
			// update existing contact
			Optional<Contact> oldContactfound = contactRepository.findById(contact.getContactId());
			if (oldContactfound.isPresent()) {
				Contact oldContact = oldContactfound.get();
				contact.setActiveSwitch(oldContact.getActiveSwitch());
				;
				contact.setCreateDate(oldContact.getCreateDate());
				contact.setUpdateDate(todaysDate);
			}

		} else {
			// save new contact
			contact.setActiveSwitch("Y");
			contact.setCreateDate(todaysDate);
			contact.setUpdateDate(todaysDate);
		}

		if (contactRepository.save(contact) != null)
			return true;

		return false;
	}

	@Override
	public List<Contact> getAllContact() {

		return contactRepository.findAll();
	}

	@Override
	public Contact getContactById(Integer contactId) {

		Optional<Contact> idFound = contactRepository.findById(contactId);

		if (idFound.isPresent())
			return idFound.get();

		return null;
	}

	@Override
	public boolean deleteContactById(Integer contactId) {

		if (contactRepository.existsById(contactId)) {
			contactRepository.deleteById(contactId);
			return true;
		}
		return false;
	}

	public List<Contact> getFilteredContacts(Contact contact) {
		
		// create fresh contact object and set filtered settings fields
		Contact con = new Contact();
		if (!contact.getContactEmail().isEmpty())
			con.setContactEmail(contact.getContactEmail());

		if (!contact.getContactName().isEmpty())
			con.setContactName(contact.getContactName());

		if (contact.getContactNumber() != null)
			con.setContactNumber(contact.getContactNumber());

		Example<Contact> ex = Example.of(con);
		List<Contact> allfilteredList = contactRepository.findAll(ex);
		return allfilteredList;

	}

}
