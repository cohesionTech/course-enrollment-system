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
import com.hardik.spring.model.User;
import com.hardik.spring.service.DepartmentService;
import com.hardik.spring.service.StudentService;
import com.hardik.spring.service.UserService;

@Controller
public class StudentReg_Controller{
	
	private DepartmentService departmentService;
	private StudentService studentService;
	private UserService userService;
	
	@Autowired(required=true)
	@Qualifier(value="departmentService")
	public void setDepartmentService(DepartmentService ds){
		this.departmentService = ds;
	}
	
	@Autowired(required=true)
	@Qualifier(value="studentService")
	public void setStudentService(StudentService ss){
		this.studentService= ss;
	}
	
	@Autowired(required=true)
	@Qualifier(value="userService")
	public void setUserService(UserService us){
		this.userService=us;
	}
	
	
	@RequestMapping(value = "/sadd", method = RequestMethod.POST)
	public String addStudent(Model model,HttpServletRequest req) {
		
		System.out.println("inside controller");
		Department d=new Department();
		Student s=new Student();
		User u=new User();
		User u1=new User();
		
		String deid=req.getParameter("deid");
		String fn=req.getParameter("fn");
		String ln=req.getParameter("ln");
		String addr=req.getParameter("addr");
		String email=req.getParameter("email");
		String mobile=req.getParameter("mobile");
		String dl=req.getParameter("dl");
		
		String un=req.getParameter("un");
		String pwd=req.getParameter("pwd");
		String role=req.getParameter("role");
		String enable=req.getParameter("enable");
		
		System.out.println("dddddddddddddd"+mobile+deid+fn+ln+addr+email+dl);
		
		u.setUsername(un);
		u.setPassword(pwd);
		u.setRole(role);
		u.setEnabled(Integer.parseInt(enable));
		
		this.userService.addUser(u);
		
		d.setDeid(Integer.parseInt(deid));
		s.setDepartment(d);
		u1.setUsername(un);
		s.setUser(u1);
		
		s.setFirstname(fn);
		s.setLastname(ln);
		s.setAddress(addr);
		s.setEmail(email);
		s.setMobile(mobile);
		s.setDegreelevel(dl);
		
		this.studentService.addStudent(s);
		model.addAttribute("msg","You have been Successfully Registered");
		return "redirect:/student";
	
	}
	
	@RequestMapping(value = "/student/load", method = RequestMethod.GET)
	public String liststudents(Model model) {
		System.out.println("inside list method");
		model.addAttribute("studentList", this.studentService.listStudents());
		
		return "Student_ViewProfile";
	}
	
	
	@RequestMapping(value = "/student/edit", method = RequestMethod.GET)
	public String editStudentProfile(Model model, HttpServletRequest req) {
	
		Student s=new Student();
		System.out.println("edit id==============="+req.getParameter("id"));
		s.setSid(Integer.parseInt(req.getParameter("id")));
		
		System.out.println("inside edit");
		
		model.addAttribute("departmentList",this.departmentService.listDepartments());
		model.addAttribute("studentRecord", this.studentService.editStudent(s));
		return "Student_EditProfile";
	}
	
	@RequestMapping(value = "/student/update", method = RequestMethod.POST)
	public String updateStudent(HttpServletRequest req) {
		
		System.out.println("inside controller");
		Department d=new Department();
		Student s=new Student();
		User u1=new User();
		
		String deid=req.getParameter("deid");
		String fn=req.getParameter("fn");
		String ln=req.getParameter("ln");
		String addr=req.getParameter("addr");
		String email=req.getParameter("email");
		String mobile=req.getParameter("mobile");
		String dl=req.getParameter("dl");
		
		String un=req.getParameter("un");
		System.out.println("dddddddddddddd"+mobile+deid+fn+ln+addr+email+dl+un);
		
		s.setSid(Integer.parseInt(req.getParameter("sid")));
		d.setDeid(Integer.parseInt(deid));
		s.setDepartment(d);
		u1.setUsername(un);
		s.setUser(u1);
		
		s.setFirstname(fn);
		s.setLastname(ln);
		s.setAddress(addr);
		s.setEmail(email);
		s.setMobile(mobile);
		s.setDegreelevel(dl);
		
		this.studentService.updateStudent(s);;
		return "redirect:/student";
	
	
	}
}