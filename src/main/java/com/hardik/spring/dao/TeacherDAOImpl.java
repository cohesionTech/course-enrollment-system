package com.hardik.spring.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.hardik.spring.model.Teacher;
import com.hardik.spring.model.User;




@Repository
public class TeacherDAOImpl implements TeacherDAO{
	
	private static final Logger logger = LoggerFactory.getLogger(TeacherDAOImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
	
	//Add method
		public void addTeacher(Teacher t){
			Session session = this.sessionFactory.getCurrentSession();

			System.out.println("Inserting Record...");
			
			session.save(t);
			
			System.out.println("Inserting Done");
			
			logger.info("Teacher saved successfully, Teacher Details="+t);
		}
		
		// Fetch records
		@SuppressWarnings("unchecked")
		public List<Teacher> listTeachers() {
			Session session = this.sessionFactory.getCurrentSession();
			List<Teacher> teacherList = session.createQuery("from Teacher").list();
			System.out.println("data..........."+teacherList);
			System.out.println("Loading Student...");
			for(Teacher t : teacherList){
				logger.info("Teacher List::"+t);
			}
			return teacherList;
		}
		
		//Update method
		public void updateTeacher(Teacher t){
			Session session = this.sessionFactory.getCurrentSession();

			System.out.println("Updating Record...");
			
			session.saveOrUpdate(t);
			
			System.out.println("updating Done");
			
			logger.info("Teacher updated successfully, Teacher Details="+t);

		}
		
		//Fetch a specific Record
		@SuppressWarnings("unchecked")
		public List<Teacher> editTeacher(Teacher t) {
			Session session = this.sessionFactory.getCurrentSession();
			List<Teacher> teacherRecord = session.createQuery("from Teacher where id="+t.getTeid()+"").list();
			System.out.println("Loading a Student...");
			for(Teacher t1 : teacherRecord){
				logger.info("Teacher List::"+t1);
			}
			return teacherRecord;
		}
		
		//Remove Record
		public void removeTeacher(Teacher t){
			Session session = this.sessionFactory.getCurrentSession();

			System.out.println("Deleting Record...");
			
			session.delete(t);
			
			System.out.println("Deleting Done");
			
			logger.info("Teacher Deleted successfully, Teacher Details="+t);
		}
	
		@SuppressWarnings("unchecked")
		public List<Teacher> getTeacher(User u) {
			
			List ls1=null;
			Session session = this.sessionFactory.getCurrentSession();
		    System.out.println("user...."+u.getUsername());
		
			//System.out.println("...."+s.getFirstname());
			Query q= session.createQuery("from Teacher where username = :p1");
			
			q.setParameter("p1", u.getUsername());
			ls1=q.list();
		
			System.out.println("done = " + ls1.size());
			
			System.out.println("iiiiiiiiiiiiiiiiiiiii"+q.getFetchSize());
			
			List<Teacher> teacherProfRecord=q.list();
			System.out.println("Loading a Course...");
			
			return teacherProfRecord;
		}
		
}