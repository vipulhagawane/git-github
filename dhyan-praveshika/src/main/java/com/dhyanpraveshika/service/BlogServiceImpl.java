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

import com.dhyanpraveshika.controller.DPSController;
import com.dhyanpraveshika.database.BlogDAO;
import com.dhyanpraveshika.model.Blog;

@Service
@Transactional
public class BlogServiceImpl implements BlogService{
	
	private static final Logger logger = LoggerFactory.getLogger(BlogServiceImpl.class);
	
	@Autowired
	private BlogDAO blogDAO;

	@Override
	public boolean createBlog(HttpServletRequest request) {
	
		String title = request.getParameter("articleTital");
		String description = request.getParameter("articleDescription");
		String author = request.getParameter("authorName");
		String category = request.getParameter("category");
		
		logger.info("creating new blog{}",title + " " + description + " " + author);

		if (title != null && description != null && author != null) {
			Date date = new Date();
			DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy kk:mm:ss");
			String newdate = dateFormat.format(date);
			Blog blog = new Blog();
			blog.setTitle(Optional.ofNullable(title).orElse("unavailable"));
			blog.setDescription(Optional.ofNullable(description).orElse("unavailable"));
			blog.setAuthor(Optional.ofNullable(author).orElse("unavailable"));
			blog.setDate(Optional.ofNullable(newdate).orElse("unavailable"));
			blog.setCategory(Optional.ofNullable(category).orElse("unavailable"));
			blogDAO.save(blog);
			
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

}
