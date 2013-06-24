package org.lesnikovskiy.contact.controllers;

import java.util.Locale;
import java.util.Map;

import org.lesnikovskiy.contact.domain.Contact;
import org.lesnikovskiy.contact.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ContactController {		
	@Autowired
	private ContactService contactService;
	
	@RequestMapping("/index")
	public String listContacts(Map<String, Object> map) {		
		map.put("contact", new Contact());
		map.put("contactList", contactService.listContact());
		
		return "home";
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		return "redirect:/index";
	}
	
	@RequestMapping(value="/add", method = RequestMethod.POST)
	public String addContact(@ModelAttribute("contact") Contact contact, BindingResult result) {
		contactService.addContact(contact);
		
		return "redirect:/index";
	}
	
	@RequestMapping(value="/edit/{contactId}", method = RequestMethod.GET)
	public String editContact(@PathVariable("contactId") Integer contactId, Model model) {
		Contact contact = contactService.getContact(contactId);
		contact.setFirstname("John");
		model.addAttribute("contact", contact);
		
		return "edit";
	}
	
	@RequestMapping(value="/delete/{contactId}")
	public String deleteContact(@PathVariable("contactId") Integer contactId) {
		contactService.removeContact(contactId);
		
		return "redirect:/index";
	}
}
