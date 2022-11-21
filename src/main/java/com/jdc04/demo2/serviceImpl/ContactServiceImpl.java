package com.jdc04.demo2.serviceImpl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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

		contact.setActiveSwitch('Y');
		LocalDate now = java.time.LocalDate.now();
		contact.setCreateDate(now);
		contact.setUpdateDate(now);

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

		Optional<Contact> findById = contactRepository.findById(contactId);
		if (findById.isPresent()) {
			contactRepository.deleteById(contactId);
			return true;
		}
		return false;
	}

}
