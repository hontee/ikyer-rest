package com.ikyer.master.api.rest;

import org.apache.shiro.authz.annotation.RequiresRoles;
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

import com.ikyer.master.api.data.domain.Recommend;
import com.ikyer.master.api.data.form.RecommendForm;
import com.ikyer.master.api.exceptions.CoreException;
import com.ikyer.master.api.rest.ext.ResponseVO;
import com.ikyer.master.api.service.RecommendService;

@RestController
@Scope("prototype")
@RequestMapping("api/recommends")
public class RecommendRest {
	
	private Logger logger = LoggerFactory.getLogger(RecommendRest.class);
	
	@Autowired
	private RecommendService recommendS;
	
	@RequiresRoles({"user","admin"})
	@RequestMapping(value = "share", method = RequestMethod.POST)
	public ResponseEntity<ResponseVO> addRecommend(@Validated RecommendForm form, BindingResult r) {
		logger.info("用户推荐产品");
		ResponseVO vo = new ResponseVO();
		
		if (r.hasErrors()) {
			vo.setMessage("请求参数错误");
			return new ResponseEntity<ResponseVO>(vo, HttpStatus.OK);
		}
		
		try {
			Recommend entity = recommendS.add(form);
			vo.setSuccess(true);
			vo.setMessage("推荐成功");
			vo.setResult(entity);
		} catch (CoreException e) {
			vo.setMessage(e.getErrorCode());
			logger.error("添加推荐失败：{}", e.getMessage());
			e.printStackTrace();
		}
		
		return new ResponseEntity<ResponseVO>(vo, HttpStatus.OK);
	}

}
