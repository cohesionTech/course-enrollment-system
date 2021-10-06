package com.hardik.spring.service;

import java.util.List;

import com.hardik.spring.model.Term;

public interface TermService{
	
	public void addTerm(Term t);
	public void updateTerm(Term t);
	public List<Term> listTerms();
	public List<Term> editTerm(Term t);
	public void removeTerm(Term t);
}