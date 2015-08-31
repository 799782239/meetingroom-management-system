package com.meeting.dao;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.meeting.vo.User;

public class modify_person {
	public void modify_person(Object obj) {
		// TODO Auto-generated constructor stub
		Session session = HibernateSessionFactory.getSession();
		Transaction tran = session.beginTransaction();
		session.update(obj);
		tran.commit();
		session.close();
	}
}
