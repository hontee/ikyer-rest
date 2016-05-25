package com.ikyer.master.api.security.shiro;

import java.util.Set;

public interface ShiroUserAware {

	ShiroUser findUser(String username);
	
	Set<String> getRoles();
	
	Set<String> getPermissions();
	
}
