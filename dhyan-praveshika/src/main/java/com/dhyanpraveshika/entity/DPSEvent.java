package com.dhyanpraveshika.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "dps_event")
public class DPSEvent {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "path")
	private String path;
	
	@Column(name = "created_date")
	private Date  created_date;
	
	@Column(name = "event_date")
	private Date eventDate;
	
	@Column(name = "event_time")
	private String eventTime;

	@Column(name = "location")
	private String location;
	
	@Column(name="ev_date")
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

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	

	public String getEventTime() {
		return eventTime;
	}

	public void setEventTime(String eventTime) {
		this.eventTime = eventTime;
	}

	public Date getCreated_date() {
		return created_date;
	}

	public void setCreated_date(Date created_date) {
		this.created_date = created_date;
	}

	public Date getEventDate() {
		return eventDate;
	}

	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}
	
	public String getEvDate() {
		return evDate;
	}

	public void setEvDate(String evDate) {
		this.evDate = evDate;
	}

	@Override
	public String toString() {
		return "DPSEvent [id=" + id + ", title=" + title + ", description=" + description + ", path=" + path
				+ ", created_date=" + created_date + ", eventDate=" + eventDate + ", eventTime=" + eventTime
				+ ", location=" + location + "]";
	}
	

	

}
