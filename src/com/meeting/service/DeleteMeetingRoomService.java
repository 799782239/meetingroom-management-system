package com.meeting.service;

import java.util.ArrayList;

import com.meeting.dao.delete_person;
import com.meeting.dao.search_people;
import com.meeting.vo.MeetingRoom;

public class DeleteMeetingRoomService {
	
	ArrayList<Object> obj = new ArrayList<Object>();
	ArrayList<MeetingRoom> list=new ArrayList<MeetingRoom>();
	
	public ArrayList<MeetingRoom> Showlist() {
		// TODO Auto-generated constructor stub
		search_people s=new search_people();
		obj = s.search("MeetingRoom");
		for (int i = 0; i < obj.size(); i++) {
			MeetingRoom mroom=new MeetingRoom();
			mroom = (MeetingRoom) obj.get(i);
			list.add(mroom);
		}
		return list;
	}
	
	public void DeleteMeetingRoom(String mrname){
		delete_person de=new delete_person("MeetingRoom", "name", mrname);
		search_people se=new search_people();
		obj=se.serach("Meeting", "room", mrname);
		if(obj!=null){
			for(int i=0;i<obj.size();i++){
				delete_person another_de=new delete_person("Meeting", "room", mrname);
			}
		}
	}
}
