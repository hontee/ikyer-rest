package com.ikyer.master.api.service;

import com.ikyer.master.api.data.domain.User;
import com.ikyer.master.api.data.form.AuthForm;
import com.ikyer.master.api.exceptions.CoreException;

public interface UserService {
	
	User findOne(Long id);
	
	void login(String username, String password) throws CoreException;
	
	void register(AuthForm form) throws CoreException;
	
	void logout();

}
