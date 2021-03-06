package com.dps.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "dps_video")
public class VideoDetails {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
	
	private String title;
	private String path;
	private String category;
	private String created_Date;
	public Long getId() {
		return id;
	}
	public String getTitle() {
		return title;
	}
	public String getPath() {
		return path;
	}
	public String getCategory() {
		return category;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getCreated_Date() {
		return created_Date;
	}
	public void setCreated_Date(String created_Date) {
		this.created_Date = created_Date;
	}
	@Override
	public String toString() {
		return "VideoDetails [id=" + id + ", title=" + title + ", path=" + path + ", category=" + category
				+ ", created_Date=" + created_Date + "]";
	}
	
	
	
	
	
	

}
