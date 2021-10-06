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
import com.hardik.spring.model.TeacherMap;




@Repository
public class TeacherMapDAOImpl implements TeacherMapDAO{
	
	private static final Logger logger = LoggerFactory.getLogger(TeacherMapDAOImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
	
	//Add method
		public void addTeacherMap(TeacherMap tm){
			Session session = this.sessionFactory.getCurrentSession();

			System.out.println("Inserting Record...");
			
			session.save(tm);
			
			System.out.println("Inserting Done");
			
			logger.info("Teacher saved successfully, Teacher Details="+tm);
		}
		
		// Fetch records
		@SuppressWarnings("unchecked")
		public List<TeacherMap> listTeacherMaps(){
			Session session = this.sessionFactory.getCurrentSession();
			List<TeacherMap> teacherMapList = session.createQuery("from TeacherMap").list();
			System.out.println("data..........."+teacherMapList);
			System.out.println("Loading Student...");
			for(TeacherMap tm : teacherMapList){
				logger.info("TeacherMap List::"+tm);
			}
			return teacherMapList;
		}
		
		//Update method
		public void updateTeacherMap(TeacherMap tm){
			Session session = this.sessionFactory.getCurrentSession();

			System.out.println("Updating Record...");
			
			session.saveOrUpdate(tm);
			
			System.out.println("updating Done");
			
			logger.info("Teacher updated successfully, Teacher Details="+tm);

		}
		
		//Fetch a specific Record
		@SuppressWarnings("unchecked")
		public List<TeacherMap> editTeacherMap(TeacherMap tm) {
			Session session = this.sessionFactory.getCurrentSession();
			List<TeacherMap> teacherMapRecord = session.createQuery("from TeacherMap where id="+tm.getTmap()+"").list();
			System.out.println("Loading a Student...");
			for(TeacherMap t1 : teacherMapRecord){
				logger.info("TeacherMap List::"+t1);
			}
			return teacherMapRecord;
		}
		
		//Remove Record
		public void removeTeacherMap(TeacherMap tm){
			Session session = this.sessionFactory.getCurrentSession();

			System.out.println("Deleting Record...");
			
			session.delete(tm);
			
			System.out.println("Deleting Done");
			
			logger.info("Teacher Deleted successfully, Teacher Details="+tm);
		}
		
		@SuppressWarnings("unchecked")
		public List<TeacherMap> getAssignedCourse(Teacher t){
			List ls1=null;
			Session session = this.sessionFactory.getCurrentSession();
		    System.out.println("user...."+t.getTeid());
		
			//System.out.println("...."+s.getFirstname());
			Query q= session.createQuery("from TeacherMap where teid = :p1");
			
			q.setParameter("p1", t.getTeid());
			ls1=q.list();
		
			System.out.println("done = " + ls1.size());
			
			List<TeacherMap> teacherMapRecord=q.list();
			System.out.println("Loading a Course...");
			
			return teacherMapRecord;
		}
}