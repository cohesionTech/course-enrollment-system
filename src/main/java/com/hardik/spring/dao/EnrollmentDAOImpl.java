package com.hardik.spring.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.hardik.spring.model.Course;
import com.hardik.spring.model.Enrollment;
import com.hardik.spring.model.Student;
import com.hardik.spring.model.Teacher;
import com.hardik.spring.model.TeacherMap;
import com.hardik.spring.model.Term;




@Repository
public class EnrollmentDAOImpl implements EnrollmentDAO{
	
	private static final Logger logger = LoggerFactory.getLogger(EnrollmentDAOImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
	
	public List getCourse(Term t, Course c)
	{	
		List ls1=null;
		Session session = this.sessionFactory.getCurrentSession();
		System.out.println("term...."+t.getTid());
		System.out.println("course...."+c.getCrid());
		
		//System.out.println("...."+s.getFirstname());
		Query q= session.createQuery("from Course where crid="+c.getCrid()+" and tid="+t.getTid()+"");
		
		
		ls1=q.list();
	
		System.out.println("done = " + ls1.size());
		
		List courseRecord=q.list();
		System.out.println("Loading a Course...");
		
		return courseRecord;
		
	}
	
	public List getStudentList(Term t, Course c)
	{
		List ls1=null;
		Session session = this.sessionFactory.getCurrentSession();
		System.out.println("term...."+t.getTid());
		System.out.println("course...."+c.getCrid());
		
		//System.out.println("...."+s.getFirstname());
		Query q= session.createQuery("from Enrollment where crid="+c.getCrid()+" and tid="+t.getTid()+"");
		
		ls1=q.list();
	
		System.out.println("done = " + ls1.size());
		
		List studentList=q.list();
		System.out.println("Loading StudentList...");
		
		return studentList;
	
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Enrollment> getEnrolledCourse(Student s){
		List ls1=null;
		Session session = this.sessionFactory.getCurrentSession();
	    System.out.println("user...."+s.getSid());
	
		//System.out.println("...."+s.getFirstname());
		Query q= session.createQuery("from Enrollment where sid = :p1");
		
		q.setParameter("p1", s.getSid());
		ls1=q.list();
	
		System.out.println("done = " + ls1.size());
		
		List<Enrollment> enrollmentRecord=q.list();
		System.out.println("Loading a Course...");
		
		return enrollmentRecord;
	}
	
	
	public int getValidaion(Course c, Term t)
	{
		List ls1=null;
		Session session = this.sessionFactory.getCurrentSession();
		System.out.println("term...."+t.getTid());
		System.out.println("course...."+c.getCrid());
		
		//System.out.println("...."+s.getFirstname());
		Query q= session.createQuery("from Enrollment where crid="+c.getCrid()+" and tid="+t.getTid()+"");
		
		ls1=q.list();
	
		System.out.println("done = " + ls1.size());
		
		int student_Size=ls1.size();
		
		return student_Size;
	
		
	}
	//Add method
		public void addEnrollment(Enrollment e){
			Session session = this.sessionFactory.getCurrentSession();

			System.out.println("Inserting Record...");
			
			session.save(e);
			
			System.out.println("Inserting Done");
			
			logger.info("Enrollment saved successfully, Enrollment Details="+e);
		}
		
		// Fetch records
		@SuppressWarnings("unchecked")
		public List<Enrollment> listEnrollments() {
			Session session = this.sessionFactory.getCurrentSession();
			List<Enrollment> enrollmentList = session.createQuery("from Enrollment").list();
			System.out.println("Loading Course...");
			for(Enrollment e : enrollmentList){
				logger.info("Enrollment List::"+e);
			}
			return enrollmentList;
		}
		
		//Update method
		public void updateEnrollment(Enrollment e){
			Session session = this.sessionFactory.getCurrentSession();

			System.out.println("Updating Record...");
			
			session.saveOrUpdate(e);
			
			System.out.println("updating Done");
			
			logger.info("Enrollment updated successfully, Enrollment Details="+e);

		}
		
		//Fetch a specific Record
		@SuppressWarnings("unchecked")
		public List<Enrollment> editEnrollment(Enrollment e) {
			Session session = this.sessionFactory.getCurrentSession();
			List<Enrollment> enrollmentRecord = session.createQuery("from Enrollment where id="+e.getSmap()+"").list();
			System.out.println("Loading a Course...");
			for(Enrollment e1 : enrollmentRecord){
				logger.info("Enrollment List::"+e1);
			}
			return enrollmentRecord;
		}
		
		//Remove Record
		public void removeEnrollment(Enrollment e){
			Session session = this.sessionFactory.getCurrentSession();

			System.out.println("Deleting Record...");
			
			session.delete(e);
			
			System.out.println("Deleting Done");
			
			logger.info("Enrollment Deleted successfully, Enrollment Details="+e);
		}
	
}