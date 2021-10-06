package com.hardik.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hardik.spring.dao.DepartmentDAO;
import com.hardik.spring.model.Department;


@Service
public class DepartmentServiceImpl implements DepartmentService{
	
	private DepartmentDAO departmentDAO;

	public void setDepartmentDAO(DepartmentDAO departmentDAO) {
		this.departmentDAO = departmentDAO;
	}
	

	@Transactional
	public void addDepartment(Department d) {
		this.departmentDAO.addDepartment(d);
	}

	
	@Transactional
	public void updateDepartment(Department d) {
		this.departmentDAO.updateDepartment(d);
	}

	
	@Transactional
	public List<Department> listDepartments() {
		return this.departmentDAO.listDepartments();
	}
	

	@Transactional
	public List<Department> editDepartment(Department d) {
		return this.departmentDAO.editDepartment(d);
	}
	

	@Transactional
	public void removeDepartment(Department d) {
		this.departmentDAO.removeDepartment(d);
	}
	
	
}