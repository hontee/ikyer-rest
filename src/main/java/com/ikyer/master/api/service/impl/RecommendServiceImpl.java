package com.ikyer.master.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ikyer.master.api.data.domain.Recommend;
import com.ikyer.master.api.data.repository.RecommendRepository;
import com.ikyer.master.api.service.RecommendService;

@Service
public class RecommendServiceImpl implements RecommendService {

	@Autowired
	private RecommendRepository recommendR;
	
	@Override
	public Recommend findOne(Long id) {
		return recommendR.findOne(id);
	}

}
