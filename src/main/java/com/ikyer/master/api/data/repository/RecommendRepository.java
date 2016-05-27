package com.ikyer.master.api.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.ikyer.master.api.data.domain.Recommend;

@Repository
public interface RecommendRepository extends JpaRepository<Recommend, Long>, 
	JpaSpecificationExecutor<Recommend> {
	
	Recommend findByUrl(String url);

}
