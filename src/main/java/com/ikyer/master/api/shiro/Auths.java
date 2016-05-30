package com.ikyer.master.api.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;

import com.ikyer.master.api.data.domain.User;
import com.ikyer.master.api.exceptions.CoreRuntimeException;
import com.ikyer.master.api.exceptions.ErrorCode;

/**
 * 当前登录用户
 * @author larry.qi
 */
public class Auths {
	
	/**
	 * 设置登录用户
	 * @param user
	 */
	public static void set(User user) {
		Session session = SecurityUtils.getSubject().getSession(true);
		session.setAttribute("auths", user);
	}
	
	/**
	 * 获取当前登录用户
	 * @return
	 */
	public static User get() {
		Session session = SecurityUtils.getSubject().getSession();
		Object object = session.getAttribute("auths");
		
		if (object == null) {
			throw new CoreRuntimeException(ErrorCode.OAUTH_UNAUTHORIZED);
		}
		
		return (User)object;
	}
	
	/**
	 * ID
	 * @return
	 */
	public static Long id() {
		return get().getId();
	}
	
	/**
	 * 用户名
	 * @return
	 */
	public static String username() {
		return get().getName();
	}
	
	/**
	 * Email
	 * @return
	 */
	public static String email() {
		return get().getEmail();
	}

	/**
	 * 是否为管理员
	 * @return
	 */
	public static boolean isAdmin() {
		return get().getType() == 2;
	}
	
	/**
	 * 邮箱是否已验证
	 * @return
	 */
	public static boolean isEmailSet() {
		return get().getIsEmailSet() == 1;
	}
	
	/**
	 * 
	 * @return
	 */
	public static boolean isLogin() {
		return get() != null;
	}
	
}
