package com.hardik.spring.service;

import java.util.List;

import com.hardik.spring.model.Department;



public interface DepartmentService{
	
	public void addDepartment(Department d);
	public void updateDepartment(Department d);
	public List<Department> listDepartments();
	public List<Department> editDepartment(Department d);
	public void removeDepartment(Department d);
}