package com.meeting.action;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;

import com.meeting.service.DeleteDepartmentService;
import com.meeting.service.Department_transf;
import com.meeting.vo.Department;
import com.opensymphony.xwork2.ActionSupport;

public class DeleteDepartmentAction extends ActionSupport {
	
	private String user;
	
	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	/**
	 * @return
	 * @throws IOException 
	 */
	public String execute() throws IOException {
		// TODO Auto-generated method stub
		ArrayList<Department_transf> tran;
		ServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		DeleteDepartmentService show=new DeleteDepartmentService();
		tran=show.ShowService();
		JSONArray jsonArray = JSONArray.fromObject(tran);
		out.print(jsonArray);
		return null;
	}
	
	public String delete_d(){
		if(!user.equals(null)){
			DeleteDepartmentService de=new DeleteDepartmentService();
			de.DeleteDepartment(user);
		}
		return "suc";
	}
}