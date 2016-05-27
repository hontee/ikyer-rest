package com.ikyer.master.api.service.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ikyer.master.api.data.domain.User;
import com.ikyer.master.api.data.repository.UserRepository;
import com.ikyer.master.api.shiro.ShiroUser;
import com.ikyer.master.api.shiro.ShiroUserAware;

@Service
public class ShiroUserAwareImpl implements ShiroUserAware {

	@Autowired
	private UserRepository userR;
	
	@Override
	public ShiroUser findUser(String username) {
		User user = userR.findByName(username);
		if (user != null) {
			ShiroUser shiroUser = new ShiroUser();
			shiroUser.setId(user.getId());
			shiroUser.setUsername(user.getName());
			shiroUser.setPassword(user.getPassword());
			shiroUser.setSalt(user.getSalt());
			return shiroUser;
		}
		return null;
	}

	@Override
	public Set<String> getRoles() {
		Set<String> sets = new HashSet<>();
		sets.add("user");
		sets.add("admin");
		return sets;
	}

	@Override
	public Set<String> getPermissions() {
		return null;
	}

}
