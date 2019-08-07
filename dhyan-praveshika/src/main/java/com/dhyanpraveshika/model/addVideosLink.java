package com.dhyanpraveshika.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "dps_video")
public class addVideosLink 
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name = "v_id")
	private Long v_id;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "path")
	private String path;
	
	@Column(name="createdDate")
	private String createdDate;
	
	@Column(name="dps_video")
	private String dps_video;

	
	public Long getV_id() {
		return v_id;
	}

	public void setV_id(Long v_id) {
		this.v_id = v_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getDps_video() {
		return dps_video;
	}

	public void setDps_video(String dps_video) {
		this.dps_video = dps_video;
	}

	@Override
	public String toString() {
		return "addVideosLink [v_id=" + v_id + ", title=" + title + ", path=" + path + ", createdDate=" + createdDate
				+ ", dps_video=" + dps_video + "]";
	}
	
}//class Close 
