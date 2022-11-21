package com.jdc04.demo2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	public String saveContactInfo(Contact contact, Model model) {
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

		if (contactServiceImpl.deleteContactById(contactId)) {
			List<Contact> allContact = contactServiceImpl.getAllContact();
			model.addAttribute("allcontacts", allContact);
			model.addAttribute("contact", new Contact());
			return "allcontacts";
		}
		return null;
	}

}
