package com.hardik.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hardik.spring.dao.EnrollmentDAO;
import com.hardik.spring.model.Course;
import com.hardik.spring.model.Enrollment;
import com.hardik.spring.model.Student;
import com.hardik.spring.model.Term;



@Service
public class EnrollmentServiceImpl implements EnrollmentService {
	
	private EnrollmentDAO enrollmentDAO;
	
	public void setEnrollmentDAO(EnrollmentDAO enrollmentDAO) {
		this.enrollmentDAO = enrollmentDAO;
	}

	
	@Transactional
	public void addEnrollment(Enrollment e) {
		this.enrollmentDAO.addEnrollment(e);
	}

	
	@Transactional
	public void updateEnrollment(Enrollment e) {
		this.enrollmentDAO.updateEnrollment(e);
	}

	
	@Transactional
	public List<Enrollment> listEnrollments() {
		return this.enrollmentDAO.listEnrollments();
	}

	@Transactional
	public List<Enrollment> editEnrollment(Enrollment e) {
		return this.enrollmentDAO.editEnrollment(e);
	}
	

	@Transactional
	public void removeEnrollment(Enrollment e) {
		this.enrollmentDAO.removeEnrollment(e);
	}
	
	@Transactional
	public List getCourse(Term t, Course c) {
		return this.enrollmentDAO.getCourse(t,c);
	}
	
	@Transactional
	public List getStudentList(Term t, Course c) {
		return this.enrollmentDAO.getStudentList(t, c);
	}
	
	@Transactional
	public List<Enrollment> getEnrolledCourse(Student s){
		return this.enrollmentDAO.getEnrolledCourse(s);
	}
	
	@Transactional
	public int getValidaion(Course c, Term t){
		return this.enrollmentDAO.getValidaion(c, t);
	}

}