package org.lesnikovskiy.contact.service;

import java.util.List;

import org.lesnikovskiy.contact.domain.Contact;

public interface ContactService {
	public void addContact(Contact contact);
	public List<Contact> listContact();
	public void removeContact(Integer id);
}
