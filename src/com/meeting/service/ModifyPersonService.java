package com.meeting.service;

import com.meeting.dao.search_people;
import com.meeting.vo.User;

public class ModifyPersonService {
	User user;

	public User ModifyPersonService(String workId) {
		// TODO Auto-generated constructor stub
		search_people s=new search_people();
		user = (User) s.search_people("User", "workId", workId);
		return user;
	}
}
