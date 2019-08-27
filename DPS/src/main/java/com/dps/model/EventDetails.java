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
	private String date;
	private String location;
	private String path; 
	private String time;
	public long getId() {
		return id;
	}
	public String getTitle() {
		return title;
	}
	public String getDescription() {
		return description;
	}
	public String getDate() {
		return date;
	}
	public String getLocation() {
		return location;
	}
	public String getPath() {
		return path;
	}
	public String getTime() {
		return time;
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
	public void setDate(String date) {
		this.date = date;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public void setTime(String time) {
		this.time = time;
	}
	@Override
	public String toString() {
		return "EventDetails [id=" + id + ", title=" + title + ", description=" + description + ", date=" + date
				+ ", location=" + location + ", path=" + path + ", time=" + time + "]";
	}
	
	
	
}
