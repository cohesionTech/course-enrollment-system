package com.hardik.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="sr_department")
public class Department{
	
	@Id
	@Column(name="did")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int deid;
	
	private String DepartmentName;
	private String DepartmentDescription;
	
	public int getDeid() {
		return deid;
	}
	public void setDeid(int deid) {
		this.deid = deid;
	}
	public String getDepartmentName() {
		return DepartmentName;
	}
	public void setDepartmentName(String departmentName) {
		DepartmentName = departmentName;
	}
	public String getDepartmentDescription() {
		return DepartmentDescription;
	}
	public void setDepartmentDescription(String departmentDescription) {
		DepartmentDescription = departmentDescription;
	}
	
	@Override
	public String toString(){
		return "id="+deid+", Departmentname="+DepartmentName+", DepartmentDescription="+DepartmentDescription;
	}
	
	
	
}