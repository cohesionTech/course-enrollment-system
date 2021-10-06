package com.hardik.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hardik.spring.dao.GradeDAO;
import com.hardik.spring.model.Course;
import com.hardik.spring.model.Grade;
import com.hardik.spring.model.Student;
import com.hardik.spring.model.Term;



@Service
public class GradeServiceImpl implements GradeService {
	
	private GradeDAO gradeDAO;

	public void setGradeDAO(GradeDAO gradeDAO) {
		this.gradeDAO = gradeDAO;
	}


	@Transactional
	public void addGrade(Grade g) {
		this.gradeDAO.addGrade(g);
	}

	
	@Transactional
	public void updateGrade(Grade g) {
		this.gradeDAO.updateGrade(g);
	}

	
	@Transactional
	public List<Grade> listGrades(Course c, Term t) {
		return this.gradeDAO.listGrades(c,t);
	}
	
	@Transactional
	public List<Grade> Grades(Student s){
		return this.gradeDAO.Grades(s);
	}

	@Transactional
	public List<Grade> editGrade(Grade g) {
		return this.gradeDAO.editGrade(g);
	}
	

	@Transactional
	public void removeGrade(Grade g) {
		this.gradeDAO.removeGrade(g);
	}

}