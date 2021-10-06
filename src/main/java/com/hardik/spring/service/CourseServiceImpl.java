package com.hardik.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hardik.spring.dao.CourseDAO;
import com.hardik.spring.model.Course;



@Service
public class CourseServiceImpl implements CourseService {
	
	private CourseDAO courseDAO;

	public void setCourseDAO(CourseDAO courseDAO) {
		this.courseDAO = courseDAO;
	}

	
	@Transactional
	public void addCourse(Course c) {
		this.courseDAO.addCourse(c);
	}

	
	@Transactional
	public void updateCourse(Course c) {
		this.courseDAO.updateCourse(c);
	}

	
	@Transactional
	public List<Course> listCourses() {
		return this.courseDAO.listCourses();
	}

	@Transactional
	public List<Course> editCourse(Course c) {
		return this.courseDAO.editCourse(c);
	}
	

	@Transactional
	public void removeCourse(Course c) {
		this.courseDAO.removeCourse(c);
	}

}