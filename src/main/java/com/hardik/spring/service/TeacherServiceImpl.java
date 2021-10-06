package com.hardik.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hardik.spring.dao.TeacherDAO;
import com.hardik.spring.model.Teacher;
import com.hardik.spring.model.User;



@Service
public class TeacherServiceImpl implements TeacherService {
	
	private TeacherDAO teacherDAO;
	
	public void setTeacherDAO(TeacherDAO teacherDAO) {
		this.teacherDAO = teacherDAO;
	}

	
	@Transactional
	public void addTeacher(Teacher t) {
		System.out.println("inside service");
		this.teacherDAO.addTeacher(t);
	}

	
	@Transactional
	public void updateTeacher(Teacher t) {
		this.teacherDAO.updateTeacher(t);
	}

	
	@Transactional
	public List<Teacher> listTeachers() {
		return this.teacherDAO.listTeachers();
	}

	@Transactional
	public List<Teacher> editTeacher(Teacher t) {
		return this.teacherDAO.editTeacher(t);
	}
	

	@Transactional
	public void removeTeacher(Teacher t) {
		this.teacherDAO.removeTeacher(t);
	}
	
	
	@Transactional
	public List<Teacher> getTeacher(User u) {
		
		System.out.println("ssr.");
		return this.teacherDAO.getTeacher(u);
	}

}