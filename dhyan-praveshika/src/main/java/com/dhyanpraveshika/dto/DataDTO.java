package com.dhyanpraveshika.dto;

public class DataDTO {
	private Long id;
	private String type;
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "DataDTO [id=" + id + ", type=" + type + "]";
	}
	
}
