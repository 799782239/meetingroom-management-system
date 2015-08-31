package com.meeting.dao;
import java.awt.List;
import java.util.ArrayList;

import javax.management.Query;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.meeting.vo.Department;
import com.meeting.vo.Meeting;
import com.meeting.vo.MeetingRoom;
import com.meeting.vo.User;

public class search_people {
	public Object search_people(String U_class, String sreach, String content) {
		// TODO Auto-generated constructor stub
		Session session = HibernateSessionFactory.getSession();
		Object obj = new Object();
		String str;
		str = "from " + U_class + " as" + " u" + " where" + " u." + sreach
				+ "='" + content + "'";
		org.hibernate.Query query = session.createQuery(str);
		java.util.List list = query.list();
		if (U_class.equals("User")) {
			User user = new User();
			if(list.isEmpty()){
				user=null;
			}else{
				user = (User) list.get(0);
				//System.out.println(user.getName());
			}
			obj = user;
		} else if (U_class.equals("Meeting")) {
			Meeting meeting = new Meeting();
			if(list.isEmpty()){
				meeting=null;
			}else{
				meeting = (Meeting) list.get(0);
				obj = meeting;
			}
		} else if (U_class.equals("MeetingRoom")) {
			MeetingRoom meetingRoom = new MeetingRoom();
			if(list.isEmpty()){
				meetingRoom=null;
			}else{
				meetingRoom = (MeetingRoom) list.get(0);
				obj = meetingRoom;
			}
		} else if (U_class.equals("Department")) {
			Department department = new Department();
			if(list.isEmpty()){
				department=null;
			}else{
				department = (Department) list.get(0);
				obj = department;
			}
		}
		return obj;
	}

	public ArrayList<Object> serach(String U_class, String sreach,
			String content) {
		String str;
		Session session = HibernateSessionFactory.getSession();
		Object obj = new Object();
		User user = new User();
		ArrayList<Object> o = new ArrayList<Object>();
		str = "from " + U_class + " as" + " u" + " where" + " u." + sreach
				+ "='" + content + "'";
		org.hibernate.Query query = session.createQuery(str);
		java.util.List list = query.list();
		for (int i = 0; i < list.size(); i++) {
			if (U_class.equals("User")) {
				user = (User) list.get(i);
				obj = user;
				o.add(obj);
			} else if (U_class.equals("Meeting")) {
				Meeting meeting = new Meeting();
				meeting = (Meeting) list.get(i);
				obj = meeting;
				o.add(obj);
			} else if (U_class.equals("MeetingRoom")) {
				MeetingRoom meetingRoom = new MeetingRoom();
				meetingRoom = (MeetingRoom) list.get(i);
				obj = meetingRoom;
				o.add(obj);
			} else if (U_class.equals("Department")) {
				Department department = new Department();
				department = (Department) list.get(i);
				obj = department;
				o.add(obj);
			}
		}
		return o;

	}

	public static ArrayList<Object> search(String U_class) {
		String str;
		Session session = HibernateSessionFactory.getSession();
		Object obj = new Object();
		User user = new User();
		ArrayList<Object> o = new ArrayList<Object>();
		str = "select s from " + U_class + " s";
		org.hibernate.Query query = session.createQuery(str);
		java.util.List list = query.list();
		for (int i = 0; i < list.size(); i++) {
			if (U_class.equals("User")) {
				user = (User) list.get(i);
				obj = user;
				o.add(obj);
			} else if (U_class.equals("Meeting")) {
				Meeting meeting = new Meeting();
				meeting = (Meeting) list.get(i);
				obj = meeting;
				o.add(obj);
			} else if (U_class.equals("MeetingRoom")) {
				MeetingRoom meetingRoom = new MeetingRoom();
				meetingRoom = (MeetingRoom) list.get(i);
				obj = meetingRoom;
				o.add(obj);
			} else if (U_class.equals("Department")) {
				Department department = new Department();
				department = (Department) list.get(i);
				obj = department;
				o.add(obj);
			}
		}
		return o;

	}
}
