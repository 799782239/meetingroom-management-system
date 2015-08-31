package com.meeting.dao;

import java.util.ArrayList;

import com.meeting.vo.MeetingRoom;
import com.meeting.vo.User;

public interface MeetingRoomDao {
	void add(MeetingRoomDao meetingRoomDao);
	void delete(MeetingRoomDao meetingRoomDao);
	void modify(MeetingRoomDao meetingRoomDao);
	MeetingRoom find_one(String str);
	ArrayList<MeetingRoom> find_class();
}
