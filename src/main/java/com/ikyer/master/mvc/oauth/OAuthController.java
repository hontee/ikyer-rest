package com.ikyer.master.mvc.oauth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	/**
	 * 用户关注的产品 / 用户中心
	 * @param username
	 * @return
	 */
	@RequestMapping("{username}/dashbord")
	public String dashbord(@PathVariable String username) {
		return "users/dashbord";
	}
	
	/**
	 * 用户设置
	 * @param username
	 * @return
	 */
	@RequestMapping("{username}/settings")
	public String settings(@PathVariable String username) {
		return "users/settings";
	}
	
	/**
	 * 用户关注的主题
	 * @param username
	 * @return
	 */
	@RequestMapping("{username}/topics")
	public String topics(@PathVariable String username) {
		return "users/topics";
	}

}
