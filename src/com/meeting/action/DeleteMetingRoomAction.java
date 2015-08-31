package com.meeting.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletResponse;

import net.sf.json.JSONArray;

import org.apache.struts2.ServletActionContext;

import com.meeting.service.DeleteDepartmentService;
import com.meeting.service.DeleteMeetingRoomService;
import com.meeting.service.Department_transf;
import com.meeting.vo.MeetingRoom;
import com.opensymphony.xwork2.ActionSupport;

public class DeleteMetingRoomAction extends ActionSupport{
	
	private String roomnum;
	
	
	public String getRoomnum() {
		return roomnum;
	}


	public void setRoomnum(String roomnum) {
		this.roomnum = roomnum;
	}


	public String execute() throws IOException{
		ArrayList<MeetingRoom> tran;
		ServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		DeleteMeetingRoomService show=new DeleteMeetingRoomService();
		tran=show.Showlist();
		JSONArray jsonArray = JSONArray.fromObject(tran);
		out.print(jsonArray);
		return null;
	}
	
	public String delete_mr(){
		DeleteMeetingRoomService del=new DeleteMeetingRoomService();
		if(!roomnum.equals(null)){
			del.DeleteMeetingRoom(roomnum);
		}
		return "suc";
	}
}
