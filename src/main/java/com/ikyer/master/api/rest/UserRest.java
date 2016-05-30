package com.ikyer.master.api.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ikyer.master.api.exceptions.CoreException;
import com.ikyer.master.api.rest.ext.ResponseVO;
import com.ikyer.master.api.service.UserService;

@RestController
@Scope("prototype")
@RequestMapping("api/users")
public class UserRest {

	private Logger logger = LoggerFactory.getLogger(UserRest.class);

	@Autowired
	private UserService userS;
	
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public ResponseEntity<ResponseVO> login(@RequestParam String username, @RequestParam String password,
			@RequestParam(defaultValue = "/") String redirct) {
		logger.info("用户登录：{}", username);
		ResponseVO vo = new ResponseVO();
		try {
			userS.login(username, password);
			vo.setSuccess(true);
			vo.setMessage("登录成功");
			vo.setResult(redirct);
		} catch (CoreException e) {
			logger.info("登录失败：{}", e.getMessage());
			vo.setMessage(e.getErrorCode());
			e.printStackTrace();
		}
		
		return new ResponseEntity<ResponseVO>(vo, HttpStatus.OK);
	}
	
	@RequestMapping(value = "{name}/settings", method = RequestMethod.POST)
	public ResponseEntity<ResponseVO> settings(@PathVariable String name, @RequestParam String title,
			String description) {
		logger.info("保存用户设置：{}, 名称：{},　描述：{}", name, title, description);
		ResponseVO vo = new ResponseVO();
		//userS.update(id, form);
		vo.setSuccess(true);
		vo.setMessage("保存成功");
		return new ResponseEntity<ResponseVO>(vo, HttpStatus.OK);
	}
}
