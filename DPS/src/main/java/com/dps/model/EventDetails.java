package com.dps.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "dps_event")
public class EventDetails {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String title;
	private String description;
	private String event_date;
	private String location;
	private String path; 
	private String event_time;
	public long getId() {
		return id;
	}
	public String getTitle() {
		return title;
	}
	public String getDescription() {
		return description;
	}
	public String getEvent_date() {
		return event_date;
	}
	public String getLocation() {
		return location;
	}
	public String getPath() {
		return path;
	}
	public String getEvent_time() {
		return event_time;
	}
	public void setId(long id) {
		this.id = id;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setEvent_date(String event_date) {
		this.event_date = event_date;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public void setEvent_time(String event_time) {
		this.event_time = event_time;
	}
	@Override
	public String toString() {
		return "EventDetails [id=" + id + ", title=" + title + ", description=" + description + ", event_date="
				+ event_date + ", location=" + location + ", path=" + path + ", event_time=" + event_time + "]";
	}
	
	
	
}
