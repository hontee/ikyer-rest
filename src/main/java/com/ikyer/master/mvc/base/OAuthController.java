package com.ikyer.master.mvc.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ikyer.master.api.service.UserService;

@Controller
@Scope("prototype")
public class OAuthController {
	
	@Autowired
	private UserService userS;
	
	/**
	 * 忘记密码
	 * @return
	 */
	@RequestMapping("/forgot")
	public String forgot() {
		return "auths/forgot";
	}
	
	/**
	 * 用户登录
	 * @return
	 */
	@RequestMapping("login")
	public String login() {
		return "auths/login";
	}
	
	/**
	 * 注册
	 * @return
	 */
	@RequestMapping("register")
	public String register() {
		return "auths/register";
	}
	
	/**
	 * 授权成功
	 * @return
	 */
	@RequestMapping("authc")
	public String authc() {
		return "redirect:/";
	}
	
	/**
	 * 退出登录
	 * @return
	 */
	@RequestMapping("logout")
	public String logout() {
		userS.logout();
		return "redirect:/";
	}

}
