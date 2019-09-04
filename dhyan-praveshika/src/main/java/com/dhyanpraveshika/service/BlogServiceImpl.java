package com.dhyanpraveshika.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.dhyanpraveshika.database.BlogDAO;
import com.dhyanpraveshika.dto.BlogDTO;
import com.dhyanpraveshika.dto.DataDTO;
import com.dhyanpraveshika.dto.EventDTO;
import com.dhyanpraveshika.dto.NotificationDTO;
import com.dhyanpraveshika.dto.NotificationJSON;
import com.dhyanpraveshika.dto.VideosDTO;
import com.dhyanpraveshika.entity.Blog;

@Service
@Transactional
public class BlogServiceImpl implements BlogService{
	
	private static final Logger logger = LoggerFactory.getLogger(BlogServiceImpl.class);
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private BlogDAO blogDAO;
	
	@Value("${fcmURL}")
	private String fcmURL;

	@Value("${notificationAuthKey}")
	private String notificationAuthKey;
	
	@Value("${articleFolderPath}")
	private String articleFolderPath;
	
	@Autowired
	private RestTemplate restTemplate;

	@Override
	public boolean createBlog(HttpServletRequest request) {
	
		boolean result = false;
		//BlogDTO blogDTO = null;
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		MultipartFile file = multipartRequest.getFile("file");
		
		if(request.getParameter("id").isEmpty())
		{
			logger.info("creating new blog");
			Blog savedBlog = saveBlog(request,null);
			if(savedBlog != null)
			{
				saveArticleImage(savedBlog.getId(),file);
				String type = "Blog";
				sendNotifications(savedBlog.getId(),savedBlog.getTitle(),type);
				result = true;
			}
		}
		else
		{
			Long id  = Long.parseLong(request.getParameter("id"));
			logger.info("updating blog of id :{}",id);
			Blog prevBlog = blogDAO.findOne(id);
			Blog savedBlog = saveBlog(request,prevBlog);
			
			if(savedBlog != null)
			{
				if(!file.isEmpty())
				{
					deletePreviousFiles(id);
				}
				saveArticleImage(savedBlog.getId(),file);
				result = true;
			}
			else
			{
				blogDAO.save(prevBlog);
			}
			
		}
		
		
		return result;
	}

	@Override
	public List<Blog> getBlogs() {
		logger.info("fetching blog list");
		
		List<Blog> blogs = blogDAO.findAll();
		logger.info("total blogs :{}",blogs.size());
		if(blogs != null)
		{
			return blogs;
		}
		
		return null;
	}

	@Override
	public BlogDTO getBlog(Long id) {
		logger.info("fetching blog details by id");
		
		Blog blog = blogDAO.findOne(id);
		logger.info("blog details from db:{}",blog.toString());
		
		//BlogDTO blogDto = null;
		if(blog != null)
		{
			BlogDTO blogDto =  new BlogDTO();
			
			blogDto =  getArticleImage(id,blogDto);
			
			blogDto.setId(Optional.ofNullable(blog.getId()).orElse((long) 0));
			blogDto.setTitle(Optional.ofNullable(blog.getTitle()).orElse("unavailable"));
			blogDto.setDescription(Optional.ofNullable(blog.getDescription()).orElse("unavailable"));
			blogDto.setAuthor(Optional.ofNullable(blog.getAuthor()).orElse("unavailable"));
			blogDto.setCategory(Optional.ofNullable(blog.getCategory()).orElse("unavailable"));
			blogDto.setCreated_date(Optional.ofNullable(blog.getCreated_date()).orElse("unavailable"));
			logger.info("blogDto details :{}",blogDto.toString());
			return blogDto;
		}
		return null;
	}

	@Override
	public boolean deleteArticle(Long id) {
		logger.info("Deleting article of id : {}",id);
		
		Blog blog = blogDAO.findOne(id);
		logger.info("Deleting article of id : {}",blog.toString());
		if(blog != null)
		{
			blogDAO.delete(blog);
			return true;
		}
		return false;
	}
	
	private void deletePreviousFiles(Long id) {
		logger.info("deleting previous files");
		File file = new File(articleFolderPath);
		File[] files = file.listFiles((dir, name) -> name.startsWith(id + "_"));
		
		if (files.length > 0) {
			for (File prevFile : files) {
				logger.info("Deleting prev files");
				prevFile.delete();
			}
		}
		
	}
	
