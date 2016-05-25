package com.ikyer.master.api.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ikyer.master.api.data.domain.Menu;
import com.ikyer.master.api.data.form.MenuForm;
import com.ikyer.master.api.data.repository.MenuRepository;
import com.ikyer.master.api.service.MenuService;

@Service
public class MenuServiceImpl implements MenuService {

	@Autowired
	private MenuRepository menuR;

	@Override
	public Menu findOne(Long id) {
		return menuR.findOne(id);
	}

	@Override
	public Menu addMenu(MenuForm form) {
		Menu entity = new Menu();
		entity.setDescription(form.getDescription());
		if (StringUtils.isEmpty(form.getName())) {
			entity.setName(entity.randomUUID());
		} else {
			entity.setName(form.getName());
		}
		entity.setPath(form.getPath());
		entity.setState(form.getState());
		entity.setTitle(form.getTitle());
		return menuR.saveAndFlush(entity);
	}

	@Override
	public void delete(Long id) {
		menuR.delete(id);
	}

	@Override
	public Menu update(Long id, MenuForm form) {
		Menu entity = menuR.findOne(id);
		entity.setDescription(form.getDescription());
		if (!StringUtils.isEmpty(form.getName())) {
			entity.setName(form.getName());
		}
		entity.setPath(form.getPath());
		entity.setState(form.getState());
		entity.setTitle(form.getTitle());
		return menuR.saveAndFlush(entity);
	}

	@Override
	public List<Menu> findAll() {
		return menuR.findAll();
	}

	@Override
	public Page<Menu> findAll(Pageable pageable) {
		return menuR.findAll(pageable);
	}
	
	
}
