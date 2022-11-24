package com.jdc04.demo2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jdc04.demo2.entity.Contact;
import com.jdc04.demo2.serviceImpl.ContactServiceImpl;

@Controller
public class IndexController {

	@Autowired
	private ContactServiceImpl contactServiceImpl;

	@GetMapping("/createcontact")
	public String createContactInfo(Model model) {
		model.addAttribute("contact", new Contact());
		return "contactInfo";
	}

	@PostMapping("/saveinfo")
	public String saveContactInfo(@RequestParam(required = false) Integer id, Contact contact, Model model) {

		// required=false
		// if request present in url then it assignes to Integer id,
		// else it will be ignored.. Integer id will be null in this case.

		if (id != null) {
			// api called for update data.
			contact.setContactId(id);
		}
		String msg = "";
		if (contactServiceImpl.saveContact(contact))
			msg = "Contact details saved successfully";
		else
			msg = "Error while saving details";

		model.addAttribute("msg", msg);

		return "index";
	}

	@GetMapping("/viewallcontacts")
	public String viewContactList(Model model) {
		List<Contact> allContact = contactServiceImpl.getAllContact();
		model.addAttribute("allcontacts", allContact);
		model.addAttribute("contact", new Contact());
		return "allcontacts";
	}

	@GetMapping("/deleteById")
	public String deleteContacts(@RequestParam("id") Integer contactId, Model model) {

		if (contactServiceImpl.deleteContactById(contactId)) {
			List<Contact> allContact = contactServiceImpl.getAllContact();
			model.addAttribute("allcontacts", allContact);
			model.addAttribute("contact", new Contact());
			return "allcontacts";
		}
		return null;
	}

	@GetMapping("/updateById")
	public String updateContacts(@RequestParam("id") Integer contactId, Model model) {
		Contact contact = contactServiceImpl.getContactById(contactId);
		System.out.println("Update contact method " + contact.getContactName() + " Switch " + contact.getActiveSwitch());
		model.addAttribute("contact", contact);
		return "contactInfo";

	}

	@PostMapping("/getfilteredcontacts")
	public String getFilteredListOfContacts(Contact contact, Model model) {
		System.out.println("Received object: \n" + contact.toString());
		List<Contact> filteredContacts = contactServiceImpl.getFilteredContacts(contact);
		model.addAttribute("allcontacts", filteredContacts);
		System.out.println("Filtered list of contact is");
		filteredContacts.forEach(c -> {
			System.out.println(c);
		});

		return "allcontacts";
	}

}
