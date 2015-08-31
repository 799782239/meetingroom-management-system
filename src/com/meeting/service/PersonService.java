package com.meeting.service;

import java.util.ArrayList;

import com.meeting.dao.delete_person;
import com.meeting.dao.modify_person;
import com.meeting.dao.search_people;
import com.meeting.vo.User;

public class PersonService {
	
	ArrayList<Object> obj =new ArrayList<Object>();
	ArrayList<User> u =new ArrayList<User>();
	
	public ArrayList<User> ListpersonService() {
		// TODO Auto-generated constructor stub
		search_people s = new search_people();
		User user = new User();
		obj = s.search("User");
		for (int i = 0; i < obj.size(); i++) {
			user = (User) obj.get(i);
			u.add(user);
		}
		return u;
	}
	
	public void personDeleteService(String content) {
		// TODO Auto-generated constructor stub
		User u=new User();

		delete_person d=new delete_person("User", "workId", content);
	}
	
	public ArrayList<User> personCheckService() {
		// TODO Auto-generated constructor stub
		search_people s = new search_people();
		obj = s.serach("User", "state", "false");
		User user = new User();
		for (int i = 0; i < obj.size(); i++) {
			user = (User) obj.get(i);
			u.add(user);

		}
		return u;
	}

	public void personChangeStateTrue(String content) {
		// TODO Auto-generated constructor stub
		search_people s=new search_people();
		User u=new User();
		u=(User)s.search_people("User", "workId", content);
		u.setState("true");
		modify_person m=new modify_person();
		m.modify_person((Object)u);
	} 

	public void personChangeStateDelete(String content){
		User u=new User();
		delete_person d=new delete_person("User", "workId", content);
	}
}
