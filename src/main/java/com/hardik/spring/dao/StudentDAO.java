package com.hardik.spring.dao;

import java.util.List;

import com.hardik.spring.model.Student;
import com.hardik.spring.model.User;


public interface StudentDAO{
	
	public void addStudent(Student s);
	public void updateStudent(Student s);
	public List<Student> listStudents();
	public List<Student> editStudent(Student s);
	public void removeStudent(Student s);
	public List<Student> getStudent(User u);
}