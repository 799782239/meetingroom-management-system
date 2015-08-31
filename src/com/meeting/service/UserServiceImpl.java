package com.meeting.service;

import java.util.ArrayList;

import com.meeting.dao.UserDao;
import com.meeting.vo.User;

public class UserServiceImpl implements UserService {

	private UserDao userDao;
	public UserDao getUserDao() {
		return userDao;
	}
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	public void personDeleteService(String content) {
		// TODO Auto-generated constructor stub
		String str = "from User as u where u.workId"
				+ "='" + content + "'";
		User u=new User();
		u=userDao.find_one(str);
		userDao.delete((Object)u);
	}
	public ArrayList<User> personDelService() {
		// TODO Auto-generated constructor stub
		//String str="select s from User s";
		ArrayList<User> use=new ArrayList<User>();
		use=userDao.find_class();
		return use;
	}

}
