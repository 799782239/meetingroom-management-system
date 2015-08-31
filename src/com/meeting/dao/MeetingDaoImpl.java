package com.meeting.dao;

import java.util.ArrayList;

import org.springframework.orm.hibernate3.HibernateTemplate;

import com.meeting.vo.Meeting;
import com.meeting.vo.MeetingRoom;

public class MeetingDaoImpl implements MeetingDao {
	private HibernateTemplate hibernateTemplate;

	@Override
	public void add(Meeting meeting) {
		// TODO Auto-generated method stub
		hibernateTemplate.save(meeting);

	}

	@Override
	public void delete(Meeting meeting) {
		// TODO Auto-generated method stub
		hibernateTemplate.delete(meeting);

	}

	@Override
	public ArrayList<Meeting> find_class() {
		// TODO Auto-generated method stub
		ArrayList<Meeting> use = new ArrayList<Meeting>();

		java.util.List list = hibernateTemplate
				.find("from com.meeting.vo.Meeting");
		for (int i = 0; i < list.size(); i++) {
			Meeting u = new Meeting();
			u = (Meeting) list.get(i);

			use.add(u);
		}
		return use;
	}

	@Override
	public Meeting find_one(String str) {
		// TODO Auto-generated method stub
		java.util.List list = hibernateTemplate.find(str);
		Meeting u = new Meeting();
		u = (Meeting) list.get(0);
		return u;
	}

	public ArrayList<Meeting> find_list(String str) {
		// TODO Auto-generated method stub
		java.util.List list = hibernateTemplate.find(str);
		ArrayList<Meeting> meet = new ArrayList<Meeting>();
		Meeting m = new Meeting();
		for (int i = 0; i < list.size(); i++) {

			m = (Meeting) list.get(i);

			meet.add(m);
		}

		return meet;
	}

	@Override
	public void modify(Meeting meeting) {
		// TODO Auto-generated method stub
		hibernateTemplate.update(meeting);

	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

}
