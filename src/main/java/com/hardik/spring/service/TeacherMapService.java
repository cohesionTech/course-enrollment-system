package com.hardik.spring.service;

import java.util.List;

import com.hardik.spring.model.Teacher;
import com.hardik.spring.model.TeacherMap;


public interface TeacherMapService{
	
	public void addTeacherMap(TeacherMap tm);
	public void updateTeacherMap(TeacherMap tm);
	public List<TeacherMap> listTeacherMaps();
	public List<TeacherMap> editTeacherMap(TeacherMap tm);
	public void removeTeacherMap(TeacherMap tm);
	public List<TeacherMap> getAssignedCourse(Teacher t);
}