package com.meeting.service;

import com.meeting.dao.search_people;
import com.meeting.vo.User;

public class LoginService {
	private User user=new User();    //存放查询人员数据
	private String class_name;
	private String username;
	
	
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


	public boolean check(String usern,String psw){
		setClass_name("User");
		setUsername("workId");
		search_people s=new search_people();
		user=(User)s.search_people(class_name, username, usern);
		if(user==null){
			return false;
		}else{
			if(user.getPassword().equals(psw)){
				return true;
			}else{
				return false;
			}
		}
	}
}
