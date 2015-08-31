package com.meeting.action;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONSerializer;

import org.apache.struts2.ServletActionContext;

import com.meeting.service.DeleteMeetingService;
import com.meeting.service.LoginService;
import com.meeting.service.ModifyPersonService;
import com.meeting.service.MyUserMeeting;
import com.meeting.service.UserMeetingListService;
import com.meeting.service.updatePsersonService;
import com.meeting.vo.Meeting;
import com.meeting.vo.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {

	/**
	 * @return
	 */
	private String user;
	private String psw;
	private LoginService ls=new LoginService();
	
	
	public String getUser() {
		return user;
	}


	public void setUser(String user) {
		this.user = user;
	}


	public String getPsw() {
		return psw;
	}


	public void setPsw(String psw) {
		this.psw = psw;
	}


	public String execute() {
		// TODO Auto-generated method stub
		if(ls.check(user, psw)){
			ActionContext context=ActionContext.getContext();
			Map session=context.getSession();
			session.put("workid", user);
			return "suc";
		}else{
			return "fail";
		}
	}
	
	public String after() throws IOException{
		User us=new User();
		ServletResponse response = ServletActionContext.getResponse();
		PrintWriter out = response.getWriter();
		ServletRequest request = ServletActionContext.getRequest();
		String workId = request.getParameter("workId");
		ModifyPersonService m = new ModifyPersonService();
		us = m.ModifyPersonService(workId);
		System.out.println(us.getWorkId());
		JSONArray jsonArray = JSONArray.fromObject(us);
		System.out.println(jsonArray.toString());
		out.print(jsonArray);
		
		return null;
	}
	
	public String modify() throws IOException{
		ServletResponse response = ServletActionContext.getResponse();
		PrintWriter out = response.getWriter();
		ServletRequest request = ServletActionContext.getRequest();
		String content = request.getParameter("content");
		String flag = request.getParameter("flag");
		String workId = request.getParameter("workId");
		updatePsersonService u=new updatePsersonService(workId,flag,content);

		return null;
	}
	
	public String myMeeting() throws IOException{
		ServletRequest request = ServletActionContext.getRequest();
		String WorkID = request.getParameter("WorkID");
		List<Meeting> UserMeetingList = new ArrayList<Meeting>();

		UserMeetingListService service = new UserMeetingListService(WorkID);
		UserMeetingList = service.GetUserMeetingList();

		List<MyUserMeeting> list = new ArrayList<MyUserMeeting>();

		for (int i = 0; i < UserMeetingList.size(); i++) {
			MyUserMeeting userMeetingVO = new MyUserMeeting();
			userMeetingVO.setId(UserMeetingList.get(i).getId());
			userMeetingVO.setRoom(UserMeetingList.get(i).getRoom());
			userMeetingVO.setTitle(UserMeetingList.get(i).getTitle());

			String tsStr = "";
			DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			tsStr = sdf.format(UserMeetingList.get(i).getData());
			userMeetingVO.setTime(tsStr);

			list.add(userMeetingVO);
		}
		JSON json = JSONSerializer.toJSON(list);
		ServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		//System.out.println(json.toString());
		out.print(json.toString());
		return null;
	}
	public String meetingdelete() throws IOException{
		ServletRequest request = ServletActionContext.getRequest();
		String meetingID = request.getParameter("id");
		
		DeleteMeetingService service = new DeleteMeetingService(meetingID);
		service.Delete();
		
		ServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		out.print("success");
		return null;
	}
}