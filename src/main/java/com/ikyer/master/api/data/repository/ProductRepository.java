package com.ikyer.master.api.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.ikyer.master.api.data.domain.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>,
	JpaSpecificationExecutor<Product> {
	
	Product findByUrl(String url);

}
