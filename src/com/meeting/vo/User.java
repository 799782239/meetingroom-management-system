package com.meeting.vo;

/**
 * User entity. @author MyEclipse Persistence Tools
 */

public class User implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private Integer age;
	private Integer currentMeeting;
	private String EMail;
	private String department;
	private String job;
	private Integer passMeeting;
	private String password;
	private String phone;
	private String sex;
	private String state;
	private Integer workId;

	// Constructors

	/** default constructor */
	public User() {
	}

	/** minimal constructor */
	public User(String name, Integer age, String EMail, String job,
			String password, String phone, String sex, String state,
			Integer workId) {
		this.name = name;
		this.age = age;
		this.EMail = EMail;
		this.job = job;
		this.password = password;
		this.phone = phone;
		this.sex = sex;
		this.state = state;
		this.workId = workId;
	}

	/** full constructor */
	public User(String name, Integer age, Integer currentMeeting, String EMail,
			String department, String job, Integer passMeeting,
			String password, String phone, String sex, String state,
			Integer workId) {
		this.name = name;
		this.age = age;
		this.currentMeeting = currentMeeting;
		this.EMail = EMail;
		this.department = department;
		this.job = job;
		this.passMeeting = passMeeting;
		this.password = password;
		this.phone = phone;
		this.sex = sex;
		this.state = state;
		this.workId = workId;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return this.age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getCurrentMeeting() {
		return this.currentMeeting;
	}

	public void setCurrentMeeting(Integer currentMeeting) {
		this.currentMeeting = currentMeeting;
	}

	public String getEMail() {
		return this.EMail;
	}

	public void setEMail(String EMail) {
		this.EMail = EMail;
	}

	public String getDepartment() {
		return this.department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getJob() {
		return this.job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public Integer getPassMeeting() {
		return this.passMeeting;
	}

	public void setPassMeeting(Integer passMeeting) {
		this.passMeeting = passMeeting;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Integer getWorkId() {
		return this.workId;
	}

	public void setWorkId(Integer workId) {
		this.workId = workId;
	}

}