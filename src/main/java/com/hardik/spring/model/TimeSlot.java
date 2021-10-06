package com.hardik.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="sr_time")
public class TimeSlot{
	
	@Id
	@Column(name="tsid")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int tsid;
	
	private String timeSlot;
	private String tsDescription;
	
	public int getTsid() {
		return tsid;
	}
	public void setTsid(int tsid) {
		this.tsid = tsid;
	}
	public String getTimeSlot() {
		return timeSlot;
	}
	public void setTimeSlot(String timeSlot) {
		this.timeSlot = timeSlot;
	}
	public String getTsDescription() {
		return tsDescription;
	}
	public void setTsDescription(String tsDescription) {
		this.tsDescription = tsDescription;
	}
	
	
	
}