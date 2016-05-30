package com.ikyer.master.mvc.about;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Scope("prototype")
public class AboutController {
	
	@RequestMapping("about")
	public String about(Model model) {
		model.addAttribute("title", "关于我们");
		return "about/index";
	}

}
