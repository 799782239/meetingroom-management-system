package com.meeting.dao;

import java.util.ArrayList;

import org.springframework.orm.hibernate3.HibernateTemplate;

import com.meeting.vo.Department;
import com.meeting.vo.User;

public class UserDaoImpl implements UserDao {
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public void add(User user) {
		// TODO Auto-generated method stub
		hibernateTemplate.save(user);

	}

	public void delete(Object entity) {
		// TODO Auto-generated method stub
		hibernateTemplate.delete(entity);

	}

	public User find_one(String str) {
		// TODO Auto-generated method stub
		java.util.List list = hibernateTemplate.find(str);
		User u=new User();
		u = (User) list.get(0);
		return u;
	}

	public void modify(User user) {
		// TODO Auto-generated method stub
		hibernateTemplate.update(user);

	}

	public ArrayList<User> find_class() {
		// TODO Auto-generated method stub
		ArrayList<User> use = new ArrayList<User>();

		java.util.List list = hibernateTemplate
				.find("from com.meeting.vo.User");
		for (int i = 0; i < list.size(); i++) {
			User u = new User();
			u = (User) list.get(i);

			use.add(u);
		}
		return use;

	}

}
