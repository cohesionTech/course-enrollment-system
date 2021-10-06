package com.hardik.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import org.springframework.stereotype.Repository;

import com.hardik.spring.model.Term;

@Repository
public class TermDAOImpl implements TermDAO{
	
	private static final Logger logger = LoggerFactory.getLogger(TermDAOImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
	
	//Add method
	public void addTerm(Term t){
		Session session = this.sessionFactory.getCurrentSession();

		System.out.println("Inserting Record...");
		
		session.save(t);
		
		System.out.println("Inserting Done");
		
		logger.info("Term saved successfully, Term Details="+t);
	}
	
	// Fetch records
	@SuppressWarnings("unchecked")
	public List<Term> listTerms() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Term> termList = session.createQuery("from Term").list();
		System.out.println("Loading Term...");
		for(Term t : termList){
			logger.info("Term List::"+t);
		}
		return termList;
	}
	
	//Update method
	public void updateTerm(Term t){
		Session session = this.sessionFactory.getCurrentSession();

		System.out.println("Updating Record...");
		
		session.saveOrUpdate(t);
		
		System.out.println("updating Done");
		
		logger.info("Term updated successfully, Term Details="+t);

	}
	
	//Fetch a specific Record
	@SuppressWarnings("unchecked")
	public List<Term> editTerm(Term t) {
		Session session = this.sessionFactory.getCurrentSession();
		List<Term> termRecord = session.createQuery("from Term where id="+t.getTid()+"").list();
		System.out.println("Loading a Term...");
		for(Term t1 : termRecord){
			logger.info("Term List::"+t1);
		}
		return termRecord;
	}
	
	//Remove Record
	public void removeTerm(Term t){
		Session session = this.sessionFactory.getCurrentSession();

		System.out.println("Deleting Record...");
		
		session.delete(t);
		
		System.out.println("Deleting Done");
		
		logger.info("Term Deleted successfully, Term Details="+t);
	}
	
	
}

