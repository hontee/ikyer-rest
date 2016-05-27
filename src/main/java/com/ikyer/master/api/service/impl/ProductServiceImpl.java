package com.ikyer.master.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.base.Preconditions;
import com.ikyer.master.api.data.domain.Product;
import com.ikyer.master.api.data.form.ProductForm;
import com.ikyer.master.api.data.repository.ProductRepository;
import com.ikyer.master.api.exceptions.CoreException;
import com.ikyer.master.api.exceptions.ErrorCode;
import com.ikyer.master.api.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	// private Logger logger = LoggerFactory.getLogger(ProductService.class);
	
	@Autowired
	private ProductRepository productR;
	
	@Override
	public Product findOne(Long id) {
		return productR.findOne(id);
	}

	@Override
	public Product add(ProductForm form) throws CoreException {
		
		Preconditions.checkNotNull(form, "添加产品信息不能为空");
		
		if (productR.findByUrl(form.getUrl()) != null) {
			throw new CoreException(ErrorCode.PRODUCT_URL_EXISTS);
		}
		
		Product entity = new Product();
		entity.setDescription(form.getDescription());
		entity.setHit(0);
		entity.setStars(0);
		entity.setName(entity.randomUUID());
		entity.setPick(form.getPick());
		entity.setReffer(form.getReffer());
		entity.setState(form.getState());
		entity.setTags(form.getTags());
		entity.setTitle(form.getTitle());
		entity.setUrl(form.getUrl());
		return productR.saveAndFlush(entity);
	}

}
