package com.hardik.spring.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="sr_grade")
public class Grade{
	
	@Id
	@Column(name="gid")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int gid;

	@ManyToOne(cascade= CascadeType.REMOVE)
	@JoinColumn(name="crid")
	private Course course;
	
	@ManyToOne(cascade= CascadeType.REMOVE)
	@JoinColumn(name="tid")
	private Term term;
	
	@ManyToOne(cascade= CascadeType.REMOVE)
	@JoinColumn(name="sid")
	private Student student;
	
	private String grade;

	public int getGid() {
		return gid;
	}

	public void setGid(int gid) {
		this.gid = gid;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Term getTerm() {
		return term;
	}

	public void setTerm(Term term) {
		this.term = term;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	
}