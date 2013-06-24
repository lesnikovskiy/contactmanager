package org.lesnikovskiy.contact.dao;

import java.util.List;

import org.lesnikovskiy.contact.domain.Contact;

public interface ContactDAO {
	public void addContact(Contact contact);
	public Contact getContact(Integer id);
	public List<Contact> listContact();
	public void removeContact(Integer id);
}

