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
import com.hardik.spring.model.Grade;
import com.hardik.spring.model.Student;
import com.hardik.spring.model.Term;
import com.hardik.spring.service.EnrollmentService;
import com.hardik.spring.service.GradeService;

@Controller
public class Grade_Controller{
	
	private GradeService gradeService;
	private EnrollmentService enrollmentService;
	
	@Autowired(required=true)
	@Qualifier(value="gradeService")
	public void setGradeService(GradeService gs){
		this.gradeService= gs;
	}
	
	@Autowired(required=true)
	@Qualifier(value="enrollmentService")
	public void setEnrollmentService(EnrollmentService es){
		this.enrollmentService = es;
	}
	
	@RequestMapping(value = "/teacher/showGrade", method = RequestMethod.GET)
	public String showStudentList(Model model, HttpServletRequest req) {
		
		Enrollment e=new Enrollment();
		
		String id=req.getParameter("id");
		System.out.println("Smap...."+id);
		
		e.setSmap(Integer.parseInt(id));
		
		model.addAttribute("enrollmentRecord", this.enrollmentService.editEnrollment(e));
		return "Teacher_AssignGrade";
	}
	
	@RequestMapping(value = "/teacher/assignGrade", method = RequestMethod.POST)
	public String assignGrade(Model model, HttpServletRequest req) {
		
		Grade g=new Grade();
		Student s=new Student();
		Term t=new Term();
		Course c=new Course();
		
		
		s.setSid(Integer.parseInt(req.getParameter("sid")));
		t.setTid(Integer.parseInt(req.getParameter("tid")));
		c.setCrid(Integer.parseInt(req.getParameter("crid")));
		
		g.setTerm(t);
		g.setStudent(s);
		g.setCourse(c);
		g.setGrade(req.getParameter("grade"));
		
		this.gradeService.addGrade(g);
		
		return "Teacher_AssignGrade";
	}
	
	@RequestMapping(value = "/teacher/showAssignedGrade", method = RequestMethod.GET)
	public String showCourse(Model model, HttpServletRequest req) {
		
		System.out.println("inside list method");
		
		Term t=new Term();
		Course c=new Course();
		t.setTid(Integer.parseInt(req.getParameter("tid")));
		c.setCrid(Integer.parseInt(req.getParameter("crid")));
		
		model.addAttribute("gradeList", this.gradeService.listGrades(c, t));
		
		return "Teacher_StudentGradeList";
	}
	
	@RequestMapping(value = "/student/showAssignedGrade", method = RequestMethod.GET)
	public String showGrades(Model model, HttpServletRequest req) {
	
		Student s=new Student();
		s.setSid(Integer.parseInt(req.getParameter("id")));
		
		model.addAttribute("gradeRecord", this.gradeService.Grades(s));
		
		return "Student_GradeList";
	}
}