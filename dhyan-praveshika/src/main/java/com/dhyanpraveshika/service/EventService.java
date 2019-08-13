package com.dhyanpraveshika.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.dhyanpraveshika.dto.EventDTO;
import com.dhyanpraveshika.entity.DPSEvent;

public interface EventService {

	boolean addEvent(HttpServletRequest request);

	List<DPSEvent> getEvents();

	EventDTO getEvent(Long id);

}
