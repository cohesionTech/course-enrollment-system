package com.hardik.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hardik.spring.dao.TeacherMapDAO;
import com.hardik.spring.model.Teacher;
import com.hardik.spring.model.TeacherMap;



@Service
public class TeacherMapServiceImpl implements TeacherMapService {
	
	private TeacherMapDAO teacherMapDAO;

	public void setTeacherMapDAO(TeacherMapDAO teacherMapDAO) {
		this.teacherMapDAO = teacherMapDAO;
	}

	
	@Transactional
	public void addTeacherMap(TeacherMap tm) {
		System.out.println("inside service");
		this.teacherMapDAO.addTeacherMap(tm);
	}

	
	@Transactional
	public void updateTeacherMap(TeacherMap tm) {
		this.teacherMapDAO.updateTeacherMap(tm);
	}

	
	@Transactional
	public List<TeacherMap> listTeacherMaps() {
		return this.teacherMapDAO.listTeacherMaps();
	}

	@Transactional
	public List<TeacherMap> editTeacherMap(TeacherMap tm) {
		return this.teacherMapDAO.editTeacherMap(tm);
	}
	

	@Transactional
	public void removeTeacherMap(TeacherMap tm) {
		this.teacherMapDAO.removeTeacherMap(tm);
	}
	
	@Transactional
	public List<TeacherMap> getAssignedCourse(Teacher t){
		return this.teacherMapDAO.getAssignedCourse(t);
	}

}