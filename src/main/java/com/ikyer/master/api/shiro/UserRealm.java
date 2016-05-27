package com.ikyer.master.api.shiro;

import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserRealm extends AuthorizingRealm {

	private Logger logger = LoggerFactory.getLogger(UserRealm.class);
	
	private ShiroUserAware shiroUserAware;
	
	public UserRealm(ShiroUserAware shiroUserAware) {
		this.shiroUserAware = shiroUserAware;
	}

	/**
	 * 登录成功的用户：角色和权限设置
	 * 
	 * @Notes: 由于SHIRO过滤器每次都会进行权限验证，Roles和Permissions最好使用缓存
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		logger.info("为登录成功的用户：{}，添加角色和权限", principals.getPrimaryPrincipal());
	    SimpleAuthorizationInfo authorization = new SimpleAuthorizationInfo();
	    
	    Set<String> roles = shiroUserAware.getRoles();
	    if (CollectionUtils.isNotEmpty(roles)) {
	    	logger.info("设置用户角色：{}", roles.toString());
	    	authorization.setRoles(roles);
		}
	    
	    Set<String> permissions = shiroUserAware.getPermissions();
	    if (CollectionUtils.isNotEmpty(permissions)) {
	    	logger.info("设置用户权限：{}", permissions.toString());
	    	authorization.setStringPermissions(permissions);
		}
	    
		return authorization;
	}

	/**
	 * 用户身份认证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String username = (String) token.getPrincipal();
	    logger.info("用户身份认证：{}", username);
	    ShiroUser shiroUser = shiroUserAware.findUser(username);
		return new SimpleAuthenticationInfo(shiroUser.getUsername(), shiroUser.getPassword(),
				ByteSource.Util.bytes(shiroUser.getSalt()), getName());
	}

}
