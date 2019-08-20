package com.dhyanpraveshika.entity;

import java.util.Arrays;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "dps_user")
public class UserModel {
	
	private Long id;
	private String fcm_token[];
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String[] getFcm_token() {
		return fcm_token;
	}
	public void setFcm_token(String[] fcm_token) {
		this.fcm_token = fcm_token;
	}
	@Override
	public String toString() {
		return "UserModel [id=" + id + ", fcm_token=" + Arrays.toString(fcm_token) + "]";
	}
	
	

}
