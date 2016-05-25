package com.ikyer.master.api.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ikyer.master.api.data.domain.Menu;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Long> {

}