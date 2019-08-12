package com.dhyanpraveshika.dto;

public class VideosDTO {
	
	private Long id;
	private String title;
	private String path;
	private String category;
	
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
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	@Override
	public String toString() {
		return "VideosDTO [id=" + id + ", title=" + title + ", path=" + path + ", category=" + category + "]";
	}
	
	
}
