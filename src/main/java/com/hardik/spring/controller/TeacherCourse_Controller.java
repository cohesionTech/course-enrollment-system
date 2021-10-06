package com.hardik.spring.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hardik.spring.model.Course;
import com.hardik.spring.model.Teacher;
import com.hardik.spring.model.TeacherMap;
import com.hardik.spring.model.Term;
import com.hardik.spring.service.CourseService;
import com.hardik.spring.service.EnrollmentService;
import com.hardik.spring.service.LocationService;
import com.hardik.spring.service.TeacherMapService;
import com.hardik.spring.service.TeacherService;
import com.hardik.spring.service.TermService;
import com.hardik.spring.service.UserService;

@Controller
public class TeacherCourse_Controller{
	
	private TeacherService teacherService;
	private CourseService courseService;
	private TermService termService;
	private TeacherMapService teacherMapService;
	private UserService userService;
	private EnrollmentService enrollmentService;
	private LocationService locationService;
	
	@Autowired(required=true)
	@Qualifier(value="teacherService")
	public void setTeacherService(TeacherService ts){
		this.teacherService= ts;
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
	
	@Autowired(required=true)
	@Qualifier(value="teacherMapService")
	public void setTeacherMapService(TeacherMapService tms){
		this.teacherMapService=tms;
	}
	
	@Autowired(required=true)
	@Qualifier(value="userService")
	public void setUserService(UserService us){
		this.userService=us;
	}
	
	@Autowired(required=true)
	@Qualifier(value="enrollmentService")
	public void setEnrollmentService(EnrollmentService es){
		this.enrollmentService = es;
	}
	
	@Autowired(required=true)
	@Qualifier(value="locationService")
	public void setLocationService(LocationService ls){
		this.locationService = ls;
	}
	
	@RequestMapping(value = "/teacher/schedule", method = RequestMethod.GET)
	public String showSchedule(Model model, HttpServletRequest req) {
		
		Teacher t=new Teacher();
		
		String id=req.getParameter("id");
		t.setTeid(Integer.parseInt(id));
		
		model.addAttribute("teacherMapRecord", this.teacherMapService.getAssignedCourse(t));
		return "Teacher_Schedule";
		
	}
	
	//Ref. to student List
	@RequestMapping(value = "/teacher/showCourses", method = RequestMethod.GET)
	public String showCourse(Model model, HttpServletRequest req) {
		
		Teacher t=new Teacher();
		TeacherMap tm=new TeacherMap();
		
		String id=req.getParameter("id");
		t.setTeid(Integer.parseInt(id));
		
		model.addAttribute("teacherMapRecord", this.teacherMapService.getAssignedCourse(t));
		return "Teacher_ShowCourse";
		
	}
	
	//Ref. to student Grade
	@RequestMapping(value = "/teacher/showGradeCourses", method = RequestMethod.GET)
	public String showGradeCourse(Model model, HttpServletRequest req) {
		
		Teacher t=new Teacher();
		TeacherMap tm=new TeacherMap();
		
		String id=req.getParameter("id");
		t.setTeid(Integer.parseInt(id));
		
		model.addAttribute("teacherMapRecord", this.teacherMapService.getAssignedCourse(t));
		return "Teacher_ShowGradeCourse";
		
	}
	
	@RequestMapping(value = "/teacher/showStudentList", method = RequestMethod.GET)
	public String showStudentList(Model model, HttpServletRequest req) {
		
		Course c=new Course();
		Term t=new Term();
		
		String tid=req.getParameter("tid");
		String crid=req.getParameter("crid");
		
		System.out.println("Term and Course...."+tid+".."+crid);
		
		c.setCrid(Integer.parseInt(crid));
		t.setTid(Integer.parseInt(tid));
		
		model.addAttribute("studentList", this.enrollmentService.getStudentList(t, c));
		return "Teacher_StudentList";
	}
	
	@RequestMapping(value = "/teacher/showGradeStudentList", method = RequestMethod.GET)
	public String showGradeStudentList(Model model, HttpServletRequest req) {
		
		Course c=new Course();
		Term t=new Term();
		
		String tid=req.getParameter("tid");
		String crid=req.getParameter("crid");
		
		System.out.println("Term and Course...."+tid+".."+crid);
		
		c.setCrid(Integer.parseInt(crid));
		t.setTid(Integer.parseInt(tid));
		
		model.addAttribute("studentList", this.enrollmentService.getStudentList(t, c));
		return "Teacher_ShowStudentList";
	}
	
	//Ref. to drop student
	@RequestMapping(value = "/teacher/showCourseList", method = RequestMethod.GET)
	public String showCourseList(Model model, HttpServletRequest req) {
		
		Teacher t=new Teacher();
		
		String id=req.getParameter("id");
		t.setTeid(Integer.parseInt(id));
		
		model.addAttribute("teacherMapRecord", this.teacherMapService.getAssignedCourse(t));
		return "Teacher_ShowDrop";
		
	}
	

	@RequestMapping(value = "/teacher/showDropStudentList", method = RequestMethod.GET)
	public String showDropStudentList(Model model, HttpServletRequest req) {
		
		Course c=new Course();
		Term t=new Term();
		
		String tid=req.getParameter("tid");
		String crid=req.getParameter("crid");
		
		System.out.println("Term and Course...."+tid+".."+crid);
		
		c.setCrid(Integer.parseInt(crid));
		t.setTid(Integer.parseInt(tid));
		
		model.addAttribute("studentList", this.enrollmentService.getStudentList(t, c));
		return "Teacher_ShowDropStudentList";
	}
	
	//Currently in use
	@RequestMapping(value = "/teacher/courseSchdule", method = RequestMethod.GET)
	public String showTeacherSchedule(Model model, HttpServletRequest req) {
		
		Course c=new Course();
		
		String crid=req.getParameter("id");
		
		System.out.println("Course...."+crid);
		
		c.setCrid(Integer.parseInt(crid));
		
		
		model.addAttribute("locationRecord", this.locationService.getCourseLocation(c));
		return "Teacher_Schedule";
	}
	
	/*@RequestMapping(value = "/teacher/schedules", method = RequestMethod.GET)
	public String showSchedule(Model model, HttpServletRequest req) {
		
		Teacher t=new Teacher();
		String tid=req.getParameter("id");
		
		System.out.println("Teacher...."+tid);
		t.setTeid(Integer.parseInt(tid));
		
		
		model.addAttribute("locationRecord", this.locationService.getSchedule(t));
		return "Teacher_Schedule";
	}*/
}