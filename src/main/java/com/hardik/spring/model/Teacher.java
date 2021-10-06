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
@Table(name="sr_teacher_registration")
public class Teacher{
	@Id
	@Column(name="teid")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int teid;
	private String T_Firstname;
	private String T_Lastname;
	private String T_Address;
	private String T_Email;
	private String T_Mobile;
	private String T_TeachingInterest;	
	
	@ManyToOne(cascade= CascadeType.REMOVE)
	@JoinColumn(name="username")
	private User user;
	
	public int getTeid() {
		return teid;
	}
	public void setTeid(int teid) {
		this.teid = teid;
	}
	public String getT_Firstname() {
		return T_Firstname;
	}
	public void setT_Firstname(String t_Firstname) {
		T_Firstname = t_Firstname;
	}
	public String getT_Lastname() {
		return T_Lastname;
	}
	public void setT_Lastname(String t_Lastname) {
		T_Lastname = t_Lastname;
	}
	public String getT_Address() {
		return T_Address;
	}
	public void setT_Address(String t_Address) {
		T_Address = t_Address;
	}
	public String getT_Email() {
		return T_Email;
	}
	public void setT_Email(String t_Email) {
		T_Email = t_Email;
	}
	public String getT_Mobile() {
		return T_Mobile;
	}
	public void setT_Mobile(String t_Mobile) {
		T_Mobile = t_Mobile;
	}
	public String getT_TeachingInterest() {
		return T_TeachingInterest;
	}
	public void setT_TeachingInterest(String t_TeachingInterest) {
		T_TeachingInterest = t_TeachingInterest;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
	
}