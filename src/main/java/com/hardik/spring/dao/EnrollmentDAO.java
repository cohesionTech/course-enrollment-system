package com.hardik.spring.dao;

import java.util.List;

import com.hardik.spring.model.Course;
import com.hardik.spring.model.Enrollment;
import com.hardik.spring.model.Student;
import com.hardik.spring.model.Term;


public interface EnrollmentDAO{
	
	public void addEnrollment(Enrollment e);
	public void updateEnrollment(Enrollment e);
	public List<Enrollment> listEnrollments();
	public List<Enrollment> editEnrollment(Enrollment e);
	public void removeEnrollment(Enrollment e);
	
	public List getCourse(Term t, Course c);
	public List getStudentList(Term t, Course c);
	public List<Enrollment> getEnrolledCourse(Student s);
	public int getValidaion(Course c, Term t);
}