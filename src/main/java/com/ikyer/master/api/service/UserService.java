package com.ikyer.master.api.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ikyer.master.api.data.domain.User;
import com.ikyer.master.api.data.form.AuthForm;
import com.ikyer.master.api.data.query.UserQuery;
import com.ikyer.master.api.exceptions.CoreException;

public interface UserService {
	
	User findOne(Long id);
	
	void login(String username, String password) throws CoreException;
	
	void register(AuthForm form) throws CoreException;
	
	void logout();
	
	User update(Long id, AuthForm form) throws CoreException;
	
	void changePassword(Long id, String password) throws CoreException;
	
	void changePassword(String username, String password) throws CoreException;
	
	Page<User> findAll(UserQuery q, Pageable pageable) throws CoreException;
	
	Page<User> findProductUsers(Long productId, Pageable pageable) throws CoreException;
	
	Page<User> findTopicUsers(Long topicId, Pageable pageable) throws CoreException;

	List<Long> findProductIds(Long id) throws CoreException;
	
	List<Long> findTopicIds(Long id) throws CoreException;
}
