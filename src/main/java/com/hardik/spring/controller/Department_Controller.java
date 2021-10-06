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

import com.hardik.spring.model.Department;
import com.hardik.spring.service.DepartmentService;




@Controller
public class Department_Controller {
	

	private DepartmentService departmentService;
	
	@Autowired(required=true)
	@Qualifier(value="departmentService")
	public void setDepartmentService(DepartmentService ds){
		this.departmentService = ds;
	}
	
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public ModelAndView showIndex() {
		System.out.println("inside");
		return new ModelAndView("Admin_Home");
	}
	
	@RequestMapping(value = "/admin_Add_Department", method = RequestMethod.GET)
	public ModelAndView showDpartment() {
		
		return new ModelAndView("Admin_AddDepartment");
	}
	
	@RequestMapping(value = "/department/add", method = RequestMethod.POST)
	public String addDepartment(HttpServletRequest req) {
		
		System.out.println("inside controller");
		Department d=new Department();
		
		d.setDepartmentName(req.getParameter("dn"));
		d.setDepartmentDescription(req.getParameter("dd"));
		this.departmentService.addDepartment(d);
		
		return "redirect:/admin_Add_Department";
		
	}
	
	@RequestMapping(value = "/department/load", method = RequestMethod.GET)
	public String listDepartments(Model model1) {
		System.out.println("inside list method");
		model1.addAttribute("departmentList", this.departmentService.listDepartments());
		
		return "Admin_ViewDepartment";
	}
	
	@RequestMapping(value = "/department/edit", method = RequestMethod.GET)
	public String editDepartment(Model model, HttpServletRequest req) {
		Department d=new Department();
		System.out.println("edit id==============="+req.getParameter("id"));
		d.setDeid(Integer.parseInt(req.getParameter("id")));
		System.out.println("inside edit");
		model.addAttribute("departmentRecord",this.departmentService.editDepartment(d));
		
		return "Admin_EditDepartment";
	}
	
	@RequestMapping(value = "/department/update", method = RequestMethod.POST)
	public String updateDepartment(HttpServletRequest req) {
		
		System.out.println("inside update");
		Department d=new Department();
		System.out.println("edit id==============="+req.getParameter("did"));
		d.setDeid(Integer.parseInt(req.getParameter("did")));
		d.setDepartmentName(req.getParameter("dn"));
		d.setDepartmentDescription(req.getParameter("dd"));
		this.departmentService.updateDepartment(d);
		
		return "redirect:/department/load";
		
	}
	
	@RequestMapping(value="/department/remove", method=RequestMethod.GET)
    public String removeDepartment(HttpServletRequest req){
		
		System.out.println("inside remove");
		Department d=new Department(); 
		System.out.println("remove id==============="+req.getParameter("id"));
		d.setDeid(Integer.parseInt(req.getParameter("id")));
		this.departmentService.removeDepartment(d);
       
        return "redirect:/department/load";
    }
	
}
