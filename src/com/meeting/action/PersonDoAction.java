package com.meeting.action;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import net.sf.json.JSONArray;

import org.apache.struts2.ServletActionContext;

import com.meeting.service.PersonService;
import com.meeting.vo.User;
import com.opensymphony.xwork2.ActionSupport;

public class PersonDoAction extends ActionSupport {
	ArrayList<User> u=new ArrayList<User>();

	public String execute() throws Exception {
		ServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		PersonService m=new PersonService();
		u = m.ListpersonService();
		JSONArray jsonArray = JSONArray.fromObject(u);
		out.print(jsonArray);
		return null;

	}
	
	public String persondelete() throws IOException{
		String workId;
		ServletResponse response = ServletActionContext.getResponse();
		PrintWriter out = response.getWriter();
		ServletRequest request = ServletActionContext.getRequest();
		workId = request.getParameter("workId");
		PersonService pd=new PersonService();
		pd.personDeleteService(workId);
		return null;
		
	}
	
	public String checklist() throws IOException{
		ServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		PersonService m=new PersonService();
		u = m.personCheckService();
		
		JSONArray jsonArray = JSONArray.fromObject(u);
		System.out.println(jsonArray.toString());
		out.print(jsonArray);
		return null;
		
	}

	public String change_t() throws IOException{
		ServletRequest request = ServletActionContext.getRequest();
		String workId = request.getParameter("workId");
		PersonService m=new PersonService();
		m.personChangeStateTrue(workId);
		return null;
	}

	public String change_f() throws IOException{
		ServletRequest request = ServletActionContext.getRequest();
		String workId = request.getParameter("workId");
		PersonService pd=new PersonService();
		pd.personDeleteService(workId);
		return null;
	}
}
