package com.dhyanpraveshika.dto;

public class NotificationDTO {

	private String title;
	private String body;
	private String sound = "default";
	private String click_action = "FCM_PLUGIN_ACTIVITY";
	private String icon = "fcm_push_icon";

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getSound() {
		return sound;
	}

	public void setSound(String sound) {
		this.sound = sound;
	}

	public String getClick_action() {
		return click_action;
	}

	public void setClick_action(String click_action) {
		this.click_action = click_action;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	@Override
	public String toString() {
		return "NotificationDTO [title=" + title + ", body=" + body + ", sound=" + sound + ", click_action="
				+ click_action + ", icon=" + icon + "]";
	}
	
	

}
