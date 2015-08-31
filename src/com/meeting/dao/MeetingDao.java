package com.meeting.dao;

import java.util.ArrayList;

import com.meeting.vo.Meeting;


public interface MeetingDao {
	void add(Meeting meeting);
	void delete(Meeting meeting);
	void modify(Meeting meeting);
	Meeting find_one(String str);
	ArrayList<Meeting> find_class();
	ArrayList<Meeting> find_list(String str);

}
