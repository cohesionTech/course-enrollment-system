package com.hardik.spring.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.hardik.spring.model.Course;
import com.hardik.spring.model.Location;
import com.hardik.spring.model.Teacher;
import com.hardik.spring.model.Term;




@Repository
public class LocationDAOImpl implements LocationDAO{
	
	private static final Logger logger = LoggerFactory.getLogger(LocationDAOImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
	
	//Add method
		public void addLocation(Location l){
			Session session = this.sessionFactory.getCurrentSession();

			System.out.println("Inserting Record...");
			
			session.save(l);
			
			System.out.println("Inserting Done");
			
			logger.info("Location saved successfully, Location Details="+l);
		}
		
		// Fetch records
		@SuppressWarnings("unchecked")
		public List<Location> listLocations() {
			Session session = this.sessionFactory.getCurrentSession();
			List<Location> locationList = session.createQuery("from Location").list();
			System.out.println("data..........."+locationList);
			System.out.println("Loading Location...");
			for(Location l : locationList){
				logger.info("Course List::"+l);
			}
			return locationList;
		}
		
		//Update method
		public void updateLocation(Location l){
			Session session = this.sessionFactory.getCurrentSession();

			System.out.println("Updating Record...");
			
			session.saveOrUpdate(l);
			
			System.out.println("updating Done");
			
			logger.info("Location updated successfully, Location Details="+l);

		}
		
		//Fetch a specific Record
		@SuppressWarnings("unchecked")
		public List<Location> editLocation(Location l) {
			Session session = this.sessionFactory.getCurrentSession();
			List<Location> locationRecord = session.createQuery("from Location where id="+l.getLid()+"").list();
			System.out.println("Loading a Course...");
			for(Location l1 : locationRecord){
				logger.info("Location List::"+l1);
			}
			return locationRecord;
		}
		
		
		//Remove Record
		public void removeLocation(Location l){
			Session session = this.sessionFactory.getCurrentSession();

			System.out.println("Deleting Record...");
			
			session.delete(l);
			
			System.out.println("Deleting Done");
			
			logger.info("Location Deleted successfully, Location Details="+l);
		}
		
		@SuppressWarnings("unchecked")
		public List<Location> getCourseLocation(Course c){
			Session session = this.sessionFactory.getCurrentSession();
			List<Location> locationRecord = session.createQuery("from Location where crid="+c.getCrid()+"").list();
			System.out.println("Loading a Course..."+locationRecord);
			for(Location l1 : locationRecord){
				logger.info("Location List::"+l1);
			}
			return locationRecord;
			
		}
		
		
		@SuppressWarnings("unchecked")
		public List<Location> getSchedule(Teacher t)
		{
			List ls1=null;
			Session session = this.sessionFactory.getCurrentSession();
			System.out.println("teacher...."+t.getTeid());
			
			//System.out.println("...."+s.getFirstname());
			Query q= session.createQuery("from TeacherMap as tm, Location as l where tm.course.crid=l.course.crid ");
			
			ls1=q.list();
		
			System.out.println("done = " + ls1.size());
			
			List<Location> studentList=q.list();
			System.out.println("Loading StudentList..."+studentList);
			
			return studentList;
		
		}
	
}