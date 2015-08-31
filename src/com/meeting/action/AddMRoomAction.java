package com.meeting.action;
import java.io.IOException;
import java.io.PrintWriter;

import javax.enterprise.inject.New;
import javax.servlet.ServletResponse;

import org.apache.struts2.ServletActionContext;

import com.meeting.dao.add_pesron;
import com.meeting.service.FindMRoomService;
import com.meeting.vo.MeetingRoom;
import com.opensymphony.xwork2.ActionSupport;

public class AddMRoomAction extends ActionSupport {
	
	private String room;
	private String area;
	private String position;
	
	
	public String getRoom() {
		return room;
	}


	public void setRoom(String room) {
		this.room = room;
	}


	public String getArea() {
		return area;
	}


	public void setArea(String area) {
		this.area = area;
	}


	public String getPosition() {
		return position;
	}


	public void setPosition(String position) {
		this.position = position;
	}


	/**
	 * @return
	 * @throws IOException 
	 */
	public String execute() throws IOException {
		// TODO Auto-generated method stub
		//System.out.print(room);
		ServletResponse response=ServletActionContext.getResponse();
		PrintWriter outPrintWriter=response.getWriter();
		FindMRoomService fm=new FindMRoomService();
		boolean result=fm.FindResult(room);
		outPrintWriter.print(result);
		return null;
	}
	public String set_in() throws IOException{
	//	ServletResponse response=ServletActionContext.getResponse();
	//	PrintWriter out=response.getWriter();
	//	response.setCharacterEncoding("utf-8");
		MeetingRoom mr=new MeetingRoom();
		mr.setName(room);
		mr.setMaxNumber(Integer.valueOf(area));
		mr.setLocal(position);
		add_pesron a=new add_pesron(mr);
	//	out.flush();
	//	out.close();
		return "suc";
	}
}