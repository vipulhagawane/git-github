package com.dhyanpraveshika.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JspController {
	
	private static final Logger logger = LoggerFactory.getLogger(JspController.class);
	
	@RequestMapping("/addBlog")
	public String addBlog()
	{
		logger.info("at add blog");
		return "addBlog";
	}

}
