package com.hardik.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.hardik.spring.dao.StudentDAO;
import com.hardik.spring.model.Student;
import com.hardik.spring.model.User;



@Service
public class StudentServiceImpl implements StudentService {
	
	private StudentDAO studentDAO;

	public void setStudentDAO(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}

	
	@Transactional
	public void addStudent(Student s) {
		System.out.println("inside service");
		this.studentDAO.addStudent(s);
	}

	
	@Transactional
	public void updateStudent(Student s) {
		this.studentDAO.updateStudent(s);
	}

	
	@Transactional
	public List<Student> listStudents() {
		return this.studentDAO.listStudents();
	}

	@Transactional
	public List<Student> editStudent(Student s) {
		return this.studentDAO.editStudent(s);
	}
	

	@Transactional
	public void removeStudent(Student s) {
		this.studentDAO.removeStudent(s);
	}

	@Transactional
	public List<Student> getStudent(User u) {
		
		System.out.println("ssr.");
		return this.studentDAO.getStudent(u);
	}
}