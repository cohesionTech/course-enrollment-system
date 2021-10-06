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

import com.hardik.spring.model.Course;
import com.hardik.spring.model.Department;
import com.hardik.spring.model.Location;
import com.hardik.spring.model.Term;
import com.hardik.spring.model.TimeSlot;
import com.hardik.spring.service.CourseService;
import com.hardik.spring.service.DepartmentService;
import com.hardik.spring.service.LocationService;
import com.hardik.spring.service.TermService;
import com.hardik.spring.service.TimeSlotService;




@Controller
public class Course_Controller {
	

	private TermService termService;
	private DepartmentService departmentService;
	private CourseService courseService;
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
	
	@Autowired(required=true)
	@Qualifier(value="departmentService")
	public void setDepartmentService(DepartmentService ds){
		this.departmentService = ds;
	}
	
	@Autowired(required=true)
	@Qualifier(value="termService")
	public void setTermService(TermService ts){
		this.termService = ts;
	}
	
	@Autowired(required=true)
	@Qualifier(value="courseService")
	public void setCourseService(CourseService cs){
		this.courseService = cs;
	}
	
	
	
	@RequestMapping(value = "/admin_AddCourse", method = RequestMethod.GET)
	public String showCourse(Model model) {
		System.out.println("inside list method");
		model.addAttribute("termList", this.termService.listTerms());
		model.addAttribute("departmentList", this.departmentService.listDepartments());
		model.addAttribute("locationList", this.locationService.listLocations());
		model.addAttribute("timeSlotList", this.timeSlotService.listTimeSlots());
		
		return "Admin_AddCourse";
	}
	
	@RequestMapping(value = "/course/add", method = RequestMethod.POST)
	public String addCourse(HttpServletRequest req) {
		
		System.out.println("inside controller");
		Course c=new Course();
		Term t=new Term();
		Department d=new Department();
		Location l=new Location();
		TimeSlot ts=new TimeSlot();
		
		String tid=req.getParameter("tid");
		String deid=req.getParameter("deid");
		String lid=req.getParameter("lid");
		String tsid=req.getParameter("tsid");
		
		System.out.println("term id..."+tid+" department id... "+deid);
		
		t.setTid(Integer.parseInt(tid));
		d.setDeid(Integer.parseInt(deid));
		l.setLid(Integer.parseInt(lid));
		ts.setTsid(Integer.parseInt(tsid));
		
		c.setTerm(t);
		c.setDepartment(d);
		c.setLocation(l);
		c.setTimeSlot(ts);
		
		c.setCourseName(req.getParameter("cn"));
		c.setCourseDescription(req.getParameter("cd"));
		this.courseService.addCourse(c);
		
		return "redirect:/admin_AddCourse";
		
	}
	
	@RequestMapping(value = "/course/load", method = RequestMethod.GET)
	public String listcourses(Model model1) {
		System.out.println("inside list method");
		model1.addAttribute("courseList", this.courseService.listCourses());
		
		return "Admin_ViewCourse";
	}
	
	@RequestMapping(value = "/course/edit", method = RequestMethod.GET)
	public String editCourse(Model model, HttpServletRequest req) {
		Course c=new Course();
		System.out.println("edit id==============="+req.getParameter("id"));
		c.setCrid(Integer.parseInt(req.getParameter("id")));
		System.out.println("inside edit");
		model.addAttribute("courseRecord",this.courseService.editCourse(c));
		
		model.addAttribute("departmentList",this.departmentService.listDepartments());
		model.addAttribute("termList",this.termService.listTerms());
		model.addAttribute("locationList", this.locationService.listLocations());
		model.addAttribute("timeSlotList", this.timeSlotService.listTimeSlots());
		
		return "Admin_EditCourse";
	}
	
	@RequestMapping(value = "/course/update", method = RequestMethod.POST)
	public String updateCourse(HttpServletRequest req) {
		
		System.out.println("inside update");
		Course c=new Course();
		Department d=new Department();
		Term t=new Term();
		Location l=new Location();
		TimeSlot ts=new TimeSlot();
		
		String crid=req.getParameter("crid");
		System.out.println("edit id==============="+crid);
		
		
		String tid=req.getParameter("tid");
		String deid=req.getParameter("deid");
		String lid=req.getParameter("lid");
		String tsid=req.getParameter("tsid");
		
		System.out.println("term id..."+tid+" department id... "+deid);
		
		t.setTid(Integer.parseInt(tid));
		d.setDeid(Integer.parseInt(deid));
		l.setLid(Integer.parseInt(lid));
		ts.setTsid(Integer.parseInt(tsid));
		
		c.setTerm(t);
		c.setDepartment(d);
		c.setLocation(l);
		c.setTimeSlot(ts);
		
		c.setCrid(Integer.parseInt(crid));
		c.setCourseName(req.getParameter("cn"));
		c.setCourseDescription(req.getParameter("cd"));
		this.courseService.updateCourse(c);
		
		return "redirect:/course/load";
		
	}
	
	@RequestMapping(value="/course/remove", method=RequestMethod.GET)
    public String removeDepartment(HttpServletRequest req){
		
		System.out.println("inside remove");
		Course c=new Course();
		
		System.out.println("remove id==============="+req.getParameter("id"));
		c.setCrid(Integer.parseInt(req.getParameter("id")));
		this.courseService.removeCourse(c);;
       
        return "redirect:/course/load";
    }
	
	
	@RequestMapping(value="/course/term", method=RequestMethod.POST)
    public void getCourse(HttpServletRequest req){
	
		System.out.println("AJAX....");
		
	}
	
		
	
}