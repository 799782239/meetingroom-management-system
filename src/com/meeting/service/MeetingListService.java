package com.meeting.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.meeting.dao.search_people;
import com.meeting.vo.Meeting;

public class MeetingListService {
	private String time;
	private search_people search = new search_people();
	private List<Meeting> MeetingList = new ArrayList<Meeting>();
	private List<MyMeeting> MyMeetingList = new ArrayList<MyMeeting>();

	public MeetingListService(String time) {
		// TODO Auto-generated constructor stub
		this.time = time;
	}

	public List<MyMeeting> GetMeetingList() {
		ArrayList<Object> objectlist = new ArrayList<Object>();
		objectlist = search.serach("Meeting", "state", "true");

		for (int i = 0; i < objectlist.size(); i++) {
			Meeting meeting = (Meeting) objectlist.get(i);
			MeetingList.add(meeting);
		}

		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		DateFormat timeFormat = new SimpleDateFormat("HH");

		for (int i = 0; i < MeetingList.size(); i++) {
			String DBDate = dateFormat.format(MeetingList.get(i).getData());
			String DBTime = timeFormat.format(MeetingList.get(i).getData());
			if (time.equals(DBDate)) {
				MyMeeting meeting = new MyMeeting();
				meeting.setDate(DBDate);
				meeting.setRoom(MeetingList.get(i).getRoom());
				meeting.setTime(DBTime);
				MyMeetingList.add(meeting);

				int estimate_time = MeetingList.get(i).getEstimateTime();
				for (int k = 0; k < estimate_time - 1; k++) {
					int newTime = Integer.valueOf(DBTime);
					newTime = newTime + k + 1;
					MyMeeting newmeeting = new MyMeeting();
					newmeeting.setDate(DBDate);
					newmeeting.setRoom(MeetingList.get(i).getRoom());
					newmeeting.setTime(String.valueOf(newTime));
					MyMeetingList.add(newmeeting);
				}
			}
		}
		return MyMeetingList;
	}
}
