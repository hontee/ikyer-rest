package com.ikyer.master.mvc.module;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Scope("prototype")
@RequestMapping("users")
public class UserController {
	
	private Logger logger = LoggerFactory.getLogger(UserController.class);
	
	public String list() {
		logger.debug("list");
		return null;
	}

}
