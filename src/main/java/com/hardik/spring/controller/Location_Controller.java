package com.hardik.spring.controller;

import javax.servlet.http.HttpServletRequest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hardik.spring.model.Location;
import com.hardik.spring.model.TimeSlot;
import com.hardik.spring.service.LocationService;
import com.hardik.spring.service.TimeSlotService;

@Controller
public class Location_Controller{
	
	private LocationService locationService;
	private TimeSlotService timeSlotService;
	
	@Autowired(required=true)
	@Qualifier(value="locationService")
	public void setLocationService(LocationService ls){
		this.locationService = ls;
	}
	
	@Autowired(required=true)
	@Qualifier(value="timeSlotService")
	public void setTimeSlotService(TimeSlotService tss){
		this.timeSlotService = tss;
	}
	
	@RequestMapping(value = "/admin_AddLocation", method = RequestMethod.GET)
	public String showCourse(Model model) {
		System.out.println("inside list method");
		
		return "Admin_AllocateClass";
	}
	
	@RequestMapping(value = "/location/add", method = RequestMethod.POST)
	public String addlocation(HttpServletRequest req) {
		
		System.out.println("inside controller");
		Location l=new Location();
		
		
		l.setLectureHall(req.getParameter("lh"));
		l.setLhDescription(req.getParameter("lhd"));
		
		this.locationService.addLocation(l);
		return "redirect:/admin_AddLocation";
	}
	
	@RequestMapping(value = "/location/load", method = RequestMethod.GET)
	public String listlocations(Model model) {
		System.out.println("inside list method");
		model.addAttribute("locationList", this.locationService.listLocations());
		
		return "Admin_ViewLocation";
	}
	
	@RequestMapping(value = "/location/edit", method = RequestMethod.GET)
	public String editLocation(Model model, HttpServletRequest req) {
		Location l=new Location();
		System.out.println("edit id==============="+req.getParameter("id"));
		l.setLid(Integer.parseInt(req.getParameter("id")));
		System.out.println("inside edit");
		model.addAttribute("locationRecord",this.locationService.editLocation(l));
		
		return "Admin_EditLocation";
	}
	
	@RequestMapping(value = "/location/update", method = RequestMethod.POST)
	public String updatelocation(HttpServletRequest req) {
		
		System.out.println("inside controller");
		Location l=new Location();
		
		l.setLid(Integer.parseInt(req.getParameter("lid")));

		l.setLectureHall(req.getParameter("lh"));
		l.setLhDescription(req.getParameter("lhd"));
		
		this.locationService.updateLocation(l);
		return "redirect:/location/load";
	}
	
	@RequestMapping(value="/location/remove", method=RequestMethod.GET)
    public String removeLocation(HttpServletRequest req){
		
		System.out.println("inside remove");
		Location l=new Location();
		
		System.out.println("remove id==============="+req.getParameter("id"));
		l.setLid(Integer.parseInt(req.getParameter("id")));
		this.locationService.removeLocation(l);
       
        return "redirect:/location/load";
    }
	
	

	@RequestMapping(value = "/admin_AddTimeSlot", method = RequestMethod.GET)
	public String showTime(Model model) {
		System.out.println("inside list method");
		
		return "Admin_AddTimeSlot";
	}
	
	@RequestMapping(value = "/time/add", method = RequestMethod.POST)
	public String addTime(HttpServletRequest req) {
		
		System.out.println("inside controller");
		TimeSlot ts=new TimeSlot();
		
		ts.setTimeSlot(req.getParameter("ts"));
		ts.setTsDescription(req.getParameter("tsd"));
		
		this.timeSlotService.addTimeSlot(ts);
		return "redirect:/admin_AddTimeSlot";
	}
	
	@RequestMapping(value = "/time/load", method = RequestMethod.GET)
	public String listTimes(Model model) {
		System.out.println("inside list method");
		model.addAttribute("timeSlotList", this.timeSlotService.listTimeSlots());
		
		return "Admin_ViewTimeSlot";
	}
	
	@RequestMapping(value = "/time/edit", method = RequestMethod.GET)
	public String editTimeSlot(Model model, HttpServletRequest req) {
		
		TimeSlot ts=new TimeSlot();
		System.out.println("edit id==============="+req.getParameter("id"));
		ts.setTsid(Integer.parseInt(req.getParameter("id")));
		System.out.println("inside edit");
		model.addAttribute("timeSlotRecord",this.timeSlotService.editTimeSlot(ts));
		
		return "Admin_EditTimeSlot";
	}
	
	@RequestMapping(value = "/time/update", method = RequestMethod.POST)
	public String updateTime(HttpServletRequest req) {
		
		System.out.println("inside controller");
		TimeSlot ts=new TimeSlot();
		
		ts.setTsid(Integer.parseInt(req.getParameter("tsid")));

		ts.setTimeSlot(req.getParameter("ts"));
		ts.setTsDescription(req.getParameter("tsd"));
		
		this.timeSlotService.updateTimeSlot(ts);
		return "redirect:/time/load";
	}
	
	@RequestMapping(value="/time/remove", method=RequestMethod.GET)
    public String removeTime(HttpServletRequest req){
		
		System.out.println("inside remove");
		TimeSlot ts=new TimeSlot();
		System.out.println("remove id==============="+req.getParameter("id"));
		ts.setTsid(Integer.parseInt(req.getParameter("id")));
		this.timeSlotService.removeTimeSlot(ts);
       
        return "redirect:/time/load";
    }
}