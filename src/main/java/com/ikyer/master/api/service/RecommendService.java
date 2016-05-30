package com.ikyer.master.api.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ikyer.master.api.data.domain.Recommend;
import com.ikyer.master.api.data.form.RecommendForm;
import com.ikyer.master.api.data.query.RecommendQuery;
import com.ikyer.master.api.exceptions.CoreException;

public interface RecommendService {
	
	Recommend findOne(Long id);
	
	Recommend add(RecommendForm form) throws CoreException;
	
	Recommend update(Long id, RecommendForm form) throws CoreException;

	void delete(Long id) throws CoreException;
	
	Page<Recommend> findAll(RecommendQuery q, Pageable pageable) throws CoreException;
	
}
