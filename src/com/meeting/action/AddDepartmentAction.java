package com.meeting.action;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.meeting.service.AddDepartmentService;
import com.opensymphony.xwork2.ActionSupport;

public class AddDepartmentAction extends ActionSupport {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private String maxnum;
	private String D_manager;
	private AddDepartmentService fun=new AddDepartmentService();
	
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getMaxnum() {
		return maxnum;
	}


	public void setMaxnum(String maxnum) {
		this.maxnum = maxnum;
	}


	public String getD_manager() {
		return D_manager;
	}


	public void setD_manager(String d_manager) {
		D_manager = d_manager;
	}


	/**
	 * @return
	 */
	public String execute() {
		// TODO Auto-generated method stub
		fun.add_department(name, maxnum, D_manager);
		return "suc";
	}
	
	public String Derpart_check() throws IOException{
		boolean flag=false;
		ServletResponse response=ServletActionContext.getResponse();
		PrintWriter out=response.getWriter();
		flag=fun.Check_d_name(name);
		out.print(flag);
		return null;
	}
	
	public String Manager_check() throws IOException{
		boolean flag=false;
		ServletResponse response=ServletActionContext.getResponse();
		PrintWriter out=response.getWriter();
		flag=fun.Check_person(D_manager);
		//System.out.print(flag);
		out.print(flag);
		out.flush();
		out.close();
		return null;
	}
}