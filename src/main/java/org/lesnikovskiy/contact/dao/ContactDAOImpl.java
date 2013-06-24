package org.lesnikovskiy.contact.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.lesnikovskiy.contact.domain.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ContactDAOImpl implements ContactDAO {
	@Autowired
	private SessionFactory sessionFactory;

	public void addContact(Contact contact) {
		sessionFactory.getCurrentSession().save(contact);
	}
	
	public Contact getContact(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		Contact contact = (Contact) session.load(Contact.class, id);
		
		return contact;
	}

	@SuppressWarnings("unchecked")
	public List<Contact> listContact() {
		return sessionFactory.getCurrentSession().createQuery("from Contact").list();
	}

	public void removeContact(Integer id) {
		Contact contact = this.getContact(2);
		if (contact != null)
			sessionFactory.getCurrentSession().delete(contact);
	}

}
