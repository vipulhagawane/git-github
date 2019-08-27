package com.dps.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "dps_user")
public class UserDetails {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String full_name;
	private String email;
	private String phone_no;
	private String age;
	private String password;
	private String country;
	private String state;
	private String city;
	private String fcm_token;
	private Timestamp created_date;
	
	public Long getId() {
		return id;
	}
	public String getFull_name() {
		return full_name;
	}
	public String getEmail() {
		return email;
	}
	public String getPhone_no() {
		return phone_no;
	}
	public String getAge() {
		return age;
	}
	public String getPassword() {
		return password;
	}
	public String getCountry() {
		return country;
	}
	public String getState() {
		return state;
	}
	public String getCity() {
		return city;
	}
	public String getFcm_token() {
		return fcm_token;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setPhone_no(String phone_no) {
		this.phone_no = phone_no;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public void setState(String state) {
		this.state = state;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public void setFcm_token(String fcm_token) {
		this.fcm_token = fcm_token;
	}
	@Override
	public String toString() {
		return "UserDetails [id=" + id + ", full_name=" + full_name + ", email=" + email + ", phone_no=" + phone_no
				+ ", age=" + age + ", password=" + password + ", country=" + country + ", state=" + state + ", city="
				+ city + ", fcm_token=" + fcm_token + ", created_date=" + created_date + "]";
	}
	public Timestamp getCreated_date() {
		return created_date;
	}
	public void setCreated_date(Timestamp created_date) {
		this.created_date = created_date;
	}
	
	

	

}
