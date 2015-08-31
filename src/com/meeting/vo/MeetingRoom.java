package com.meeting.vo;

/**
 * MeetingRoom entity. @author MyEclipse Persistence Tools
 */

public class MeetingRoom implements java.io.Serializable {

	// Fields

	private Integer id;
	private String local;
	private Integer maxNumber;
	private String name;

	// Constructors

	/** default constructor */
	public MeetingRoom() {
	}

	/** full constructor */
	public MeetingRoom(String local, Integer maxNumber, String name) {
		this.local = local;
		this.maxNumber = maxNumber;
		this.name = name;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLocal() {
		return this.local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public Integer getMaxNumber() {
		return this.maxNumber;
	}

	public void setMaxNumber(Integer maxNumber) {
		this.maxNumber = maxNumber;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}