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

import com.dhyanpraveshika.database.DPSVideoDAO;
import com.dhyanpraveshika.dto.BlogDTO;
import com.dhyanpraveshika.dto.VideosDTO;
import com.dhyanpraveshika.entity.Blog;
import com.dhyanpraveshika.entity.DPSVideo;

@Service
@Transactional
public class DPSVideoServiceImpl implements DPSVideoService {

	private static final Logger logger = LoggerFactory.getLogger(DPSVideoServiceImpl.class);

	@Autowired
	private DPSVideoDAO videoDAO;
	
	@Autowired
	private BlogService blogService;
	

	@Override
	public boolean addVideo(HttpServletRequest request) {
		
		boolean result = false;
		
		if(request.getParameter("id").isEmpty())
		{
			logger.info("creating new video");
			DPSVideo dpsVideo = savedVideo(request,null);
			String type = "Video";
			blogService.sendNotifications(dpsVideo.getId(),dpsVideo.getTitle(),type);
			result = true;
		}
		else
		{
			Long videoId  = Long.parseLong(request.getParameter("id"));
			DPSVideo dpsVideo = videoDAO.findOne(videoId);
			savedVideo(request,dpsVideo);
			result = true;
		}
		return result;
	}

	@Override
	public List<DPSVideo> getVideoes() {
		logger.info("fetching videoes");
		
		List<DPSVideo> dps_videoes = videoDAO.findAll();
		logger.info("List of videoes :{}",dps_videoes);
		
		return dps_videoes;
	}

	@Override
	public VideosDTO getVideo(HttpServletRequest request) {
		logger.info("fetching videoes");
		
		Long id = Long.parseLong(request.getParameter("id"));
		
		DPSVideo video = videoDAO.findOne(id);
		
		VideosDTO dto=null;
		if(video != null)
		{
			dto = new VideosDTO();
			
			
			 dto.setId(Optional.ofNullable(video.getId()).orElse((long) 0));
			 dto.setPath(Optional.ofNullable(video.getPath()).orElse("unavailable"));
			 dto.setCategory(Optional.ofNullable(video.getCategory()).orElse("unavailable"));
			 dto.setTitle(Optional.ofNullable(video.getTitle()).orElse("unavailable"));
		}
		
		return dto;
	}
	
	@Override
	public boolean deleteVideo(Long id) {
		
		logger.info("Deleting article of id : {}",id);
		
		//Blog blog = blogDAO.findOne(id);
		DPSVideo video = videoDAO.findOne(id);
		logger.info("Deleting Videos of id : {}",videoDAO.findOne(id));
		if(video != null)
		{
			//video.delete(video);
			videoDAO.delete(video);
			return true;
		}
		return false;
	}
	
	private DPSVideo savedVideo(HttpServletRequest request, DPSVideo dpsVideo) {
		String title = request.getParameter("title");
		String category = request.getParameter("category");
		String path = request.getParameter("path");
		logger.info("video details from request  :{}",title + " " + category + " " + path);
		
		if(dpsVideo == null)
		{
			dpsVideo = new DPSVideo();
		}

		if (title != null && category != null && path != null) {

			Date date = new Date();
			
			 DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy kk:mm:ss"); String
			 newdate = dateFormat.format(date);
			
			dpsVideo.setTitle(title);
			dpsVideo.setCategory(category);
			dpsVideo.setPath(path);
			dpsVideo.setCreated_date(date);
			videoDAO.save(dpsVideo);
		}
		return dpsVideo;
	}

}
