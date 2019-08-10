package com.dhyanpraveshika.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dhyanpraveshika.database.DPSVideoDAO;
import com.dhyanpraveshika.model.DPSVideo;

@Service
@Transactional
public class DPSVideoServiceImpl implements DPSVideoService {

	private static final Logger logger = LoggerFactory.getLogger(DPSVideoServiceImpl.class);

	@Autowired
	private DPSVideoDAO videoDAO;

	@Override
	public boolean addVideo(HttpServletRequest request) {
		String title = request.getParameter("title");
		String category = request.getParameter("category");
		String path = request.getParameter("path");
		
		logger.info("video details from request  :{}",title + " " + category + " " + path);

		if (title != null && category != null && path != null) {

			Date date = new Date();
			DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy kk:mm:ss");
			String newdate = dateFormat.format(date);
			
			DPSVideo dpsvideo = new DPSVideo();
			dpsvideo.setTitle(title);
			dpsvideo.setCategory(category);
			dpsvideo.setPath(path);
			dpsvideo.setDate(newdate);
			videoDAO.save(dpsvideo);
			
			return true;
		}
		return false;
	}

	@Override
	public List<DPSVideo> getVideoes() {
		logger.info("fetching videoes");
		
		List<DPSVideo> dps_videoes = videoDAO.findAll();
		logger.info("List of videoes :{}",dps_videoes);
		
		return dps_videoes;
	}

}
