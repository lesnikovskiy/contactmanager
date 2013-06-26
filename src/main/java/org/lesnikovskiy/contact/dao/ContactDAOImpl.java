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
	
	public void updateContact(Contact contact) {
		sessionFactory.getCurrentSession().update(contact);
	}
	
	public Contact getContact(Integer id) {
		Session session = sessionFactory.getCurrentSession();		
		Contact contact = (Contact) session.createQuery("from Contact where id=:id").setInteger("id", id).uniqueResult();
		
		return contact;
	}

	@SuppressWarnings("unchecked")
	public List<Contact> listContact() {
		return sessionFactory.getCurrentSession().createQuery("from Contact").list();
	}

	public void removeContact(Integer id) {
		Contact contact = this.getContact(id);
		if (contact != null)
			sessionFactory.getCurrentSession().delete(contact);
	}
}
