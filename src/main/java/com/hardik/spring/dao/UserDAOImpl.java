package com.hardik.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.hardik.spring.model.User;




@Repository
public class UserDAOImpl implements UserDAO{
	
	private static final Logger logger = LoggerFactory.getLogger(UserDAOImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
	
	//Add method
		public void addUser(User u){
			Session session = this.sessionFactory.getCurrentSession();

			System.out.println("Inserting Record...");
			
			session.save(u);
			
			System.out.println("Inserting Done");
			
			logger.info("User saved successfully, User Details="+u);
		}
		
		// Fetch records
		@SuppressWarnings("unchecked")
		public List<User> listUsers() {
			Session session = this.sessionFactory.getCurrentSession();
			List<User> userList = session.createQuery("from User").list();
			System.out.println("data..........."+userList);
			System.out.println("Loading Student...");
			for(User u : userList){
				logger.info("User List::"+u);
			}
			return userList;
		}
		
		//Update method
		public void updateUser(User u){
			Session session = this.sessionFactory.getCurrentSession();

			System.out.println("Updating Record...");
			
			session.saveOrUpdate(u);
			
			System.out.println("updating Done");
			
			logger.info("User updated successfully, User Details="+u);

		}
		
		//Fetch a specific Record
		@SuppressWarnings("unchecked")
		public List<User> editUser(User u) {
			Session session = this.sessionFactory.getCurrentSession();
			List<User> userRecord = session.createQuery("from User where id="+u.getUsername()+"").list();
			System.out.println("Loading a User...");
			for(User u1 : userRecord){
				logger.info("User List::"+u1);
			}
			return userRecord;
		}
		
		//Remove Record
		public void removeUser(User u){
			Session session = this.sessionFactory.getCurrentSession();

			System.out.println("Deleting Record...");
			
			session.delete(u);
			
			System.out.println("Deleting Done");
			
			logger.info("User Deleted successfully, User Details="+u);
		}
	
}