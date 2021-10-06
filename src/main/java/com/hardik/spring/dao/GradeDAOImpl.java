package com.hardik.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.hardik.spring.model.Course;
import com.hardik.spring.model.Grade;
import com.hardik.spring.model.Student;
import com.hardik.spring.model.Term;




@Repository
public class GradeDAOImpl implements GradeDAO{
	
	private static final Logger logger = LoggerFactory.getLogger(GradeDAOImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
	
	//Add method
		public void addGrade(Grade g){
			Session session = this.sessionFactory.getCurrentSession();

			System.out.println("Inserting Record...");
			
			session.save(g);
			
			System.out.println("Inserting Done");
			
			logger.info("Grade saved successfully, Grade Details="+g);
		}
		
		// Fetch records
		@SuppressWarnings("unchecked")
		public List<Grade> listGrades(Course c, Term t) {
			Session session = this.sessionFactory.getCurrentSession();
			List<Grade> gradeRecord = session.createQuery("from Grade where crid="+c.getCrid()+" and tid="+t.getTid()+"").list();
			System.out.println("Loading a Grade...");
			for(Grade g1 : gradeRecord){
				logger.info("Grade List::"+g1);
			}
			return gradeRecord;
		}
		
		//Update method
		public void updateGrade(Grade g){
			Session session = this.sessionFactory.getCurrentSession();

			System.out.println("Updating Record...");
			
			session.saveOrUpdate(g);
			
			System.out.println("updating Done");
			
			logger.info("Grade updated successfully, Grade Details="+g);

		}
		
		//Fetch a specific Record
		@SuppressWarnings("unchecked")
		public List<Grade> editGrade(Grade g) {
			Session session = this.sessionFactory.getCurrentSession();
			List<Grade> gradeRecord = session.createQuery("from Grade where id="+g.getGid()+"").list();
			System.out.println("Loading a Grade...");
			for(Grade g1 : gradeRecord){
				logger.info("Grade List::"+g1);
			}
			return gradeRecord;
		}
		
		//Remove Record
		public void removeGrade(Grade g){
			Session session = this.sessionFactory.getCurrentSession();

			System.out.println("Deleting Record...");
			
			session.delete(g);
			
			System.out.println("Deleting Done");
			
			logger.info("Grade Deleted successfully, Grade Details="+g);
		}
	
		@SuppressWarnings("unchecked")
		public List<Grade> Grades(Student s) {
			Session session = this.sessionFactory.getCurrentSession();
			List<Grade> gradeRecord = session.createQuery("from Grade where sid="+s.getSid()+"").list();
			System.out.println("Loading a Grade...");
			for(Grade g1 : gradeRecord){
				logger.info("Grade List::"+g1);
			}
			return gradeRecord;
		}
}