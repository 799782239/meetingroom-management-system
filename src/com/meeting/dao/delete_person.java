package com.meeting.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.meeting.vo.Department;
import com.meeting.vo.Meeting;
import com.meeting.vo.MeetingRoom;
import com.meeting.vo.User;

public class delete_person {
	public delete_person(String U_class, String sreach, String content) {
		// TODO Auto-generated constructor stub
		Session session = HibernateSessionFactory.getSession();
		User user = new User();
		Object obj=new Object();
		String str;
		str = "from " + U_class + " as" + " u" + " where" + " u." + sreach
				+ "='" + content + "'";
		org.hibernate.Query query = session.createQuery(str);
		java.util.List list = query.list();
		if (U_class.equals("User")) {
			user = (User) list.get(0);
			obj = user;
		} else if (U_class.equals("Meeting")) {
			Meeting meeting = new Meeting();
			meeting = (Meeting) list.get(0);
			obj = meeting;
		} else if (U_class.equals("MeetingRoom")) {
			MeetingRoom meetingRoom = new MeetingRoom();
			meetingRoom = (MeetingRoom) list.get(0);
			obj = meetingRoom;
		} else if (U_class.equals("Department")) {
			Department department = new Department();
			department = (Department) list.get(0);
			obj = department;
		}
		Transaction tran = session.beginTransaction();
		session.delete(obj);
		tran.commit();
		session.close();
	}

}
