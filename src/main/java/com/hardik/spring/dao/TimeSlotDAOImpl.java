package com.hardik.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import org.springframework.stereotype.Repository;

import com.hardik.spring.model.TimeSlot;

@Repository
public class TimeSlotDAOImpl implements TimeSlotDAO{
	
	private static final Logger logger = LoggerFactory.getLogger(TimeSlotDAOImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
	
	//Add method
	public void addTimeSlot(TimeSlot ts){
		Session session = this.sessionFactory.getCurrentSession();

		System.out.println("Inserting Record...");
		
		session.save(ts);
		
		System.out.println("Inserting Done");
		
		logger.info("TimeSlot saved successfully, TimeSlot Details="+ts);
	}
	
	// Fetch records
	@SuppressWarnings("unchecked")
	public List<TimeSlot> listTimeSlots() {
		Session session = this.sessionFactory.getCurrentSession();
		List<TimeSlot> timeSlotList = session.createQuery("from TimeSlot").list();
		System.out.println("Loading TimeSlot...");
		for(TimeSlot ts : timeSlotList){
			logger.info("TimeSlot List::"+ts);
		}
		return timeSlotList;
	}
	
	//Update method
	public void updateTimeSlot(TimeSlot ts){
		Session session = this.sessionFactory.getCurrentSession();

		System.out.println("Updating Record...");
		
		session.saveOrUpdate(ts);
		
		System.out.println("updating Done");
		
		logger.info("TimeSlot updated successfully, TimeSlot Details="+ts);

	}
	
	//Fetch a specific Record
	@SuppressWarnings("unchecked")
	public List<TimeSlot> editTimeSlot(TimeSlot ts) {
		Session session = this.sessionFactory.getCurrentSession();
		List<TimeSlot> timeSlotRecord = session.createQuery("from TimeSlot where id="+ts.getTsid()+"").list();
		System.out.println("Loading a TimeSlot...");
		for(TimeSlot ts1 : timeSlotRecord){
			logger.info("TimeSlot List::"+ts1);
		}
		return timeSlotRecord;
	}
	
	//Remove Record
	public void removeTimeSlot(TimeSlot ts){
		Session session = this.sessionFactory.getCurrentSession();

		System.out.println("Deleting Record...");
		
		session.delete(ts);
		
		System.out.println("Deleting Done");
		
		logger.info("TimeSlot Deleted successfully, TimeSlot Details="+ts);
	}
	
	
}

