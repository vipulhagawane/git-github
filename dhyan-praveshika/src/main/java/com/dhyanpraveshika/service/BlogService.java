package com.dhyanpraveshika.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.dhyanpraveshika.model.Blog;

public interface BlogService {

	boolean createBlog(HttpServletRequest request);

	List<Blog> getBlogs();

}