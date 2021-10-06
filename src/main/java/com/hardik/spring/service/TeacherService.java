package com.hardik.spring.service;

import java.util.List;

import com.hardik.spring.model.Teacher;
import com.hardik.spring.model.User;


public interface TeacherService{
	
	public void addTeacher(Teacher t);
	public void updateTeacher(Teacher t);
	public List<Teacher> listTeachers();
	public List<Teacher> editTeacher(Teacher t);
	public void removeTeacher(Teacher t);
	public List<Teacher> getTeacher(User u);
}