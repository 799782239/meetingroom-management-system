package com.meeting.service;

import com.meeting.dao.add_pesron;
import com.meeting.vo.User;

public class RegisterService {
	private Object ob=new Object();
	
	public void Do_Add(User u){
		u.setState("false");
		ob=(Object)u;
		add_pesron ad=new add_pesron(ob);
	}
}
