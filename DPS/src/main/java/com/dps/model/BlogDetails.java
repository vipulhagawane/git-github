package com.dps.model;

import java.io.File;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "dps_blog")
public class BlogDetails {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;
	private String description;
	private String author;
	private String category;
	private String created_Date;
	private File PathURI;
	
	public Long getId() {
		return id;
	}
	public String getTitle() {
		return title;
	}
	public String getDescription() {
		return description;
	}
	public String getAuthor() {
		return author;
	}
	public String getCategory() {
		return category;
	}
	public String getCreated_Date() {
		return created_Date;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public void setCreated_Date(String created_Date) {
		this.created_Date = created_Date;
	}
	public File getPathURI() {
		return PathURI;
	}
	public void setPathURI(File pathURI) {
		PathURI = pathURI;
	}
	@Override
	public String toString() {
		return "BlogDetails [id=" + id + ", title=" + title + ", description=" + description + ", author=" + author
				+ ", category=" + category + ", created_Date=" + created_Date + ", PathURI=" + PathURI + "]";
	}
	
	
	

}
