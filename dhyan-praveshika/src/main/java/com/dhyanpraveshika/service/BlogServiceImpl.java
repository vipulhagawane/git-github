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
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.dhyanpraveshika.database.BlogDAO;
import com.dhyanpraveshika.dto.BlogDTO;
import com.dhyanpraveshika.dto.EventDTO;
import com.dhyanpraveshika.entity.Blog;

@Service
@Transactional
public class BlogServiceImpl implements BlogService{
	
	private static final Logger logger = LoggerFactory.getLogger(BlogServiceImpl.class);
	
	private static final String folder = "D:\\DhyanPraveShika_home\\images\\article";
	
	@Autowired
	private BlogDAO blogDAO;

	@Override
	public boolean createBlog(HttpServletRequest request) {
	
		Blog blog ;
		
		String title = request.getParameter("articleTital");
		String description = request.getParameter("articleDescription");
		String author = request.getParameter("authorName");
		String category = request.getParameter("category");
		
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		MultipartFile file = multipartRequest.getFile("file");
		
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
			if(!file.isEmpty())
			{
				deletePreviousFiles(id);
			}
		}
		
		logger.info("blog from request:{}",title + " " + description + " " + author);
		
		if (title != null && description != null && author != null) {
			Date date = new Date();
			DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy kk:mm:ss");
			String newdate = dateFormat.format(date);
			
			blog.setTitle(Optional.ofNullable(title).orElse("unavailable"));
			blog.setDescription(Optional.ofNullable(description).orElse("unavailable"));
			blog.setAuthor(Optional.ofNullable(author).orElse("unavailable"));
			blog.setCreated_date(Optional.ofNullable(newdate).orElse("unavailable"));
			blog.setCategory(Optional.ofNullable(category).orElse("unavailable"));
			blogDAO.save(blog);
			
			try {
				byte[] bytes = file.getBytes();
				Path path = Paths.get(folder).resolve(blog.getId() + "_" + file.getOriginalFilename());
				Files.write(path, bytes);
				logger.info("sucessfully uploaded at path : {}", path.toString());

			} catch (IOException e) {
				logger.info("exception found while getting image{}", e);
				return false;
			}
			
			return true;
		}
		return false;
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
		logger.info("blog details :{}",blog.toString());
		
		BlogDTO blogDto = null;
		if(blog != null)
		{
			blogDto =  new BlogDTO();
			
			blogDto =  getArticleImage(id,blogDto);
			
			blogDto.setId(Optional.ofNullable(blog.getId()).orElse((long) 0));
			blogDto.setTitle(Optional.ofNullable(blog.getTitle()).orElse("unavailable"));
			blogDto.setDescription(Optional.ofNullable(blog.getDescription()).orElse("unavailable"));
			blogDto.setAuthor(Optional.ofNullable(blog.getAuthor()).orElse("unavailable"));
			blogDto.setCategory(Optional.ofNullable(blog.getCategory()).orElse("unavailable"));
		}
		
		return blogDto;
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
		File file = new File(folder);
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
		File file = new File(folder);
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
					logger.info("encodedString:{}", encodedString);
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

}
