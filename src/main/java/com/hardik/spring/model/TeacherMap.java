package com.hardik.spring.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="sr_map_teacher")
public class TeacherMap{
	
	@Id
	@Column(name="tmap")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int tmap;
	
	@ManyToOne(cascade= CascadeType.REMOVE)
	@JoinColumn(name="tid")
	private Term term;
	
	@ManyToOne(cascade= CascadeType.REMOVE)
	@JoinColumn(name="crid")
	private Course course;
	
	@ManyToOne(cascade= CascadeType.REMOVE)
	@JoinColumn(name="teid")
	private Teacher teacher;
	
	private String Teacher_FirstName;
	private String Teacher_LastName;
	private String Teacher_Mobile;
	private String Teacher_TeachingInterest;
	public int getTmap() {
		return tmap;
	}
	public void setTmap(int tmap) {
		this.tmap = tmap;
	}
	public Term getTerm() {
		return term;
	}
	public void setTerm(Term term) {
		this.term = term;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	public String getTeacher_FirstName() {
		return Teacher_FirstName;
	}
	public void setTeacher_FirstName(String teacher_FirstName) {
		Teacher_FirstName = teacher_FirstName;
	}
	public String getTeacher_LastName() {
		return Teacher_LastName;
	}
	public void setTeacher_LastName(String teacher_LastName) {
		Teacher_LastName = teacher_LastName;
	}
	public String getTeacher_Mobile() {
		return Teacher_Mobile;
	}
	public void setTeacher_Mobile(String teacher_Mobile) {
		Teacher_Mobile = teacher_Mobile;
	}
	public String getTeacher_TeachingInterest() {
		return Teacher_TeachingInterest;
	}
	public void setTeacher_TeachingInterest(String teacher_TeachingInterest) {
		Teacher_TeachingInterest = teacher_TeachingInterest;
	}	
	
	
	
}