package com.meeting.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import net.sf.json.JSONArray;

import org.apache.struts2.ServletActionContext;

import com.meeting.vo.User;
import com.meeting.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

public class personDelActioin extends ActionSupport {
	ArrayList<User> u = new ArrayList<User>();
	private UserService userService;

	public String execute() throws Exception {
		ServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		u = userService.personDelService();
		JSONArray jsonArray = JSONArray.fromObject(u);
		System.out.println(jsonArray.toString());
		out.print(jsonArray);
		return null;

	}

	public String persondelete() throws IOException {
		String workId;
		ServletResponse response = ServletActionContext.getResponse();
		PrintWriter out = response.getWriter();
		ServletRequest request = ServletActionContext.getRequest();
		workId = request.getParameter("workId");
		userService.personDeleteService(workId);
		return null;

	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

}
