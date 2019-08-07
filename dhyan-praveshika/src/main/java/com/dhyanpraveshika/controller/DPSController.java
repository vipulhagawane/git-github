package com.dhyanpraveshika.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.dhyanpraveshika.model.Blog;
import com.dhyanpraveshika.service.BlogService;
import com.dhyanpraveshika.service.DPSService;

@Controller

public class DPSController {

	private static final Logger logger = LoggerFactory.getLogger(DPSController.class);

	@Autowired
	private DPSService DPSService;
	
	@Autowired
	private  BlogService blogService ;


	//@RequestMapping(value = "/", method = RequestMethod.GET)
	 @RequestMapping(value = { "/", "/login" }, method = RequestMethod.GET)
	    public String showLoginPage(ModelMap model) {
		return "login";
	}

	@RequestMapping("/home")
	public String home(HttpServletRequest request, ModelMap model) {
		logger.info("fetching user details{}");

		boolean user = DPSService.checkUser(request);

		logger.info("user available {}", user);
		System.out.print("user" + user);

		if (!user) {
			model.put("errorMessag", "InvaledUserId and Password !!!!!");
			return "login";
		} else {
			//model.put("name", email);
			//model.put("pass", password);
			return "home";
		}

	}
	@RequestMapping("/getArticles")
	public String getArticles(HttpServletRequest request, ModelMap model) {
		
		return "home";

	}
	
	@RequestMapping("/addArticles")
	public String addArticles() 
	{
		

		return "home";
	}
	

	@RequestMapping("/videos")
	public String VideosContrller() {

		return "videos";
	}
	
	@RequestMapping("/addVideosLink")
	public String addVideosContrller() {

		return "addVideosLink";
	}
	
	
	
	

	@RequestMapping("/userManagement")
	public String userManagementContrller() {

		return "userManagement";
	}

	@RequestMapping("/donationList")
	public String donationListContrller() {

		return "donationList";
	}
	
	
	//anga
	
	@GetMapping("/getBlogs")
	public ResponseEntity<List<Blog>> getBlogs(HttpServletResponse res)
	{
		logger.info("fetching blog list:{}");
		List<Blog> blogs = blogService.getBlogs();
		logger.info("at controller donations:{}",blogs);
		return new ResponseEntity<List<Blog>>(blogs,HttpStatus.OK);
	}
	
	@PostMapping("/addArticle")
	public String addArticles(HttpServletRequest request) 
	{
		logger.info("at add article",request.getParameter("articleTital"));
		boolean result = blogService.createBlog(request);
		logger.info("result",result);
		return "home";
	}
	
	
	
}
