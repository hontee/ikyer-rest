package com.ikyer.master.api.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ikyer.master.api.data.domain.Product;
import com.ikyer.master.api.data.form.ProductForm;
import com.ikyer.master.api.data.query.ProductQuery;
import com.ikyer.master.api.exceptions.CoreException;

public interface ProductService {
	
	Product findOne(Long id);
	
	Product add(ProductForm form) throws CoreException;
	
	Product update(Long id, ProductForm form) throws CoreException;

	void statAll();
	
	void delete(Long id) throws CoreException;
	
	Page<Product> findAll(ProductQuery q, Pageable pageable) throws CoreException;
	
	void pick(Long id);
	
	void unpick(Long id);
	
	void follow(Long id);
	
	void unfollow(Long id);
	
}
