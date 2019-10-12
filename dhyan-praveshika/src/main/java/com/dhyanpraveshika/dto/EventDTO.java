package com.dhyanpraveshika.dto;

import java.io.File;
import java.util.Arrays;

public class EventDTO {
	
	private Long id;
	private String title;
	private String description;
	private String eventDate;
	private String eventTime;
	private String location;
	private byte[] eventFile;
	private String encodedString;
	private String extension;
	private String evDate;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	public byte[] getEventFile() {
		return eventFile;
	}
	public void setEventFile(byte[] eventFile) {
		this.eventFile = eventFile;
	}
	
	public String getEncodedString() {
		return encodedString;
	}
	public void setEncodedString(String encodedString) {
		this.encodedString = encodedString;
	}
	
	public String getExtension() {
		return extension;
	}
	public void setExtension(String extension) {
		this.extension = extension;
	}
	public String getEventDate() {
		return eventDate;
	}
	public void setEventDate(String eventDate) {
		this.eventDate = eventDate;
	}
	public String getEventTime() {
		return eventTime;
	}
	public void setEventTime(String eventTime) {
		this.eventTime = eventTime;
	}
	public String getEvDate() {
		return evDate;
	}
	public void setEvDate(String evDate) {
		this.evDate = evDate;
	}
	@Override
	public String toString() {
		return "EventDTO [id=" + id + ", title=" + title + ", description=" + description + ", eventDate=" + eventDate
				+ ", eventTime=" + eventTime + ", location=" + location + ", extension=" + extension + "]";
	}

}
