package com.hardik.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="sr_location")
public class Location{
	
	@Id
	@Column(name="lid")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int lid;
	
	private String lectureHall;
	private String lhDescription;
	public int getLid() {
		return lid;
	}
	public void setLid(int lid) {
		this.lid = lid;
	}
	
	public String getLectureHall() {
		return lectureHall;
	}
	public void setLectureHall(String lectureHall) {
		this.lectureHall = lectureHall;
	}
	
	
	public String getLhDescription() {
		return lhDescription;
	}
	public void setLhDescription(String lhDescription) {
		this.lhDescription = lhDescription;
	}
	
	@Override
	public String toString(){
		return "id="+lid+", LectureHall="+lectureHall+", Decription="+lhDescription;
	}
}