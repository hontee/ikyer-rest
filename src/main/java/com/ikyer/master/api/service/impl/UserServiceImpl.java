package com.ikyer.master.api.service.impl;

import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.google.common.base.Preconditions;
import com.ikyer.master.api.data.domain.User;
import com.ikyer.master.api.data.form.AuthForm;
import com.ikyer.master.api.data.query.UserQuery;
import com.ikyer.master.api.data.repository.UserRepository;
import com.ikyer.master.api.exceptions.CoreException;
import com.ikyer.master.api.exceptions.ErrorCode;
import com.ikyer.master.api.service.UserService;
import com.ikyer.master.api.shiro.Auths;
import com.ikyer.master.api.shiro.EncryptHelper;

@Service
public class UserServiceImpl implements UserService {
	
	private Logger logger = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private UserRepository userR;

	@Override
	public User findOne(Long id) {
		logger.info("{}", id);
		return userR.findOne(id);
	}

	@Override
	public void login(String username, String password) throws CoreException {
		
		Preconditions.checkNotNull(username, "用户名不能为空");
		Preconditions.checkNotNull(password, "登录不能为空");
		User loginUser = null;
		
		if (username.indexOf("@") == -1) { // 用户名登录
			loginUser = userR.findByName(username);
		} else { // 邮箱登录
			loginUser = userR.findByEmail(username);
		}
		
		if (loginUser == null) {
			throw new CoreException(ErrorCode.OAUTH_USERNAME_PASSWORD_ERROR);
		}
		
		try {
			// 用户登录
			UsernamePasswordToken token = new UsernamePasswordToken(loginUser.getName(), password);
			Subject subject = SecurityUtils.getSubject();
			subject.login(token);
			
			// 如何登录成功，保存用户信息
			Auths.set(loginUser);
		} catch (Exception e) {
			e.printStackTrace();
			throw new CoreException(ErrorCode.OAUTH_USERNAME_PASSWORD_ERROR, e);
		} 
	}

	@Override
	public void register(AuthForm form) throws CoreException {
		
		Preconditions.checkNotNull(form, "用户注册信息不能为空");
		
		if (userR.findByName(form.getUsername()) != null) {
			throw new CoreException(ErrorCode.OAUTH_USERNAME_EXISTS);
		}
		
		if (userR.findByEmail(form.getEmail()) != null) {
			throw new CoreException(ErrorCode.OAUTH_EMAIL_EXISTS);
		}
		
		User register = new User();
		register.setName(form.getUsername());
		register.setEmail(form.getEmail());
		register.setIsEmailSet((byte)0);
		register.setState((byte)1);
		register.setType((byte)1);
		register.setTitle(form.getUsername());
		
		/* 设置密码 */
		register.setSalt(register.randomSalt());
		String encryptPassword = EncryptHelper.encrypt(form.getPassword(), register.getSalt());
		register.setPassword(encryptPassword);
		userR.save(register);
	}

	@Override
	public void logout() {
		SecurityUtils.getSubject().logout();
	}

	@Override
	public User update(Long id, AuthForm form) throws CoreException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void changePassword(Long id, String password) throws CoreException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void changePassword(String username, String password) throws CoreException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Page<User> findAll(UserQuery q, Pageable pageable) throws CoreException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<User> findProductUsers(Long productId, Pageable pageable) throws CoreException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<User> findTopicUsers(Long topicId, Pageable pageable) throws CoreException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Long> findProductIds(Long id) throws CoreException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Long> findTopicIds(Long id) throws CoreException {
		// TODO Auto-generated method stub
		return null;
	}

}
