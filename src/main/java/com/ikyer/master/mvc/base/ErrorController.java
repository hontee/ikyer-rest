package com.ikyer.master.mvc.base;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Scope("prototype")
public class ErrorController {
	
	/**
	 * 404
	 * @return
	 */
	@RequestMapping("404")
	public String notFound() {
		
		return "errors/404";
	}
	
	/**
	 * 没有授权
	 * @return
	 */
	@RequestMapping("unauthorized")
	public String unauthorized() {
		return "errors/unauthorized";
	}

}
