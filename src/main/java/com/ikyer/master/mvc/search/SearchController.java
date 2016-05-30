package com.ikyer.master.mvc.search;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @注意：解决请求参数乱码问题需修改TOMCAT <Connector> 添加 URIEncoding="UTF-8"
 * @author larry.qi
 */
@Controller
@Scope("prototype")
@RequestMapping("search")
public class SearchController {
	
	private Logger logger = LoggerFactory.getLogger(SearchController.class);

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String product(@RequestParam String q, Model model) {
		logger.info("用户输入搜索：{}", q);
		return "search/index";
	}
	
	@RequestMapping(value = "/topic", method = RequestMethod.GET)
	public String topic(@RequestParam String q, Model model) {
		logger.info("用户输入搜索：{}", q);
		return "search/index";
	}
	
}
