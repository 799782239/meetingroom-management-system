package com.meeting.service;

import com.meeting.dao.search_people;
import com.meeting.vo.MeetingRoom;

public class FindMRoomService {
	MeetingRoom mr=new MeetingRoom();
	
	public boolean FindResult(String r_n){
		String class_name="MeetingRoom";
		String search="name";
		boolean result=false;
		search_people s=new search_people();
		mr=(MeetingRoom)s.search_people(class_name, search, r_n);
		if(mr==null){
			result=true;
		}else{
			result=false;
		}
		return result;
	}
}
