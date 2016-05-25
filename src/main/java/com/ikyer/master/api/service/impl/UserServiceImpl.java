package com.ikyer.master.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ikyer.master.api.data.domain.User;
import com.ikyer.master.api.data.repository.UserRepository;
import com.ikyer.master.api.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userR;

	@Override
	public User findOne(Long id) {
		return userR.findOne(id);
	}

}
