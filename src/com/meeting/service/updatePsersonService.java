package com.meeting.service;

import com.meeting.dao.modify_person;
import com.meeting.dao.search_people;
import com.meeting.vo.User;

public class updatePsersonService {
	User user;
	
	public updatePsersonService(String name, String flag, String content) {
		// TODO Auto-generated constructor stub
		search_people s = new search_people();
		user = (User) s.search_people("User", "workId", name);
		if (flag.equals("name")) {
			user.setName(content);
		} else if (flag.equals("age")) {
			user.setAge(Integer.valueOf(content));
		} else if (flag.equals("sex")) {
			user.setSex(content);
		} else if (flag.equals("phone")) {
			user.setPhone(content);
		} else if (flag.equals("email")) {
			user.setEMail(content);
		}
		modify_person mod = new modify_person();
		mod.modify_person(user);

	}
}
