package com.hardik.spring.service;

import java.util.List;

import com.hardik.spring.model.Course;
import com.hardik.spring.model.Location;
import com.hardik.spring.model.Teacher;


public interface LocationService{
	
	public void addLocation(Location l);
	public void updateLocation(Location l);
	public List<Location> listLocations();
	public List<Location> editLocation(Location l);
	public void removeLocation(Location l);
	public List<Location> getCourseLocation(Course c);
	public List<Location> getSchedule(Teacher t);
	
}