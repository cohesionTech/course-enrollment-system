package com.hardik.spring.dao;

import java.util.List;

import com.hardik.spring.model.Teacher;
import com.hardik.spring.model.User;


public interface TeacherDAO{
	
	public void addTeacher(Teacher t);
	public void updateTeacher(Teacher t);
	public List<Teacher> listTeachers();
	public List<Teacher> editTeacher(Teacher t);
	public void removeTeacher(Teacher t);
	public List<Teacher> getTeacher(User u);
}