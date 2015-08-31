package com.meeting.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import net.sf.json.JSONArray;

import org.apache.struts2.ServletActionContext;

import com.meeting.service.MeetingListService;
import com.meeting.service.MeetingToDBService;
import com.meeting.service.MyMeeting;
import com.meeting.vo.Meeting;
import com.meeting.vo.MeetingRoom;
import com.opensymphony.xwork2.ActionSupport;

public class MeetingToDBAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String execute() throws Exception {
		ServletRequest request = ServletActionContext.getRequest();
		String title = request.getParameter("title");
		String speaker = request.getParameter("speaker");
		String estimate_time = request.getParameter("estimate_time");
		String level = request.getParameter("level");
		String content = request.getParameter("content");
		String booker = request.getParameter("booker");
		String users = request.getParameter("users");
		String room = request.getParameter("room");
		String data = request.getParameter("data");
		
		String newdata = data;
		String MyDate[] = newdata.split("&");
		String MyTime[] = MyDate[0].split("/");
		Calendar calendar = Calendar.getInstance();
		calendar.set(Integer.valueOf(MyTime[0]), Integer.valueOf(MyTime[1])-1, Integer.valueOf(MyTime[2]), Integer.valueOf(MyDate[1]), 0);
		Date bookDate = calendar.getTime();
		Timestamp ts = new Timestamp(bookDate.getTime());
		
		Date currentate = new Date();
		Timestamp currentTs = new Timestamp(currentate.getTime());
		
		Meeting meeting = new Meeting();
		meeting.setData(ts);
		meeting.setBooker(booker);
		meeting.setBooktime(currentTs);
		meeting.setEstimateTime(Integer.valueOf(estimate_time));
		meeting.setContent(content);
		meeting.setLevel(Integer.valueOf(level));
		meeting.setRoom(room);
		meeting.setSpeaker(speaker);
		meeting.setState("true");
		meeting.setTitle(title);
		meeting.setUsers(users);
		
		MeetingToDBService service = new MeetingToDBService(meeting);
		String result = service.ToDB();
		ServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		out.print(result);
		return null;
	}

	public String listroom() throws IOException{
		List<MeetingRoom> RoomList = new ArrayList<MeetingRoom>();
		MeetingToDBService service = new MeetingToDBService();
		RoomList = service.GetRoomList();
		
		//JSON json = JSONSerializer.toJSON(RoomList);
		JSONArray.fromObject(RoomList);
		ServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		out.print(JSONArray.fromObject(RoomList));
		return null;
	}

	public String listmeeting() throws IOException{
		ServletRequest request = ServletActionContext.getRequest();
		String Date = request.getParameter("Date");
		List<MyMeeting> MyMeetingList = new ArrayList<MyMeeting>();
		MeetingListService service = new MeetingListService(Date);
		MyMeetingList = service.GetMeetingList();
		
		//JSON json = JSONSerializer.toJSON(MyMeetingList);
		//JSONArray.fromObject(MyMeetingList);
		ServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		out.print(JSONArray.fromObject(MyMeetingList));
		return null;
	}
}