	private BlogDTO getArticleImage(Long id, BlogDTO blogDTO) {
		logger.info("Fteching image by id :{}", id);
		File file = new File(articleFolderPath);
		File[] files = file.listFiles((dir, name) -> name.startsWith(id + "_"));
		File articleImage = null;
		byte[] bytes = null;
		String encodedString = "";
		String ext = "";
		if (files.length > 0) {
			for (File f : files) {
				{
					articleImage = new File(f.getAbsolutePath());
					logger.info("eventImage:{}", articleImage.getAbsolutePath());
					ext = FilenameUtils.getExtension(articleImage.getName());
					logger.info("ext:{}", ext);
					blogDTO.setExtension(ext);
				}
				// bytes = new byte[(int) eventImage.length()];
				try {
					byte[] fileContent = FileUtils.readFileToByteArray(articleImage);
					logger.info("fileContent:{}", fileContent.toString());
					encodedString = Base64.getEncoder().encodeToString(fileContent);
					//logger.info("encodedString:{}", encodedString);
					blogDTO.setEncodedString(encodedString);
					//response.setContentType("image/" + ext);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					logger.error("error:{}", e.getMessage());
					e.printStackTrace();
				}
			}
		}
		return blogDTO;
	}
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	/*@Override
	public void sendNotifications(BlogDTO blogDTO, EventDTO eventDto, VideosDTO videoDto) {
		logger.info("at sendNotifications :{}", fcmURL);

		HttpHeaders headers = new HttpHeaders();
		headers.set("Content-Type", "application/json");
		headers.set("Authorization", notificationAuthKey);
		
		List<String> tokens = userService.getTokens();

		NotificationDTO notificationDto = new NotificationDTO();
		DataDTO dataDTO = new DataDTO();
		NotificationJSON notificationJSON = new NotificationJSON();

		if (blogDTO != null) {
			notificationDto.setTitle(blogDTO.getTitle());
			notificationDto.setBody("New blog has been added.");

			dataDTO.setId(blogDTO.getId());
			dataDTO.setType("Blog");

			notificationJSON.setNotification(notificationDto);
			notificationJSON.setData(dataDTO);
			notificationJSON.setRegistration_ids(tokens);
		}

		if (eventDto != null) {
			notificationDto.setTitle(eventDto.getTitle());
			notificationDto.setBody("New event has been added.");

			dataDTO.setId(blogDTO.getId());
			dataDTO.setType("Event");

			notificationJSON.setNotification(notificationDto);
			notificationJSON.setData(dataDTO);
			notificationJSON.setRegistration_ids(tokens);
		}

		if (videoDto != null) {
			notificationDto.setTitle(videoDto.getTitle());
			notificationDto.setBody("New video has been added.");

			dataDTO.setId(blogDTO.getId());
			dataDTO.setType("Video");

			notificationJSON.setNotification(notificationDto);
			notificationJSON.setData(dataDTO);
			notificationJSON.setRegistration_ids(tokens);
		}
		logger.info("notification json: {}", notificationJSON.toString());
		
		HttpEntity<NotificationJSON> request = new HttpEntity<>(notificationJSON, headers);
		logger.info("before send notification : {}", request.toString());

		try {
			String resp = restTemplate.postForObject(fcmURL, request, String.class);
			logger.info("after send notification : {}", resp);
		} catch (Exception e) {
			logger.error("Error occurred while sending notification. {}", e.getMessage());
			e.printStackTrace();
		}
	}*/


	private Blog saveBlog(HttpServletRequest request,Blog blog) {
		String title = request.getParameter("articleTital");
		String description = request.getParameter("articleDescription");
		String author = request.getParameter("authorName");
		String category = request.getParameter("category");
		
        logger.info("blog from request:{}",title + " " + description + " " + author);
        
        if(blog == null) {
        	blog = new Blog();
        }
		
		if (!title.isEmpty() && !description.isEmpty() && !author.isEmpty()) {
			Date date = new Date();
			DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy kk:hh:ss");
			String newdate = dateFormat.format(date);
			
			blog.setTitle(Optional.ofNullable(title).orElse("unavailable"));
			blog.setDescription(Optional.ofNullable(description).orElse("unavailable"));
			blog.setAuthor(Optional.ofNullable(author).orElse("unavailable"));
			blog.setCreated_date(Optional.ofNullable(newdate).orElse("unavailable"));
			blog.setCategory(Optional.ofNullable(category).orElse("unavailable"));
			blogDAO.save(blog);
			
		}
		else
		{
			blog = null;
		}
		
		return blog;
	}
	
	private void saveArticleImage(Long id, MultipartFile file) {
		if(file != null)
		{
			try {
				byte[] bytes = file.getBytes();
				Path path = Paths.get(articleFolderPath).resolve(id + "_" + file.getOriginalFilename());
				Files.write(path, bytes);
				logger.info("sucessfully uploaded at path : {}", path.toString());

			} catch (IOException e) {
				logger.info("exception found while getting image{}", e);
			}
			
		}
		
	}
	
	@Override
	public void sendNotifications(Long id, String title, String type) {
		logger.info("at sendNotifications :{}", fcmURL);

		HttpHeaders headers = new HttpHeaders();
		headers.set("Content-Type", "application/json");
		headers.set("Authorization", notificationAuthKey);

		List<String> tokens = userService.getTokens();
		logger.info("tokens :{}",tokens.size());

		NotificationDTO notificationDto = new NotificationDTO();
		DataDTO dataDTO = new DataDTO();
		NotificationJSON notificationJSON = new NotificationJSON();
		
		if(type.equalsIgnoreCase("Blog"))
		{
			
			notificationDto.setBody("New blog has been added.");
		}
		else if(type.equalsIgnoreCase("Event"))
		{
			notificationDto.setBody("New event has been added.");
		}
		else if(type.equalsIgnoreCase("Video"))
		{
			notificationDto.setBody("New video has been added.");
		}

		dataDTO.setId(id);
		dataDTO.setType(type);
		notificationDto.setTitle(title);
		notificationJSON.setRegistration_ids(tokens);
		notificationJSON.setNotification(notificationDto);
		notificationJSON.setData(dataDTO);
		logger.info("notificationDto :{}",notificationDto.toString());
		logger.info("dataDTO :{}",dataDTO.toString());
		logger.info("notification json: {}", notificationJSON.toString());
		
		HttpEntity<NotificationJSON> request = new HttpEntity<>(notificationJSON, headers);
		logger.info("before send notification : {}", request.toString());

		try {
			String resp = restTemplate.postForObject(fcmURL, request, String.class);
			logger.info("after send notification : {}", resp);
		} catch (Exception e) {
			logger.error("Error occurred while sending notification. {}", e.getMessage());
			e.printStackTrace();
		}
		
	}

}
