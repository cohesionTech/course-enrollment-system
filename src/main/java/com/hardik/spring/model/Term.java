package com.hardik.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="sr_term")
public class Term{
	
	@Id
	@Column(name="tid")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int tid;
	
	private String termName;
	private String termDescription;
	
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public String getTermName() {
		return termName;
	}
	public void setTermName(String termName) {
		this.termName = termName;
	}
	public String getTermDescription() {
		return termDescription;
	}
	public void setTermDescription(String termDescription) {
		this.termDescription = termDescription;
	}
	

	@Override
	public String toString(){
		return "id="+tid+", Termname="+termName+", TermDescription="+termDescription;
	}
	
}