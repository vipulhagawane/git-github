package com.dhyanpraveshika.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "dps_blog")
public class Blog {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "author")
	private String author;
	
	@Column(name = "created_date")
	private String created_date;
	
	@Column(name = "category")
	private String category;
	
	
	
	 @Column(name = "shareURL") 
	 private String shareURL;
	 

	/*
	 * @Column(name = "pathuri") private String pathuri;
	 */
	
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


	public String getAuthor() {
		return author;
	}


	public void setAuthor(String author) {
		this.author = author;
	}


	public String getCreated_date() {
		return created_date;
	}


	public void setCreated_date(String created_date) {
		this.created_date = created_date;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	/*
	 * public String getPathuri() { return pathuri; }
	 * 
	 * 
	 * public void setPathuri(String pathuri) { this.pathuri = pathuri; }
	 */


	
	 public String getShareURL() { return shareURL; }
	  
	  
	 public void setShareURL(String shareURL) { this.shareURL = shareURL; }


	@Override
	public String toString() {
		return "Blog [id=" + id + ", title=" + title + ", description=" + description + ", author=" + author
				+ ", created_date=" + created_date + ", category=" + category + ", shareURL=" + shareURL + "]";
	}
	 
	 
	 

	
}
