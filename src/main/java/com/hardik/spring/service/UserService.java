package com.hardik.spring.service;

import java.util.List;

import com.hardik.spring.model.User;


public interface UserService{
	
	public void addUser(User u);
	public void updateUser(User u);
	public List<User> listUsers();
	public List<User> editUser(User u);
	public void removeUser(User u);
}