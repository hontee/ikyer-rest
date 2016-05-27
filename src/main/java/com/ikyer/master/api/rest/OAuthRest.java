package com.ikyer.master.api.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.ikyer.master.api.data.form.AuthForm;
import com.ikyer.master.api.exceptions.CoreException;
import com.ikyer.master.api.rest.ext.ResponseVO;
import com.ikyer.master.api.service.UserService;

@RestController
@Scope("prototype")
@RequestMapping("api/oauths")
public class OAuthRest {
	
	private Logger logger = LoggerFactory.getLogger(OAuthRest.class);
	
	@Autowired
	private UserService userS;

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity<ResponseVO> register(@Validated AuthForm form, BindingResult r) {
		logger.info("==========用户注册===========");
		ResponseVO vo = new ResponseVO();
		
		if (r.hasErrors()) {
			logger.error("请求参数错误：{}", JSON.toJSONString(r.getAllErrors()));
			vo.setMessage("请求参数错误");
			return new ResponseEntity<>(vo, HttpStatus.OK);
		}
		
		try {
			userS.register(form);
			vo.setSuccess(true);
			vo.setMessage("注册成功");
			vo.setResult("/");
		} catch (CoreException e) {
			vo.setMessage(e.getErrorCode());
			logger.error("用户注册失败：{}", e.getMessage());
			e.printStackTrace();
		}
		
		return new ResponseEntity<>(vo, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<ResponseVO> login(@RequestParam String username, @RequestParam String password) {
		logger.info("==========用户登录：{}==========", username);
		ResponseVO vo = new ResponseVO();
		
		try {
			userS.login(username, password);
			vo.setSuccess(true);
			vo.setMessage("登录成功");
			vo.setResult("/");
		} catch (CoreException e) {
			vo.setMessage(e.getErrorCode());
			logger.error("用户登录失败：{}", e.getMessage());
			e.printStackTrace();
		}
		
		return new ResponseEntity<>(vo, HttpStatus.OK);
	}
}
