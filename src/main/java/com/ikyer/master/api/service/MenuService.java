package com.ikyer.master.api.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ikyer.master.api.data.domain.Menu;
import com.ikyer.master.api.data.form.MenuForm;

public interface MenuService {
	
	Menu findOne(Long id);
	
	Menu addMenu(MenuForm form);
	
	void delete(Long id);
	
	Menu update(Long id, MenuForm form);
	
	List<Menu> findAll();
	
	Page<Menu> findAll(Pageable pageable);

}
