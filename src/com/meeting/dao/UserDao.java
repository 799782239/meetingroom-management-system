package com.meeting.dao;

import java.util.ArrayList;

import com.meeting.vo.Department;
import com.meeting.vo.User;

public interface UserDao {
	void add(User user);
	void delete(Object entity);
	void modify(User user);
	User find_one(String str);
	ArrayList<User> find_class();
}
