package com.ikyer.master.mvc.home;

import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ikyer.master.api.rest.ext.ResponseVO;
import com.ikyer.master.api.shiro.Auths;

@Controller
@Scope("prototype")
public class HomeController {

	@RequestMapping("/")
	public String home() {
		return "redirect:/posts";
	}
	
	@RequestMapping("/auths")
	public @ResponseBody ResponseEntity<ResponseVO> auth() {
		ResponseVO vo = new ResponseVO();
		vo.setResult(Auths.get());
		return new ResponseEntity<ResponseVO>(vo, HttpStatus.OK);
	}
	
}
