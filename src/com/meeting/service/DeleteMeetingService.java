package com.meeting.service;

import com.meeting.dao.delete_person;


public class DeleteMeetingService {
	private String id;

	public DeleteMeetingService(String id) {
		// TODO Auto-generated constructor stub
		this.id = id;
	}

	public void Delete() {
		delete_person delete = new delete_person("Meeting", "id", id);
	}
}
