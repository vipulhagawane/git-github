package com.dhyanpraveshika.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.dhyanpraveshika.dto.BlogDTO;
import com.dhyanpraveshika.dto.EventDTO;
import com.dhyanpraveshika.dto.VideosDTO;
import com.dhyanpraveshika.entity.Blog;

public interface BlogService {

	boolean createBlog(HttpServletRequest request);

	List<Blog> getBlogs();

	BlogDTO getBlog(Long id);

	boolean deleteArticle(Long id);
	
	//void sendNotifications(BlogDTO blogDTO, EventDTO eventDto, VideosDTO videoDto);

}