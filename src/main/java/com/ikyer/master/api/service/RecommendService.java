package com.ikyer.master.api.service;

import com.ikyer.master.api.data.domain.Recommend;
import com.ikyer.master.api.data.form.RecommendForm;
import com.ikyer.master.api.exceptions.CoreException;

public interface RecommendService {
	
	Recommend findOne(Long id);
	
	Recommend add(RecommendForm form) throws CoreException;

}
