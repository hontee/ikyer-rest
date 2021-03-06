package com.ikyer.master.api.service.impl;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Preconditions;
import com.ikyer.master.api.auto.client.WebFetchClient;
import com.ikyer.master.api.auto.client.WebInfo;
import com.ikyer.master.api.data.domain.Recommend;
import com.ikyer.master.api.data.form.RecommendForm;
import com.ikyer.master.api.data.query.RecommendQuery;
import com.ikyer.master.api.data.repository.RecommendRepository;
import com.ikyer.master.api.exceptions.CoreException;
import com.ikyer.master.api.exceptions.ErrorCode;
import com.ikyer.master.api.service.RecommendService;

@Service
public class RecommendServiceImpl implements RecommendService {

	private Logger logger = LoggerFactory.getLogger(RecommendService.class);
	
	@Autowired
	private RecommendRepository recommendR;
	
	@Autowired
	private WebFetchClient client;
	
	@Override
	public Recommend findOne(Long id) {
		return recommendR.findOne(id);
	}

	@Override
	public Recommend add(RecommendForm form) throws CoreException {
		
		Preconditions.checkNotNull(form, "用户推荐信息不能为空");
		if (recommendR.findByUrl(form.getUrl()) != null) {
			throw new CoreException(ErrorCode.RECOMMEND_URL_EXISTS);
		}
		
		WebInfo webInfo = client.fetch(form.getUrl());
		logger.info("抓取网页数据：{}", JSON.toJSONString(webInfo));
		
		Recommend entity = new Recommend();
		entity.setDescription(webInfo.getDescription());
		entity.setKeywords(webInfo.getKeywords());
		entity.setName(entity.randomUUID());
		entity.setTitle(webInfo.getTitle());
		entity.setUrl(webInfo.getUrl());
		entity.setState((byte)0);
		
		if (StringUtils.isNotEmpty(form.getDescripiton())) {
			entity.setDescription(form.getDescripiton());
		}
		
		if (StringUtils.isNotEmpty(form.getKeywords())) {
			entity.setKeywords(form.getKeywords());
		}
		
		if (StringUtils.isNotEmpty(form.getTitle())) {
			entity.setTitle(form.getTitle());
		}
		
		return recommendR.saveAndFlush(entity);
	}

	@Override
	public Recommend update(Long id, RecommendForm form) throws CoreException {
		
		Preconditions.checkNotNull(form, "对象不能为空");
		Recommend entity = recommendR.findOne(id);
		
		if (entity == null) {
			throw new CoreException(ErrorCode.NOT_FOUND);
		}
		
		entity.setDescription(form.getDescripiton());
		entity.setKeywords(form.getKeywords());
		entity.setTitle(form.getTitle());
		entity.setUrl(form.getUrl());
		return recommendR.saveAndFlush(entity);
	}

	@Override
	public void delete(Long id) throws CoreException {
		
		if (!recommendR.exists(id)) {
			throw new CoreException(ErrorCode.NOT_FOUND);
		}
		
		recommendR.delete(id);
	}

	@Override
	public Page<Recommend> findAll(RecommendQuery q, Pageable pageable) throws CoreException {
		return recommendR.findAll(new Specification<Recommend>() {

			@Override
			public Predicate toPredicate(Root<Recommend> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				Predicate predicate = cb.equal(root.get("title").as(String.class), q.getTitle());
				query.where(cb.and(predicate));
				return query.getRestriction();
			}
		}, pageable);
	}

}
