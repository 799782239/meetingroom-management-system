package com.meeting.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.meeting.vo.User;

public class add_pesron {

	public add_pesron(Object obj) {
		// TODO Auto-generated constructor stub
		Session session = HibernateSessionFactory.getSession();
		Transaction tran = session.beginTransaction();
		session.save(obj);
		tran.commit();
		session.close();
	}

}
