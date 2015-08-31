package com.meeting.service;

import java.util.ArrayList;
import java.util.List;

import com.meeting.dao.add_pesron;
import com.meeting.dao.search_people;
import com.meeting.vo.Meeting;
import com.meeting.vo.MeetingRoom;

public class MeetingToDBService {
private Meeting meeting = new Meeting();

	public MeetingToDBService(){
		
	}
	
	public MeetingToDBService(Meeting meeting) {
		// TODO Auto-generated constructor stub
		this.meeting = meeting;
	}

	public String ToDB() {
		add_pesron add = new add_pesron(meeting);
		return "success";
	}
	
	public List<MeetingRoom> GetRoomList() {
		List<MeetingRoom> RoomList = new ArrayList<MeetingRoom>();
		search_people search=new search_people();
		List<Object> ObjectRoomList = new ArrayList<Object>();
		ObjectRoomList = search.search("MeetingRoom");
		for (int i = 0; i < ObjectRoomList.size(); i++) {
			MeetingRoom room = (MeetingRoom) ObjectRoomList.get(i);
			RoomList.add(room);
		}
		return RoomList;
	}
}
