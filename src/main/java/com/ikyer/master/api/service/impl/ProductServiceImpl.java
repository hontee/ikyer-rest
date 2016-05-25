package com.ikyer.master.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ikyer.master.api.data.domain.Product;
import com.ikyer.master.api.data.repository.ProductRepository;
import com.ikyer.master.api.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productR;
	
	@Override
	public Product findOne(Long id) {
		return productR.findOne(id);
	}

}
