package com.dhyanpraveshika.dto;

import java.io.File;

public class EventDTO {
	
	private Long id;
	private String title;
	private String description;
	private String date;
	private String time;
	private String location;
	private byte[] eventFile;
	private String encodedString;
	private String extension;
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
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
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
	@Override
	public String toString() {
		return "EventDTO [id=" + id + ", title=" + title + ", description=" + description + ", date=" + date + ", time="
				+ time + ", location=" + location + "]";
	}
	
	

}
