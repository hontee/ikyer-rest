package com.ikyer.master.api.service;

import com.ikyer.master.api.data.domain.Product;
import com.ikyer.master.api.data.form.ProductForm;
import com.ikyer.master.api.exceptions.CoreException;

public interface ProductService {
	
	Product findOne(Long id);
	
	Product add(ProductForm form) throws CoreException;

}
