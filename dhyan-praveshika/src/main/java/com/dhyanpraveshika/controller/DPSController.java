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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dhyanpraveshika.dto.BlogDTO;
import com.dhyanpraveshika.dto.VideosDTO;
import com.dhyanpraveshika.model.Blog;
import com.dhyanpraveshika.model.DPSEvent;
import com.dhyanpraveshika.model.DPSVideo;
import com.dhyanpraveshika.model.Donation;
import com.dhyanpraveshika.model.User;
import com.dhyanpraveshika.service.BlogService;
import com.dhyanpraveshika.service.DPSService;
import com.dhyanpraveshika.service.UserService;
import com.dhyanpraveshika.service.DPSVideoService;
import com.dhyanpraveshika.service.DonationService;
import com.dhyanpraveshika.service.EventService;

@Controller

public class DPSController {

	private static final Logger logger = LoggerFactory.getLogger(DPSController.class);

	@Autowired
	private DPSService DPSService;
	
	@Autowired
	private  BlogService blogService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private DPSVideoService videoService;
	
	@Autowired
	private DonationService donationService;
	
	@Autowired
	private EventService eventService;


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

	/*
	 * @RequestMapping("/getVideos") public String getVideos(HttpServletRequest
	 * request, ModelMap model) {
	 * 
	 * return "videos";
	 * 
	 * }
	 */
	@PostMapping("/addVideo")
	public String addVideo(HttpServletRequest request) {
		
		boolean result = videoService.addVideo(request);
		logger.info("add video:{}",result);
		return "videos";
	}
	
	@RequestMapping("/userManagement")
	public String userManagementContrller() {

		return "userManagement";
	}

	@RequestMapping("/donationList")
	public String donationListContrller() {

		return "donationList";
	}
	
	@RequestMapping("/events")
	public String events() {

		return "events";
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
		boolean result = blogService.createBlog(request);
		logger.info("result:{}",result);
		return "home";
	}
	
	@GetMapping("/getUsers")
	public ResponseEntity<List<User>> getUsers(HttpServletResponse res)
	{
		logger.info("at controller getUsers:{}");
		
		List<User> users = userService.getUsers();
		return new ResponseEntity<List<User>>(users,HttpStatus.OK);
	}
	
	@GetMapping("/getVideoes")
	public ResponseEntity<List<DPSVideo>> getVideoes(HttpServletResponse res)
	{
		logger.info("at controller getVideoes");
		List<DPSVideo> dps_videoes = videoService.getVideoes();
		return new ResponseEntity<List<DPSVideo>>(dps_videoes,HttpStatus.OK);
	}
	
	@GetMapping("/getDonations")
	public ResponseEntity<List<Donation>> getDonations(HttpServletResponse res)
	{
		logger.info("at controller getDonations");
		List<Donation> donations = donationService.getDonations();
		return new ResponseEntity<List<Donation>>(donations,HttpStatus.OK);
	}
	
	
	@PostMapping("/addEvent")
	public String addEvent(HttpServletRequest request) 
	{
		logger.info("at controller addEvent :{}");
		
		boolean result = eventService.addEvent(request);
		logger.info("result of add event{}", result);
		
		return "events";
	}
	
	@GetMapping("/getEvents")
	public ResponseEntity<List<DPSEvent>> getEvents(HttpServletResponse res)
	{
		logger.info("at controller getEvents");
		List<DPSEvent> events = eventService.getEvents();
		return new ResponseEntity<List<DPSEvent>>(events,HttpStatus.OK);
	}
	
	@ResponseBody
	@RequestMapping("/getArticle")
	public BlogDTO getArticle(HttpServletRequest request)
	{
		logger.info("at controller getArticle:");
		
		Long id = Long.parseLong(request.getParameter("id"));
		BlogDTO blogDto = blogService.getBlog(id);
		return blogDto;
	}
	
	@ResponseBody
	@RequestMapping("/getVideos")
	public VideosDTO getVideo(HttpServletRequest request)
	{
		logger.info("at controller getVideo:");
		
		VideosDTO dto = videoService.getVideo(request);
		
		return dto;
		
	}
	
	
	
	@ResponseBody
	@RequestMapping("/getAjax")
	public String getAjax(HttpServletRequest request)
	{
		return "ajax";
	}
}
