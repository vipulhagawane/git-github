package com.dhyanpraveshika.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.dhyanpraveshika.database.BlogDAO;
import com.dhyanpraveshika.dto.BlogDTO;
import com.dhyanpraveshika.model.Blog;

@Service
@Transactional
public class BlogServiceImpl implements BlogService{
	
	private static final Logger logger = LoggerFactory.getLogger(BlogServiceImpl.class);
	
	@Autowired
	private BlogDAO blogDAO;

	@Override
	public boolean createBlog(HttpServletRequest request) {
	
		Blog blog ;
		
		if(request.getParameter("id").isEmpty())
		{
			logger.info("creating new blog");
			blog = new Blog();
		}
		else
		{
			Long id  = Long.parseLong(request.getParameter("id"));
			logger.info("updating blog of id :{}",id);
			blog = blogDAO.findOne(id);
		}
		String title = request.getParameter("articleTital");
		String description = request.getParameter("articleDescription");
		String author = request.getParameter("authorName");
		String category = request.getParameter("category");
		
		logger.info("blog from request:{}",title + " " + description + " " + author);
		
		if (title != null && description != null && author != null) {
			Date date = new Date();
			DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy kk:mm:ss");
			String newdate = dateFormat.format(date);
			
			blog.setTitle(Optional.ofNullable(title).orElse("unavailable"));
			blog.setDescription(Optional.ofNullable(description).orElse("unavailable"));
			blog.setAuthor(Optional.ofNullable(author).orElse("unavailable"));
			blog.setDate(Optional.ofNullable(newdate).orElse("unavailable"));
			blog.setCategory(Optional.ofNullable(category).orElse("unavailable"));
			blogDAO.saveOrUpdate(blog);
			
			return true;
		}
		return false;
	}

	@Override
	public List<Blog> getBlogs() {
		logger.info("fetching blog list");
		
		List<Blog> blogs = blogDAO.findAll();
		if(blogs != null)
		{
			return blogs;
		}
		logger.info("blog list");
		return null;
	}

	@Override
	public BlogDTO getBlog(Long id) {
		logger.info("fetching blog details by id");
		
		Blog blog = blogDAO.findOne(id);
		logger.info("blog details :{}",blog.toString());
		
		BlogDTO dto = null;
		if(blog != null)
		{
			dto =  new BlogDTO();
			dto.setId(Optional.ofNullable(blog.getId()).orElse((long) 0));
			dto.setTitle(Optional.ofNullable(blog.getTitle()).orElse("unavailable"));
			dto.setDescription(Optional.ofNullable(blog.getDescription()).orElse("unavailable"));
			dto.setAuthor(Optional.ofNullable(blog.getAuthor()).orElse("unavailable"));
			dto.setCategory(Optional.ofNullable(blog.getCategory()).orElse("unavailable"));
		}
		
		return dto;
	}

}
