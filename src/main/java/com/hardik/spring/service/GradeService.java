package com.hardik.spring.service;

import java.util.List;

import com.hardik.spring.model.Course;
import com.hardik.spring.model.Grade;
import com.hardik.spring.model.Student;
import com.hardik.spring.model.Term;


public interface GradeService{
	
	public void addGrade(Grade g);
	public void updateGrade(Grade g);
	public List<Grade> listGrades(Course c, Term t);
	public List<Grade> editGrade(Grade g);
	public void removeGrade(Grade g);
	public List<Grade> Grades(Student s);
}