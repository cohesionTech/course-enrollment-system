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
@Table(name="sr_student_registration")
public class Student{
	
	@Id
	@Column(name="sid")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int sid;
	
	@ManyToOne(cascade= CascadeType.REMOVE)
	@JoinColumn(name="did")
	private Department department;
	
	@ManyToOne(cascade= CascadeType.REMOVE)
	@JoinColumn(name="username")
	private User user;
	
	private String Firstname;
	private String Lastname;
	private String Address;
	private String Email;
	private String Mobile;
	private String Degreelevel;
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getFirstname() {
		return Firstname;
	}
	public void setFirstname(String firstname) {
		Firstname = firstname;
	}
	public String getLastname() {
		return Lastname;
	}
	public void setLastname(String lastname) {
		Lastname = lastname;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getMobile() {
		return Mobile;
	}
	public void setMobile(String mobile) {
		Mobile = mobile;
	}
	
	
	public String getDegreelevel() {
		return Degreelevel;
	}
	public void setDegreelevel(String degreelevel) {
		Degreelevel = degreelevel;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
	
	
}