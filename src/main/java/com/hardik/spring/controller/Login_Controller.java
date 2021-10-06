package com.hardik.spring.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hardik.spring.model.User;
import com.hardik.spring.service.DepartmentService;
import com.hardik.spring.service.StudentService;
import com.hardik.spring.service.TeacherService;

@Controller
public class Login_Controller{

	private TeacherService teacherService;
	private StudentService studentService;
	private DepartmentService departmentService;

	
	@Autowired(required=true)
	@Qualifier(value="teacherService")
	public void setTeacherService(TeacherService ts){
		this.teacherService= ts;
	}
	
	@Autowired(required=true)
	@Qualifier(value="studentService")
	public void setStudentService(StudentService ss){
		this.studentService= ss;
	}
	
	@Autowired(required=true)
	@Qualifier(value="departmentService")
	public void setDepartmentService(DepartmentService ds){
		this.departmentService = ds;
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(Model model ) {
		System.out.println("inside login");
         
        return "LoginPage";
    }
 
    @RequestMapping(value = "/logoutSuccessful", method = RequestMethod.GET)
    public String logoutSuccessfulPage(Model model) {
        model.addAttribute("title", "You have been successfully logged out");
        return "Role";
    }
    
    @RequestMapping(value = "/registration", method = RequestMethod.GET)
	public ModelAndView showIndex1() {
    	
		return new ModelAndView("Registration");
	}
    
    @RequestMapping(value = "/sregistration", method = RequestMethod.GET)
	public String showRegPage(Model model) {
		System.out.println("inside list method");
		model.addAttribute("departmentList", this.departmentService.listDepartments());
		
		return "Student_Registration";
	}
	
    
    @RequestMapping(value = "/tregistration", method = RequestMethod.GET)
	public ModelAndView showIndex3() {
    	
		return new ModelAndView("Teacher_Registration");
	}
    
    @RequestMapping(value = "/studentHome", method = RequestMethod.GET)
	public ModelAndView sHome() {
    	
		return new ModelAndView("Student_Home");
	}
    
    @RequestMapping(value = "/teacherHome", method = RequestMethod.GET)
	public ModelAndView tHome() {
    	
		return new ModelAndView("Teacher_Home");
	}
    
    @RequestMapping(value = "/teacher", method = RequestMethod.GET)
	public String showTeacher(Model model, Principal principal, HttpServletRequest req) {

    	HttpSession session= req.getSession();
    	
    	System.out.println("inside show teacher");
    	String userName = principal.getName();
    	System.out.println("User Name: "+ userName);
        User u=new User();
        u.setUsername(userName);
        //System.out.println("iuiuiuj"+u.getUsername());
       // model.addAttribute("teacherProfRecord",this.teacherService.getTeacher(u));
        session.setAttribute("teacherProfRecord",this.teacherService.getTeacher(u));
        
        System.out.println("Login Done");
        
        return "Teacher_profile";
    	
    }
    @RequestMapping(value = "/student", method = RequestMethod.GET)
	public String showStudent(Model model, Principal principal, HttpServletRequest req) {
    	
    	HttpSession session= req.getSession();

    	System.out.println("inside show teacher");
    	String userName = principal.getName();
    	System.out.println("User Name: "+ userName);
        User u=new User();
        u.setUsername(userName);
        //model.addAttribute("studentProfRecord",this.studentService.getStudent(u));
        session.setAttribute("studentSession", this.studentService.getStudent(u));
        System.out.println("Login Done");
        
        return "Student_Profile";
    	
    }
 
    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public String accessDenied(Model model, Principal principal) {
         
        if (principal != null) {
            model.addAttribute("message", "Hi " + principal.getName()
                    + "<br> You do not have permission to access this page!");
        } else {
            model.addAttribute("msg",
                    "You do not have permission to access this page!");
        }
        return "403Page";
    }
	
}