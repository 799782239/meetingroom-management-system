package com.meeting.vo;

import java.sql.Timestamp;

/**
 * Meeting entity. @author MyEclipse Persistence Tools
 */

public class Meeting implements java.io.Serializable {

	// Fields

	private Integer id;
	private Timestamp data;
	private String booker;
	private Timestamp booktime;
	private Integer estimateTime;
	private String content;
	private Integer level;
	private String room;
	private String speaker;
	private String state;
	private String title;
	private String users;

	// Constructors

	/** default constructor */
	public Meeting() {
	}

	/** full constructor */
	public Meeting(Timestamp data, String booker, Timestamp booktime,
			Integer estimateTime, String content, Integer level, String room,
			String speaker, String state, String title, String users) {
		this.data = data;
		this.booker = booker;
		this.booktime = booktime;
		this.estimateTime = estimateTime;
		this.content = content;
		this.level = level;
		this.room = room;
		this.speaker = speaker;
		this.state = state;
		this.title = title;
		this.users = users;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Timestamp getData() {
		return this.data;
	}

	public void setData(Timestamp data) {
		this.data = data;
	}

	public String getBooker() {
		return this.booker;
	}

	public void setBooker(String booker) {
		this.booker = booker;
	}

	public Timestamp getBooktime() {
		return this.booktime;
	}

	public void setBooktime(Timestamp booktime) {
		this.booktime = booktime;
	}

	public Integer getEstimateTime() {
		return this.estimateTime;
	}

	public void setEstimateTime(Integer estimateTime) {
		this.estimateTime = estimateTime;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getLevel() {
		return this.level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public String getRoom() {
		return this.room;
	}

	public void setRoom(String room) {
		this.room = room;
	}

	public String getSpeaker() {
		return this.speaker;
	}

	public void setSpeaker(String speaker) {
		this.speaker = speaker;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUsers() {
		return this.users;
	}

	public void setUsers(String users) {
		this.users = users;
	}

}