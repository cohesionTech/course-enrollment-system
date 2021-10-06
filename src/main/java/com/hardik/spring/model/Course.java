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
@Table(name="sr_course")
public class Course{
	
	@Id
	@Column(name="crid")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int crid;
	
	@ManyToOne(cascade= CascadeType.REMOVE)
	@JoinColumn(name="did")
	private Department department;
	
	@ManyToOne(cascade= CascadeType.REMOVE)
	@JoinColumn(name="tid")
	private Term term;
	
	@ManyToOne(cascade= CascadeType.REMOVE)
	@JoinColumn(name="lid")
	private Location location;
	
	@ManyToOne(cascade= CascadeType.REMOVE)
	@JoinColumn(name="tsid")
	private TimeSlot timeSlot;
	
	private String courseName;
	private String courseDescription;
	public int getCrid() {
		return crid;
	}
	public void setCrid(int crid) {
		this.crid = crid;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getCourseDescription() {
		return courseDescription;
	}
	public void setCourseDescription(String courseDescription) {
		this.courseDescription = courseDescription;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public Term getTerm() {
		return term;
	}
	public void setTerm(Term term) {
		this.term = term;
	}
	
	
	
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	public TimeSlot getTimeSlot() {
		return timeSlot;
	}
	public void setTimeSlot(TimeSlot timeSlot) {
		this.timeSlot = timeSlot;
	}
	@Override
	public String toString(){
		return "id="+crid+", Coursename="+courseName+", CourseDescription="+courseDescription+", Termname="+term;
	}
	
}