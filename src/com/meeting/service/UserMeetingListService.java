package com.meeting.service;

import java.util.ArrayList;
import java.util.List;

import com.meeting.dao.search_people;
import com.meeting.vo.Meeting;

public class UserMeetingListService {
	private search_people search = new search_people();
	private List<Meeting> UserMeetingList = new ArrayList<Meeting>();
	private String WorkID;

	public UserMeetingListService(String WorkID) {
		// TODO Auto-generated constructor stub
		this.WorkID = WorkID;
	}

	public List<Meeting> GetUserMeetingList() {
		ArrayList<Object> objectlist = new ArrayList<Object>();
		objectlist = search.serach("Meeting", "state", "true");
		for (int i = 0; i < objectlist.size(); i++) {
			Meeting meeting = (Meeting) objectlist.get(i);
			String users = meeting.getUsers();
			if (users.indexOf(WorkID) != -1) {
				UserMeetingList.add(meeting);
			}
		}
		return UserMeetingList;
	}
}
