package com.dhyanpraveshika.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "dps_user")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "full_name")
	private String full_name;
	
	@Column(name = "phone_no")
	private String phoneNo;
	
	@Column(name="age")
	private String age;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "password")
	private String password;
	
	@Column (name="country")
	private String country;
	
    @Column(name = "state")
	private String state;
    
    @Column(name = "city")
	private String city;

    @Column(name ="fcm_token")
    private String fcm_token;
    
    @Column(name ="created_date")
    private String created_date;
    
    //new
    @Column(name ="profile")
    private String profile;
    
    @Column(name ="reg_type")
    private String reg_type;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFull_name() {
		return full_name;
	}

	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getFcm_token() {
		return fcm_token;
	}

	public void setFcm_token(String fcm_token) {
		this.fcm_token = fcm_token;
	}

	public String getCreated_date() {
		return created_date;
	}

	public void setCreated_date(String created_date) {
		this.created_date = created_date;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public String getReg_type() {
		return reg_type;
	}

	public void setReg_type(String reg_type) {
		this.reg_type = reg_type;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", full_name=" + full_name + ", phoneNo=" + phoneNo + ", age=" + age + ", email="
				+ email + ", password=" + password + ", country=" + country + ", state=" + state + ", city=" + city
				+ ", fcm_token=" + fcm_token + ", created_date=" + created_date + ", profile=" + profile + ", reg_type="
				+ reg_type + "]";
	}
   
    
    
	
}
