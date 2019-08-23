package com.dhyanpraveshika.dto;

public class BlogDTO {

	private Long id;
	private String title;
	private String description;
	private String author;
	private String category;
	private String encodedString;
	private String extension;
	private String created_date;
	
	
	public String getCreated_date() {
		return created_date;
	}


	public void setCreated_date(String created_date) {
		this.created_date = created_date;
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

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
		return "BlogDTO [id=" + id + ", title=" + title + ", description=" + description + ", author=" + author
				+ ", category=" + category + ", encodedString=" + encodedString + ", extension=" + extension
				+ ", created_date=" + created_date + "]";
	}
	
}
