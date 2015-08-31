package com.meeting.vo;

import java.util.Date;

/**
 * Department entity. @author MyEclipse Persistence Tools
 */

public class Department implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private Integer numberLimit;
	private Date builddata;
	private String employeelist;

	// Constructors

	/** default constructor */
	public Department() {
	}

	/** full constructor */
	public Department(String name, Integer numberLimit, Date builddata,
			String employeelist) {
		this.name = name;
		this.numberLimit = numberLimit;
		this.builddata = builddata;
		this.employeelist = employeelist;
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

	public Integer getNumberLimit() {
		return this.numberLimit;
	}

	public void setNumberLimit(Integer numberLimit) {
		this.numberLimit = numberLimit;
	}

	public Date getBuilddata() {
		return this.builddata;
	}

	public void setBuilddata(Date builddata) {
		this.builddata = builddata;
	}

	public String getEmployeelist() {
		return this.employeelist;
	}

	public void setEmployeelist(String employeelist) {
		this.employeelist = employeelist;
	}

}