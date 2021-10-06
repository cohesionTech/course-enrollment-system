package com.hardik.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hardik.spring.dao.UserDAO;
import com.hardik.spring.model.User;



@Service
public class UserServiceImpl implements UserService {
	
	private UserDAO userDAO;

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}


	@Transactional
	public void addUser(User u) {
		System.out.println("inside service");
		this.userDAO.addUser(u);
	}

	
	@Transactional
	public void updateUser(User u) {
		this.userDAO.updateUser(u);
	}

	
	@Transactional
	public List<User> listUsers() {
		return this.userDAO.listUsers();
	}

	@Transactional
	public List<User> editUser(User u) {
		return this.userDAO.editUser(u);
	}
	

	@Transactional
	public void removeUser(User u) {
		this.userDAO.removeUser(u);
	}

}