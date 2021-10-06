package com.hardik.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hardik.spring.dao.TimeSlotDAO;
import com.hardik.spring.model.TimeSlot;


@Service
public class TimeSlotServiceImpl implements TimeSlotService {
	
	private TimeSlotDAO timeSlotDAO;

	public void setTimeSlotDAO(TimeSlotDAO timeSlotDAO) {
		this.timeSlotDAO = timeSlotDAO;
	}


	@Transactional
	public void addTimeSlot(TimeSlot ts) {
		this.timeSlotDAO.addTimeSlot(ts);
	}

	
	@Transactional
	public void updateTimeSlot(TimeSlot ts) {
		this.timeSlotDAO.updateTimeSlot(ts);
	}

	
	@Transactional
	public List<TimeSlot> listTimeSlots() {
		return this.timeSlotDAO.listTimeSlots();
	}

	@Transactional
	public List<TimeSlot> editTimeSlot(TimeSlot ts) {
		return this.timeSlotDAO.editTimeSlot(ts);
	}
	

	@Transactional
	public void removeTimeSlot(TimeSlot ts) {
		this.timeSlotDAO.removeTimeSlot(ts);
	}

}