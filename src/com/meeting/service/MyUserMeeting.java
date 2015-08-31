package com.meeting.service;

public class MyUserMeeting {
	private Integer id;
	private String Room;
	private String Title;
	private String Time;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public MyUserMeeting() {
		// TODO Auto-generated constructor stub
	}

	public String getRoom() {
		return Room;
	}

	public void setRoom(String room) {
		Room = room;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getTime() {
		return Time;
	}

	public void setTime(String time) {
		Time = time;
	}
}
