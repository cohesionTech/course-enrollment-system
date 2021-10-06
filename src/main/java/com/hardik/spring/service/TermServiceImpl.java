package com.hardik.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hardik.spring.dao.TermDAO;
import com.hardik.spring.model.Term;


@Service
public class TermServiceImpl implements TermService {
	
	private TermDAO termDAO;

	public void setTermDAO(TermDAO termDAO) {
		this.termDAO = termDAO;
	}

	
	@Transactional
	public void addTerm(Term t) {
		this.termDAO.addTerm(t);
	}

	
	@Transactional
	public void updateTerm(Term t) {
		this.termDAO.updateTerm(t);
	}

	
	@Transactional
	public List<Term> listTerms() {
		return this.termDAO.listTerms();
	}

	@Transactional
	public List<Term> editTerm(Term t) {
		return this.termDAO.editTerm(t);
	}
	

	@Transactional
	public void removeTerm(Term t) {
		this.termDAO.removeTerm(t);
	}

}