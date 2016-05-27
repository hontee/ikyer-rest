package com.ikyer.master.api.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.ikyer.master.api.data.domain.Product;
import com.ikyer.master.api.data.form.ProductForm;
import com.ikyer.master.api.exceptions.CoreException;
import com.ikyer.master.api.rest.ext.ResponseVO;
import com.ikyer.master.api.service.ProductService;

@RestController
@Scope("prototype")
@RequestMapping("api/posts")
public class ProductRest {
	
	private Logger logger = LoggerFactory.getLogger(ProductRest.class);
	
	@Autowired
	private ProductService productS;
	
	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public ResponseEntity<ResponseVO> addProduct(@Validated ProductForm form, BindingResult r) {
		logger.info("添加产品：{}", JSON.toJSONString(form));
		ResponseVO vo = new ResponseVO();
		
		if (r.hasErrors()) {
			vo.setMessage("请求参数错误");
			return new ResponseEntity<ResponseVO>(vo, HttpStatus.OK);
		}
		
		try {
			Product entity = productS.add(form);
			vo.setSuccess(true);
			vo.setMessage("添加产品成功");
			vo.setResult(entity);
		} catch (CoreException e) {
			vo.setMessage(e.getErrorCode());
			e.printStackTrace();
		}
		
		return new ResponseEntity<ResponseVO>(vo, HttpStatus.OK);
	}

}
