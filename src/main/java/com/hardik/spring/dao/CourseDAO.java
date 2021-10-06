package com.hardik.spring.dao;

import java.util.List;

import com.hardik.spring.model.Course;


public interface CourseDAO{
	
	public void addCourse(Course c);
	public void updateCourse(Course c);
	public List<Course> listCourses();
	public List<Course> editCourse(Course c);
	public void removeCourse(Course c);
}