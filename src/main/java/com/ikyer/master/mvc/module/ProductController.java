package com.ikyer.master.mvc.module;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ikyer.master.api.data.query.ProductQuery;
import com.ikyer.master.api.exceptions.CoreException;
import com.ikyer.master.api.service.ProductService;

@Controller
@Scope("prototype")
@RequestMapping("posts")
public class ProductController {

	private Logger logger = LoggerFactory.getLogger(ProductController.class);
	
	@Autowired
	private ProductService productS;
	
	@RequestMapping
	public String user(Model model) {
		logger.info("加载用户数据");
		return "product/index";
	}
	
	@RequestMapping("newest")
	public String newest(Model model) {
		try {
			productS.findAll(new ProductQuery(), new PageRequest(1, 12));
		} catch (CoreException e) {
			e.printStackTrace();
		}
		return "product/index";
	}
	
	@RequestMapping("hot")
	public String hot(Model model) {
		return "product/index";
	}
	
	@RequestMapping("pick")
	public String pick(Model model) {
		return "product/index";
	}
	
	@RequestMapping("{id}/hit")
	public String hit(@PathVariable Long id) {
		return "redirect:/";
	}
	
}
