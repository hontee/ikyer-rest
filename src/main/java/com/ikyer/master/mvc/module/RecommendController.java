package com.ikyer.master.mvc.module;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ikyer.master.api.service.RecommendService;

@Controller
@Scope("prototype")
@RequestMapping("recommends")
public class RecommendController {
	
	private Logger logger = LoggerFactory.getLogger(RecommendController.class);
	
	@Autowired
	private RecommendService recommendS;
	
	@RequestMapping("/share")
	public String share(Model model) {
		return "recommend/share";
	}

}
