package com.meeting.dao;

import java.util.ArrayList;

import org.springframework.orm.hibernate3.HibernateTemplate;

import com.meeting.vo.MeetingRoom;
import com.meeting.vo.User;

public class MeetingRoomDaoImpl implements MeetingRoomDao {
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Override
	public void add(MeetingRoomDao meetingRoomDao) {
		// TODO Auto-generated method stub
		hibernateTemplate.save(meetingRoomDao);

	}

	@Override
	public void delete(MeetingRoomDao meetingRoomDao) {
		// TODO Auto-generated method stub
		hibernateTemplate.delete(meetingRoomDao);

	}

	@Override
	public void modify(MeetingRoomDao meetingRoomDao) {
		// TODO Auto-generated method stub
		hibernateTemplate.update(meetingRoomDao);

	}

	@Override
	public MeetingRoom find_one(String str) {
		// TODO Auto-generated method stub
		java.util.List list = hibernateTemplate.find(str);
		MeetingRoom u=new MeetingRoom();
		u = (MeetingRoom) list.get(0);
		return u;
	}

	@Override
	public ArrayList<MeetingRoom> find_class() {
		// TODO Auto-generated method stub
		ArrayList<MeetingRoom> use = new ArrayList<MeetingRoom>();

		java.util.List list = hibernateTemplate
				.find("from com.meeting.vo.MeetingRoom");
		for (int i = 0; i < list.size(); i++) {
			MeetingRoom u = new MeetingRoom();
			u = (MeetingRoom) list.get(i);

			use.add(u);
		}
		return use;
	}

}
