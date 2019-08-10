package com.dhyanpraveshika.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.dhyanpraveshika.database.EventDAO;
import com.dhyanpraveshika.model.DPSEvent;

@Service
@Transactional
public class EventServiceImpl implements EventService {
	
	private static final Logger logger = LoggerFactory.getLogger(EventServiceImpl.class);
	
	@Autowired
	private EventDAO eventDAO;

	@Override
	public boolean addEvent(HttpServletRequest request) {
		
		String title = request.getParameter("title");
		String description = request.getParameter("description");
		String date = request.getParameter("date");
		String time = request.getParameter("time");
		String location = request.getParameter("location");
		
		String folder = "E:\\Dhyan Praveshika\\images";
		
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		MultipartFile file = multipartRequest.getFile("file");
		
		logger.info("adding event details : {}",title + " " + description + " " + date + " " + time + " " + location + " " + file.getOriginalFilename());
		
		if(title != null && description != null && file != null)
		{
			DPSEvent event = new DPSEvent();
			event.setTitle(title);
			event.setDescription(description);
			event.setDate(Optional.ofNullable(date).orElse("unavailable"));
			event.setTime(Optional.ofNullable(time).orElse("unavailable"));
			event.setLocation(Optional.ofNullable(location).orElse("unavailable"));
			eventDAO.save(event);
			
			try {
				byte[] bytes = file.getBytes();
				Path path = Paths.get(folder).resolve(event.getId() + "_" + file.getOriginalFilename());
				Files.write(path, bytes);
				logger.info("sucessfully uploaded at path : {}" , path.toString());
				
			} catch (IOException e) {
				logger.info("exception found while getting image{}", e);
				return false;
			}
			
			return true;
		}
		
		return false;
	}

	@Override
	public List<DPSEvent> getEvents() {
		logger.info("Fetching events");
		
		List<DPSEvent> events = eventDAO.findAll();
		logger.info("List of events: {}", events);
		
		return events;
	}

}
