package com.hardik.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hardik.spring.model.Term;
import com.hardik.spring.service.TermService;



@Controller
public class Term_Controller {
	

	private TermService termService;
	
	@Autowired(required=true)
	@Qualifier(value="termService")
	public void setTermService(TermService ts){
		this.termService = ts;
	}
	
	
	
	@RequestMapping(value = "/admin_Addterm", method = RequestMethod.GET)
	public ModelAndView showTerm() {
		
		return new ModelAndView("Admin_AddTerm");
	}
	
	@RequestMapping(value = "/term/add", method = RequestMethod.POST)
	public String addTerm(HttpServletRequest req) {
		
		System.out.println("inside controller");
		Term t=new Term();
		
		t.setTermName(req.getParameter("tn"));
		t.setTermDescription(req.getParameter("td"));
		this.termService.addTerm(t);
		
		return "redirect:/admin_Addterm";
		
	}
	
	@RequestMapping(value = "/term/load", method = RequestMethod.GET)
	public String listTerms(Model model, HttpServletRequest req) {
		System.out.println("inside list method");
		HttpSession session= req.getSession();
		session.setAttribute("termList", this.termService.listTerms());
		//model.addAttribute("termList", this.termService.listTerms());
		return "Admin_ViewTerm";
	}
	
	@RequestMapping(value = "/term/edit", method = RequestMethod.GET)
	public String editTerm(Model model, HttpServletRequest req) {
		Term t=new Term();
		System.out.println("edit id==============="+req.getParameter("id"));
		t.setTid(Integer.parseInt(req.getParameter("id")));
		System.out.println("inside edit");
		model.addAttribute("termRecord",this.termService.editTerm(t));
		
		return "Admin_EditTerm";
	}
	
	@RequestMapping(value = "/term/update", method = RequestMethod.POST)
	public String updateTerm(HttpServletRequest req) {
		
		System.out.println("inside update");
		Term t=new Term();
		System.out.println("edit id==============="+req.getParameter("tid"));
		t.setTid(Integer.parseInt(req.getParameter("tid")));
		t.setTermName(req.getParameter("tn"));
		t.setTermDescription(req.getParameter("td"));
		this.termService.updateTerm(t);
		
		return "redirect:/term/load";
		
	}
	
	@RequestMapping(value="/term/remove", method=RequestMethod.GET)
    public String removeTerm(HttpServletRequest req){
		
		System.out.println("inside remove");
		Term t=new Term();
		System.out.println("remove id==============="+req.getParameter("id"));
		t.setTid(Integer.parseInt(req.getParameter("id")));
		this.termService.removeTerm(t);
       
        return "redirect:/term/load";
    }
	
}
