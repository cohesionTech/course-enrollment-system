package com.hardik.spring.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hardik.spring.model.Course;
import com.hardik.spring.model.Department;
import com.hardik.spring.model.Student;
import com.hardik.spring.model.Teacher;
import com.hardik.spring.model.TeacherMap;
import com.hardik.spring.model.Term;
import com.hardik.spring.model.User;
import com.hardik.spring.service.CourseService;
import com.hardik.spring.service.TeacherMapService;
import com.hardik.spring.service.TeacherService;
import com.hardik.spring.service.TermService;
import com.hardik.spring.service.UserService;



@Controller
public class TeacherReg_Controller{
	
	private TeacherService teacherService;
	private CourseService courseService;
	private TermService termService;
	private TeacherMapService teacherMapService;
	private UserService userService;
	
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
	
	
	@RequestMapping(value = "/teacher/add", method = RequestMethod.POST)
	public String addTeacher(HttpServletRequest req) {
		
		System.out.println("inside controller");
		Teacher t=new Teacher();
		User u=new User();
		User u1=new User();
		
		String fn=req.getParameter("fn");
		String ln=req.getParameter("ln");
		String addr=req.getParameter("addr");
		String email=req.getParameter("email");
		String mobile=req.getParameter("mobile");
		String ti=req.getParameter("ti");
		String un=req.getParameter("un");
		String pwd=req.getParameter("pwd");
		String role=req.getParameter("role");
		String enable=req.getParameter("enable");
		
		System.out.println("dddddddddddddd"+mobile+fn+ln+addr+email+ti+un+pwd+role);
		
		u.setUsername(un);
		u.setPassword(pwd);
		u.setRole(role);
		u.setEnabled(Integer.parseInt(enable));
		
		this.userService.addUser(u);
		
		
		u1.setUsername(un);
		
		t.setUser(u1);
		t.setT_Firstname(fn);
		t.setT_Lastname(ln);
		t.setT_Address(addr);
		t.setT_Email(email);
		t.setT_Mobile(mobile);
		t.setT_TeachingInterest(ti);
		
		this.teacherService.addTeacher(t);
		
		return "redirect:/teacher";
	
	}
	
	
	@RequestMapping(value = "/teacherProf/edit", method = RequestMethod.GET)
	public String editTeacherProfile(Model model, HttpServletRequest req) {
	
		Teacher t=new Teacher();
		System.out.println("edit id==============="+req.getParameter("id"));
		t.setTeid(Integer.parseInt(req.getParameter("id")));
		
		System.out.println("inside edit");
		
		model.addAttribute("teacherRecord", this.teacherService.editTeacher(t));
		return "Teacher_EditProfile";
	}
	
	@RequestMapping(value = "/teacher/update", method = RequestMethod.POST)
	public String updateTeacher(HttpServletRequest req) {
		
		Teacher t=new Teacher();
		User u1=new User();
		
		String fn=req.getParameter("fn");
		String ln=req.getParameter("ln");
		String addr=req.getParameter("addr");
		String email=req.getParameter("email");
		String mobile=req.getParameter("mobile");
		String ti=req.getParameter("ti");
		String un=req.getParameter("un");
			
		u1.setUsername(un);
		t.setUser(u1);
		t.setTeid(Integer.parseInt(req.getParameter("teid")));
		t.setT_Firstname(fn);
		t.setT_Lastname(ln);
		t.setT_Address(addr);
		t.setT_Email(email);
		t.setT_Mobile(mobile);
		t.setT_TeachingInterest(ti);
			
		this.teacherService.updateTeacher(t);
		return "redirect:/teacher";
	
	
	}
	
	@RequestMapping(value = "/teachermap/show", method = RequestMethod.GET)
	public String listTeachers(Model model) {
		System.out.println("inside list method");
		model.addAttribute("teacherList", this.teacherService.listTeachers());
		return "Admin_TeacherList";
	}
	
