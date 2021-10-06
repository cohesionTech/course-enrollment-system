package com.hardik.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.hardik.spring.model.Course;




@Repository
public class CourseDAOImpl implements CourseDAO{
	
	private static final Logger logger = LoggerFactory.getLogger(CourseDAOImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
	
	//Add method
		public void addCourse(Course c){
			Session session = this.sessionFactory.getCurrentSession();

			System.out.println("Inserting Record...");
			
			session.save(c);
			
			System.out.println("Inserting Done");
			
			logger.info("Course saved successfully, Course Details="+c);
		}
		
		// Fetch records
		@SuppressWarnings("unchecked")
		public List<Course> listCourses() {
			Session session = this.sessionFactory.getCurrentSession();
			List<Course> courseList = session.createQuery("from Course").list();
			System.out.println("data..........."+courseList);
			System.out.println("Loading Course...");
			for(Course c : courseList){
				logger.info("Course List::"+c);
			}
			return courseList;
		}
		
		//Update method
		public void updateCourse(Course c){
			Session session = this.sessionFactory.getCurrentSession();

			System.out.println("Updating Record...");
			
			session.saveOrUpdate(c);
			
			System.out.println("updating Done");
			
			logger.info("Course updated successfully, Course Details="+c);

		}
		
		//Fetch a specific Record
		@SuppressWarnings("unchecked")
		public List<Course> editCourse(Course c) {
			Session session = this.sessionFactory.getCurrentSession();
			List<Course> courseRecord = session.createQuery("from Course where id="+c.getCrid()+"").list();
			System.out.println("Loading a Course...");
			for(Course c1 : courseRecord){
				logger.info("Course List::"+c1);
			}
			return courseRecord;
		}
		
		//Remove Record
		public void removeCourse(Course c){
			Session session = this.sessionFactory.getCurrentSession();

			System.out.println("Deleting Record...");
			
			session.delete(c);
			
			System.out.println("Deleting Done");
			
			logger.info("Course Deleted successfully, Course Details="+c);
		}
	
}