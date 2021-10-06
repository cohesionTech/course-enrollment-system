package com.hardik.spring.dao;

import java.util.List;

import com.hardik.spring.model.Department;

public interface DepartmentDAO{
	
	public void addDepartment(Department d);
	public void updateDepartment(Department d);
	public List<Department> listDepartments();
	public List<Department> editDepartment(Department d);
	public void removeDepartment(Department d);
}