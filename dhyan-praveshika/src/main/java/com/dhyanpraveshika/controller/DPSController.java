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
import com.dhyanpraveshika.dto.EventDTO;
import com.dhyanpraveshika.entity.Blog;
import com.dhyanpraveshika.entity.DPSEvent;
import com.dhyanpraveshika.entity.DPSVideo;
import com.dhyanpraveshika.entity.Donation;
import com.dhyanpraveshika.entity.User;
import com.dhyanpraveshika.service.BlogService;
import com.dhyanpraveshika.service.DPSService;
import com.dhyanpraveshika.service.UserService;
import com.dhyanpraveshika.service.DPSVideoService;
import com.dhyanpraveshika.service.DonationService;
import com.dhyanpraveshika.service.EventService;

@Controller

public class DPSController {
	
	private String addArticle = "";
	private String addEvent="";
	private String addVideo="";
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
	public String VideosContrller() 
	{
		addVideo="";
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
		logger.info("fetching blog list at controller");
		addArticle = "";
		List<Blog> blogs = blogService.getBlogs();
		return new ResponseEntity<List<Blog>>(blogs,HttpStatus.OK);
	}
	
	@PostMapping("/addArticle")
	public String addArticles(HttpServletRequest request) 
	{
		boolean result = blogService.createBlog(request);
		logger.info("result:{}",result);
		
		if(result == true)
		{
			addArticle = "success";
		}
		
		else
		{
			addArticle = "fail";
		}
		return "home";
	}
	
	
	@PostMapping("/addEvent")
	public String addEvent(HttpServletRequest request) 
	{
		logger.info("at controller addEvent :{}");
		
		boolean result = eventService.addEvent(request);
		logger.info("result of add event{}", result);
		
		if(result == true)
		{
			addEvent = "success";
		}
		
		else
		{
			addEvent = "fail";
		}
		
		return "events";
	}
	
	@PostMapping("/addVideo")
	public String addVideo(HttpServletRequest request) {
		
		boolean result = videoService.addVideo(request);
		logger.info("add video:{}",result);
		
		
		if(result == true)
		{
			addVideo = "success";
		}
		
		else
		{
			addVideo = "fail";
		}
		
		return "videos";
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
		addVideo="";
		return new ResponseEntity<List<DPSVideo>>(dps_videoes,HttpStatus.OK);
	}
	
	@GetMapping("/getDonations")
	public ResponseEntity<List<Donation>> getDonations(HttpServletResponse res)
	{
		logger.info("at controller getDonations");
		List<Donation> donations = donationService.getDonations();
		return new ResponseEntity<List<Donation>>(donations,HttpStatus.OK);
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
	@RequestMapping("/getEvent")
	public EventDTO getEvent(HttpServletRequest request)
	{
		logger.info("at controller getEvent");
		Long id = Long.parseLong(request.getParameter("id"));
		EventDTO eventDto = eventService.getEvent(id);
		return eventDto;
	}
	
	@RequestMapping("/deleteArticle")
	public String deleteArticle(HttpServletRequest request)
	{
		logger.info("at controller deleteArticle");
		Long id = Long.parseLong(request.getParameter("id"));
		boolean result = blogService.deleteArticle(id);
		logger.info("result :{}",result);
		return "home";
	}
	
	@RequestMapping("/deleteVideo")
	public String deleteVideo(HttpServletRequest request)
	{
		logger.info("Controller deleteVideo ::::");
		Long id = Long.parseLong(request.getParameter("id"));
		boolean result=videoService.deleteVideo(id);
		logger.info("result :{}",result);
		return "home";
		
	}
	
	@RequestMapping("/deleteEvent")
	public String deleteEvent(HttpServletRequest request)
	{
		logger.info("Controller deleteEvent ::::");
		Long id = Long.parseLong(request.getParameter("id"));
		boolean result=eventService.deleteEvent(id);
		logger.info("result :{}",result);
		return "home";
		
	}
	
//vipul
	
	@ResponseBody
	@GetMapping("/isArticleAdd")
	public String getAddArticleResult()
	{
		logger.info("at controller addArticle : {},",addArticle);
		return addArticle;
	}
	@ResponseBody
	@GetMapping("/isEventAdd")
	public String getAddEventResult()
	{
		logger.info("at controller addArticle : {},",addArticle);
		return addEvent;
	}
	
	
	@ResponseBody
	@GetMapping("/isVideoAdd")
	public String getAddVideousResult()
	{
		logger.info("at controller addArticle");
		
		return addVideo;
	}
	
	
}
