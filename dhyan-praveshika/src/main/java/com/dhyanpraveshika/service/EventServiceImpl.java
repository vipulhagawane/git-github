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
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.dhyanpraveshika.database.EventDAO;
import com.dhyanpraveshika.dto.EventDTO;
import com.dhyanpraveshika.entity.Blog;
import com.dhyanpraveshika.entity.DPSEvent;

@Service
@Transactional
public class EventServiceImpl implements EventService {

	//private static final String folder = "D:\\DhyanPraveShika_home\\images\\event";

	private static final Logger logger = LoggerFactory.getLogger(EventServiceImpl.class);

	@Autowired
	HttpServletResponse response;

	@Autowired
	private EventDAO eventDAO;
	
	@Autowired
	private BlogService blogService;
	
	@Value("${eventFolderPath}")
	private String eventFolderPath;

	@Override
	public boolean addEvent(HttpServletRequest request) {
		
		DPSEvent event;
		boolean result = false;
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		MultipartFile file = multipartRequest.getFile("file");
		
		if(request.getParameter("id").isEmpty())
		{
			logger.info("creating new Event");
			DPSEvent newEvent = saveEvent(request,null);
			if(newEvent != null)
			{
				saveEventImage(newEvent.getId(),file);
				String type = "Event";
				blogService.sendNotifications(newEvent.getId(),newEvent.getTitle(),type);
				result = true;
			}
		}
		else
		{
			Long id  = Long.parseLong(request.getParameter("id"));
			logger.info("updating event of id :{}",id);
			event = eventDAO.findOne(id);
			/*
			 * if(!file.isEmpty()) { deletePreviousFiles(id); } DPSEvent newEvent =
			 * saveEvent(request,event); if(newEvent != null) {
			 * saveEventImage(newEvent.getId(),file); result = true; }
			 */
			DPSEvent newEvent = saveEvent(request,event);
			if(newEvent != null)
			{
				if(!file.isEmpty())
				{
					deletePreviousFiles(id);
					saveEventImage(newEvent.getId(),file);
				}
				result = true;
			}
			else
			{
				eventDAO.save(event);
			}
			
		}

		return result;
	}

	@Override
	public List<DPSEvent> getEvents() {
		logger.info("Fetching events");

		List<DPSEvent> events = eventDAO.findAll();
		logger.info("List of events: {}", events);

		return events;
	}

	@Override
	public EventDTO getEvent(Long id) {
		logger.info("Getting event of id :{}", id);

		DPSEvent event = eventDAO.findOne(id);
		logger.info("event from db :{}", event.toString());

		
		if (event != null) {
			EventDTO eventDTO = new EventDTO();
			
			eventDTO =  getEventImage(id,eventDTO);
			
			eventDTO.setId(Optional.ofNullable(event.getId()).orElse((long) 0));
			eventDTO.setTitle(Optional.ofNullable(event.getTitle()).orElse("unavailable"));
			eventDTO.setDescription(Optional.ofNullable(event.getDescription()).orElse("unavailable"));
			eventDTO.setEventDate(Optional.ofNullable(event.getEventDate()).orElse("unavailable"));
			eventDTO.setEventTime(Optional.ofNullable(event.getEventTime()).orElse("unavailable"));
			eventDTO.setLocation(Optional.ofNullable(event.getLocation()).orElse("unavailable"));
			
			logger.info("event dto :{}", eventDTO.toString());
			return eventDTO;
		}
		return null;
	}

	private EventDTO getEventImage(Long id, EventDTO eventDTO) {
		logger.info("Fteching image by id :{}", id);
		File file = new File(eventFolderPath);
		File[] files = file.listFiles((dir, name) -> name.startsWith(id + "_"));
		File eventImage = null;
		byte[] bytes = null;
		String encodedString = "";
		String ext = "";
		if (files.length > 0) {
			for (File f : files) {
				{
					eventImage = new File(f.getAbsolutePath());
					logger.info("eventImage:{}", eventImage.getAbsolutePath());
					ext = FilenameUtils.getExtension(eventImage.getName());
					logger.info("ext:{}", ext);
					eventDTO.setExtension(ext);
				}
				// bytes = new byte[(int) eventImage.length()];
				try {
					byte[] fileContent = FileUtils.readFileToByteArray(eventImage);
					logger.info("fileContent:{}", fileContent.toString());
					encodedString = Base64.getEncoder().encodeToString(fileContent);
					logger.info("encodedString:{}", encodedString);
					eventDTO.setEncodedString(encodedString);
					//response.setContentType("image/" + ext);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					logger.error("error:{}", e.getMessage());
					e.printStackTrace();
				}
			}
		}
		return eventDTO;
	}
	
	private void deletePreviousFiles(Long id) {
		logger.info("deleting previous files");
		File file = new File(eventFolderPath);
		File[] files = file.listFiles((dir, name) -> name.startsWith(id + "_"));
		
		if (files.length > 0) {
			for (File prevFile : files) {
				logger.info("Deleting prev files");
				prevFile.delete();
			}
		}
		
	}
	
	private DPSEvent saveEvent(HttpServletRequest request, DPSEvent event) {

		String title = request.getParameter("title");
		String description = request.getParameter("description");
		String date = request.getParameter("date");
		String time = request.getParameter("time");
		String location = request.getParameter("location");
		
		logger.info("adding event details : {}", title + " " + description + " " + date + " " + time + " " + location);
		
		if(event == null)
		{
			event = new DPSEvent();
		}

		if (title != null && description != null) {
			
			Date createdDate = new Date();
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss");
			String today = dateFormat.format(createdDate);
			
			event.setTitle(title);
			event.setDescription(description);
			event.setCreated_date(Optional.ofNullable(today).orElse("unavailable"));
			event.setEventDate(Optional.ofNullable(date).orElse("unavailable"));
			event.setEventTime(Optional.ofNullable(time).orElse("unavailable"));
			event.setLocation(Optional.ofNullable(location).orElse("unavailable"));
			eventDAO.save(event);

		}
		else
		{
			event = null;
		}
		
		return event;
	}

	private void saveEventImage(Long id, MultipartFile file) {
		if(file != null)
		{
			try {
				byte[] bytes = file.getBytes();
				Path path = Paths.get(eventFolderPath).resolve(id + "_" + file.getOriginalFilename());
				Files.write(path, bytes);
				logger.info("sucessfully uploaded at path : {}", path.toString());

			} catch (IOException e) {
				logger.info("exception found while getting image{}", e);
			}
		}
		
	}
		@Override
	public boolean deleteEvent(Long id) {

		logger.info("Deleting article of id : {}",id);
		DPSEvent video = eventDAO.findOne(id);
		logger.info("Deleting Videos of id : {}",eventDAO.findOne(id));
		if(video != null)
		{
			//video.delete(video);
			eventDAO.delete(video);
			return true;
		}
		return false;
	}



}