	@RequestMapping(value = "/teachermap/detail", method = RequestMethod.GET)
	public String loadTeacher(Model model, HttpServletRequest req) {
		
		Teacher t=new Teacher();
		
		System.out.println("edit id==============="+req.getParameter("id"));
		
		t.setTeid(Integer.parseInt(req.getParameter("id")));
		model.addAttribute("termList", this.termService.listTerms());
		model.addAttribute("courseList", this.courseService.listCourses());
		model.addAttribute("teacherRecord", this.teacherService.editTeacher(t));
		
		
		return "Admin_AssignCourse";
	}
	
	
	@RequestMapping(value = "/teachermap/assign", method = RequestMethod.POST)
	public String assignCourse(HttpServletRequest req) {
		
		System.out.println("inside controller");
		TeacherMap tm=new TeacherMap();
		Teacher t=new Teacher();
		Term tr=new Term();
		Course cr=new Course();
		
		String tid=req.getParameter("tid");
		String crid=req.getParameter("crid");
		String teid=req.getParameter("teid");
		
		String fn=req.getParameter("fn");
		String ln=req.getParameter("ln");
		String mobile=req.getParameter("mobile");
		String ti=req.getParameter("ti");
		
		System.out.println("dddddddddddddd"+mobile+fn+ln+ti);
		
		t.setTeid(Integer.parseInt(teid));
		cr.setCrid(Integer.parseInt(crid));
		tr.setTid(Integer.parseInt(tid));
		
		tm.setTeacher(t);
		tm.setCourse(cr);
		tm.setTerm(tr);
		tm.setTeacher_FirstName(fn);
		tm.setTeacher_LastName(ln);
		tm.setTeacher_Mobile(mobile);
		tm.setTeacher_TeachingInterest(ti);
		
		this.teacherMapService.addTeacherMap(tm);
		 
		
		
		return "redirect:/teacher/load";
	
	}
	
	@RequestMapping(value = "/teachermap/load", method = RequestMethod.GET)
	public String listTeachermaps(Model model) {
		System.out.println("inside list method");
		model.addAttribute("teacherMapList", this.teacherMapService.listTeacherMaps());
		return "Admin_TeacherMapList";
	}
	
	@RequestMapping(value = "/teachermap/edit", method = RequestMethod.GET)
	public String editTeacherMap(Model model, HttpServletRequest req) {
		
		String id=req.getParameter("id");
		TeacherMap tm=new TeacherMap();
		System.out.println("edit id==============="+id);
		
		tm.setTmap(Integer.parseInt(id));
		model.addAttribute("termList", this.termService.listTerms());
		model.addAttribute("courseList", this.courseService.listCourses());
		model.addAttribute("teacherMapRecord", this.teacherMapService.editTeacherMap(tm));
		
		return "Admin_EditTeacherMap";
	
	}
	
	@RequestMapping(value = "/teacher/mapUpdate", method = RequestMethod.POST)
	public String updateTeacherMap(HttpServletRequest req) {
	
		System.out.println("inside controller");
		TeacherMap tm=new TeacherMap();
		Teacher t=new Teacher();
		Term tr=new Term();
		Course cr=new Course();
		
		
		String tmap=req.getParameter("tmap");
		String tid=req.getParameter("tid");
		String crid=req.getParameter("crid");
		String teid=req.getParameter("teid");
		
		String fn=req.getParameter("fn");
		String ln=req.getParameter("ln");
		String mobile=req.getParameter("mobile");
		String ti=req.getParameter("ti");
		
		System.out.println(tid+""+crid+""+teid+""+fn+""+ln+""+mobile+""+ti);
		t.setTeid(Integer.parseInt(teid));
		cr.setCrid(Integer.parseInt(crid));
		tr.setTid(Integer.parseInt(tid));
		
		tm.setTeacher(t);
		tm.setCourse(cr);
		tm.setTerm(tr);
		tm.setTmap(Integer.parseInt(tmap));
		tm.setTeacher_FirstName(fn);
		tm.setTeacher_LastName(ln);
		tm.setTeacher_Mobile(mobile);
		tm.setTeacher_TeachingInterest(ti);
		
		this.teacherMapService.updateTeacherMap(tm);
		
		return "redirect:/teachermap/load";
	
	}
	
	@RequestMapping(value = "/teachermap/remove", method = RequestMethod.GET)
	public String removeTeacherMap(HttpServletRequest req) {
	
		TeacherMap tm=new TeacherMap();
		tm.setTmap(Integer.parseInt(req.getParameter("id")));
		this.teacherMapService.removeTeacherMap(tm);
		
		return "redirect:/teachermap/load";
	}
	
	
	//check
	@RequestMapping(value = "/teacher/edit", method = RequestMethod.GET)
	public String editTeacher(Model model, HttpServletRequest req) {
		
		String id=req.getParameter("id");
		Teacher t=new Teacher();
		System.out.println("edit id==============="+id);
		
		t.setTeid(Integer.parseInt(id));
		model.addAttribute("termList", this.termService.listTerms());
		model.addAttribute("courseList", this.courseService.listCourses());
		model.addAttribute("teacherRecord", this.teacherService.editTeacher(t));
		
		return "Admin_EditTeacherMap";
	
	}
}