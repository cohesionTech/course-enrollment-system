package com.hardik.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.hardik.spring.model.Department;



@Repository
public class DepartmentDAOImpl implements DepartmentDAO{
	
	private static final Logger logger = LoggerFactory.getLogger(DepartmentDAOImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
	
	//Add method
		public void addDepartment(Department d){
			Session session = this.sessionFactory.getCurrentSession();

			System.out.println("Inserting Record...");
			
			session.save(d);
			
			System.out.println("Inserting Done");
			
			logger.info("Department saved successfully, Department Details="+d);
		}
		
		// Fetch records
		@SuppressWarnings("unchecked")
		public List<Department> listDepartments() {
			Session session = this.sessionFactory.getCurrentSession();
			List<Department> departmentList = session.createQuery("from Department").list();
			System.out.println("data..........."+departmentList);
			System.out.println("Loading Term...");
			for(Department d : departmentList){
				logger.info("Department List::"+d);
			}
			return departmentList;
		}
		
		//Update method
		public void updateDepartment(Department d){
			Session session = this.sessionFactory.getCurrentSession();

			System.out.println("Updating Record...");
			
			session.saveOrUpdate(d);
			
			System.out.println("updating Done");
			
			logger.info("Department updated successfully, Department Details="+d);

		}
		
		//Fetch a specific Record
		@SuppressWarnings("unchecked")
		public List<Department> editDepartment(Department d) {
			Session session = this.sessionFactory.getCurrentSession();
			List<Department> departmentRecord = session.createQuery("from Department where id="+d.getDeid()+"").list();
			System.out.println("Loading a Department...");
			for(Department d1 : departmentRecord){
				logger.info("Department List::"+d1);
			}
			return departmentRecord;
		}
		
		//Remove Record
		public void removeDepartment(Department d){
			Session session = this.sessionFactory.getCurrentSession();

			System.out.println("Deleting Record...");
			
			session.delete(d);
			
			System.out.println("Deleting Done");
			
			logger.info("Department Deleted successfully, Department Details="+d);
		}
	
}