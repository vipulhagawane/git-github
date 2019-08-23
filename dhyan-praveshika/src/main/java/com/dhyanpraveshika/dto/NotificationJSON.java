package com.dhyanpraveshika.dto;

import java.util.List;

public class NotificationJSON {

	private NotificationDTO notification;
	private DataDTO data;

	private List<String> registration_ids;
	private String priority = "high";
	private String restricted_package_name = "";

	public NotificationDTO getNotification() {
		return notification;
	}

	public void setNotification(NotificationDTO notification) {
		this.notification = notification;
	}

	public DataDTO getData() {
		return data;
	}

	public void setData(DataDTO data) {
		this.data = data;
	}

	public List<String> getRegistration_ids() {
		return registration_ids;
	}

	public void setRegistration_ids(List<String> registration_ids) {
		this.registration_ids = registration_ids;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getRestricted_package_name() {
		return restricted_package_name;
	}

	public void setRestricted_package_name(String restricted_package_name) {
		this.restricted_package_name = restricted_package_name;
	}

	@Override
	public String toString() {
		return "NotificationJSON [notification=" + notification + ", data=" + data + ", registration_ids="
				+ registration_ids + ", priority=" + priority + ", restricted_package_name=" + restricted_package_name
				+ "]";
	}

}
