package com.hardik.spring.service;

import java.util.List;

import com.hardik.spring.model.TimeSlot;

public interface TimeSlotService{
	
	public void addTimeSlot(TimeSlot ts);
	public void updateTimeSlot(TimeSlot ts);
	public List<TimeSlot> listTimeSlots();
	public List<TimeSlot> editTimeSlot(TimeSlot ts);
	public void removeTimeSlot(TimeSlot ts);
}