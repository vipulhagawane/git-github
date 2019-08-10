package com.dhyanpraveshika.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.dhyanpraveshika.model.DPSEvent;

public interface EventService {

	boolean addEvent(HttpServletRequest request);

	List<DPSEvent> getEvents();

}
