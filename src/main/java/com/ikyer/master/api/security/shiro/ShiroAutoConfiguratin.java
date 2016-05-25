package com.ikyer.master.api.security.shiro;

import java.util.Set;

import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

@Configuration
public class ShiroAutoConfiguratin {

	@Bean
	public EhCacheManager cacheManager() {
		EhCacheManager cacheManager = new EhCacheManager();
		cacheManager.setCacheManagerConfigFile("classpath:ehcache.xml");
		return cacheManager;
	}

	@Bean
	public ShiroCredentialsMatcher credentialsMatcher() {
		return new ShiroCredentialsMatcher(cacheManager());
	}
	
	@Bean
	public ShiroUserAware shiroUserAware() {
		return new ShiroUserAware() {
			
			@Override
			public Set<String> getRoles() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Set<String> getPermissions() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public ShiroUser findUser(String username) {
				// TODO Auto-generated method stub
				return null;
			}
		};
	}
	
	@Bean
	public UserRealm userRealm() {
		UserRealm realm = new UserRealm(shiroUserAware());
		realm.setCredentialsMatcher(credentialsMatcher());
		return realm;
	}

	@Bean(name = "shiroFilter")
	public ShiroFilterFactoryBean shiroFilterFactory() {
		ShiroFilterFactoryBean shiroFilterFactory = new ShiroFilterFactoryBean();
		shiroFilterFactory.setSecurityManager(securityManager());
		shiroFilterFactory.setLoginUrl("/login");
		shiroFilterFactory.setSuccessUrl("/");
		shiroFilterFactory.setFilterChainDefinitions("/cms/**=authc");
		return shiroFilterFactory;
	}

	@Bean
	public DefaultWebSecurityManager securityManager() {
		DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
		securityManager.setRealm(userRealm());
		return securityManager;
	}

	@Bean(name = "lifecycleBeanPostProcessor")
	public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
		return new LifecycleBeanPostProcessor();
	}

	@Bean
	@DependsOn("lifecycleBeanPostProcessor")
	public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
		DefaultAdvisorAutoProxyCreator creator = new DefaultAdvisorAutoProxyCreator();
		creator.setProxyTargetClass(true);
		return creator;
	}

	@Bean
	public AuthorizationAttributeSourceAdvisor advisor() {
		AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
		advisor.setSecurityManager(securityManager());
		return advisor;
	}

}
