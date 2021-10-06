package com.hardik.spring.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hardik.spring.model.Course;
import com.hardik.spring.model.Enrollment;
import com.hardik.spring.model.Student;
import com.hardik.spring.model.Term;
import com.hardik.spring.service.CourseService;
import com.hardik.spring.service.EnrollmentService;
import com.hardik.spring.service.TermService;

@Controller
public class Enrollment_Controller{
	
	private TermService termService;
	
	private CourseService courseService;
	private EnrollmentService enrollmentService;
	
	
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
	@Qualifier(value="enrollmentService")
	public void setEnrollmentService(EnrollmentService es){
		this.enrollmentService = es;
	}
	
	
	@RequestMapping(value = "/student/showAddCourse", method = RequestMethod.GET)
	public String showCourse(Model model) {
		System.out.println("inside list method");
		model.addAttribute("termList", this.termService.listTerms());
		model.addAttribute("courseList", this.courseService.listCourses());
		
		return "Student_AddCourse";
	}
	
	@RequestMapping(value = "/student/AddCourse", method = RequestMethod.POST)
	public String showEnroll(Model model, HttpServletRequest req) {
		
		String tid= req.getParameter("tid");
		String crid= req.getParameter("crid");
		
		Term t=new Term();
		Course c=new Course();
		
		t.setTid(Integer.parseInt(tid));
		c.setCrid(Integer.parseInt(crid));
		
		int i=this.enrollmentService.getValidaion(c, t);
		System.out.println(".........now"+i);
		
		if(i<=20)
		{
		model.addAttribute("courseRecord", this.enrollmentService.getCourse(t, c));
		}
		
		
		//model.addAttribute("locationRecord", this.locationService.getCourseLocation(c));
		
		return "Student_EnrollCourse";
		
		
	
	}
	
	@RequestMapping(value = "/student/enrollCourse", method = RequestMethod.POST)
	public String enrollCourse(HttpServletRequest req) {
		
		System.out.println("inside controller");
		Course c=new Course();
		Term t=new Term();
		Student s=new Student();
		Enrollment e=new Enrollment();
		
		String tid=req.getParameter("term");
		String crid=req.getParameter("course");
		String sid=req.getParameter("sid");
		System.out.println("term id..."+tid+" department id... "+crid+"student id......"+sid);
		
		t.setTid(Integer.parseInt(tid));
		c.setCrid(Integer.parseInt(crid));
		s.setSid(Integer.parseInt(sid));
		
		e.setCourse(c);
		e.setStudent(s);
		e.setTerm(t);
		
		this.enrollmentService.addEnrollment(e);
		
		
		return "redirect:/student/showAddCourse";
		
	}
	
	@RequestMapping(value = "/student/dropCourse", method = RequestMethod.GET)
	public String dropCourse(HttpServletRequest req) {
	
		Enrollment e=new Enrollment();
		e.setSmap(Integer.parseInt(req.getParameter("smap")));
		this.enrollmentService.removeEnrollment(e);
		
		return "redirect:/student/schedule";
	}
	
	@RequestMapping(value = "/teacher/dropStudent", method = RequestMethod.GET)
	public String dropStudent(HttpServletRequest req) {
	
		Enrollment e=new Enrollment();
		e.setSmap(Integer.parseInt(req.getParameter("id")));
		this.enrollmentService.removeEnrollment(e);
		
		return "redirect:/teacher/showDropStudentList";
	}
	
	@RequestMapping(value = "/student/showDrop", method = RequestMethod.GET)
	public String showdropCourse(Model model, HttpServletRequest req) {
		
		Student s=new Student();
		
		s.setSid(Integer.parseInt(req.getParameter("id")));
		
		model.addAttribute("enrollmentRecord",this.enrollmentService.getEnrolledCourse(s));
		return "Student_DropCourse";
	}
	
	
	@RequestMapping(value = "/student/schedule", method = RequestMethod.GET)
	public String showStudentSchedule(Model model, HttpServletRequest req) {
		
		Student s=new Student();
		
		s.setSid(Integer.parseInt(req.getParameter("id")));
		
		model.addAttribute("enrollmentRecord",this.enrollmentService.getEnrolledCourse(s));
		return "Student_Schedule";
	}
	
	
}