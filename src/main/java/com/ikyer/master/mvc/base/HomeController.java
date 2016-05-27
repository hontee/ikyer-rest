package com.ikyer.master.mvc.base;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Scope("prototype")
public class HomeController {

	@RequestMapping("/")
	public String home() {
		return "home/home";
	}
	
}
