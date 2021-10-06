package com.hardik.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hardik.spring.dao.LocationDAO;
import com.hardik.spring.model.Course;
import com.hardik.spring.model.Location;
import com.hardik.spring.model.Teacher;



@Service
public class LocationServiceImpl implements LocationService {
	
	private LocationDAO locationDAO;

	public void setLocationDAO(LocationDAO locationDAO) {
		this.locationDAO = locationDAO;
	}


	@Transactional
	public void addLocation(Location l) {
		this.locationDAO.addLocation(l);
	}

	
	@Transactional
	public void updateLocation(Location l) {
		this.locationDAO.updateLocation(l);
	}

	
	@Transactional
	public List<Location> listLocations() {
		return this.locationDAO.listLocations();
	}

	@Transactional
	public List<Location> editLocation(Location l) {
		return this.locationDAO.editLocation(l);
	}
	

	@Transactional
	public void removeLocation(Location l) {
		this.locationDAO.removeLocation(l);
	}
	
	@Transactional
	public List<Location> getCourseLocation(Course c){
		return this.locationDAO.getCourseLocation(c);
	}
	
	@Transactional
	public List<Location> getSchedule(Teacher t){
		
		return this.locationDAO.getSchedule(t);
	}

}