package com.hardik.spring.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;


import com.hardik.spring.model.Student;
import com.hardik.spring.model.Teacher;
import com.hardik.spring.model.User;




@Repository
public class StudentDAOImpl implements StudentDAO{
	
	private static final Logger logger = LoggerFactory.getLogger(StudentDAOImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
	
	//Add method
		public void addStudent(Student s){
			Session session = this.sessionFactory.getCurrentSession();

			System.out.println("Inserting Record...");
			
			session.save(s);
			
			System.out.println("Inserting Done");
			
			logger.info("Student saved successfully, Student Details="+s);
		}
		
		// Fetch records
		@SuppressWarnings("unchecked")
		public List<Student> listStudents() {
			Session session = this.sessionFactory.getCurrentSession();
			List<Student> studentList = session.createQuery("from Student").list();
			System.out.println("data..........."+studentList);
			System.out.println("Loading Student...");
			for(Student s : studentList){
				logger.info("Student List::"+s);
			}
			return studentList;
		}
		
		//Update method
		public void updateStudent(Student s){
			Session session = this.sessionFactory.getCurrentSession();

			System.out.println("Updating Record...");
			
			session.saveOrUpdate(s);
			
			System.out.println("updating Done");
			
			logger.info("Student updated successfully, Student Details="+s);

		}
		
		//Fetch a specific Record
		@SuppressWarnings("unchecked")
		public List<Student> editStudent(Student s) {
			Session session = this.sessionFactory.getCurrentSession();
			List<Student> studentRecord = session.createQuery("from Student where id="+s.getSid()+"").list();
			System.out.println("Loading a Student...");
			for(Student s1 : studentRecord){
				logger.info("Student List::"+s1);
			}
			return studentRecord;
		}
		
		//Remove Record
		public void removeStudent(Student s){
			Session session = this.sessionFactory.getCurrentSession();

			System.out.println("Deleting Record...");
			
			session.delete(s);
			
			System.out.println("Deleting Done");
			
			logger.info("Student Deleted successfully, Student Details="+s);
		}
		
		@SuppressWarnings("unchecked")
		public List<Student> getStudent(User u) {
			
			List ls1=null;
			Session session = this.sessionFactory.getCurrentSession();
		    System.out.println("user...."+u.getUsername());
		
			//System.out.println("...."+s.getFirstname());
			Query q= session.createQuery("from Student where username = :p1");
			
			q.setParameter("p1", u.getUsername());
			ls1=q.list();
		
			System.out.println("done = " + ls1.size());
			
			System.out.println("iiiiiiiiiiiiiiiiiiiii"+q.getFetchSize());
			
			List<Student> studentProfRecord=q.list();
			System.out.println("Loading a Course...");
			
			return studentProfRecord;
		}
	
}