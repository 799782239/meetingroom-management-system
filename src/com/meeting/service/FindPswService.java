package com.meeting.service;

import com.meeting.dao.search_people;
import com.meeting.vo.User;

public class FindPswService {
	private User user=new User();    //存放查询人员数据
	private String class_name;
	private String username;
	private String findrs;
	
	
	public String getClass_name() {
		return class_name;
	}


	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}
	

	public String getFindrs() {
		return findrs;
	}


	public void setFindrs(String findrs) {
		this.findrs = findrs;
	}


	public boolean check(int usern,String phone){
		setClass_name("User");
		setUsername("workId");
		search_people s=new search_people();
	//	System.out.print("a");
		user=(User)s.search_people(class_name, username, String.valueOf(usern));
		//System.out.println(user.getName());
		if(user==null){
			//System.out.println("sadasdas");
			return false;
		}else{
		//	System.out.println("sadasdas");
			if(user.getPhone().equals(phone)){
				findrs=user.getPassword();
				return true;
			}else{
			//	System.out.println("sadasdas");
				return false;
			}
		}
	}
}
