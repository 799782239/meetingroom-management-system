package com.meeting.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;









import net.sf.json.JSONArray;

import org.apache.struts2.ServletActionContext;

import com.meeting.service.DepartmentModifyService;
import com.meeting.vo.Department;
import com.meeting.vo.User;
import com.opensymphony.xwork2.ActionSupport;

public class ModifyDepartmentPerson {
	private static final long serialVersionUID = 1L;
	private String workId;
	private String department;
	
	public ModifyDepartmentPerson() {
		// TODO Auto-generated constructor stub
	}

	public String execute() throws Exception {
		// TODO Auto-generated method stub
		ServletRequest request = ServletActionContext.getRequest();
		workId = request.getParameter("workId");
		department = request.getParameter("department");
		String Id[] = workId.split(":");
		System.out.println(Id[1]);
		System.out.println(department);

		DepartmentModifyService service = new DepartmentModifyService(Id[1], department);
		service.DepartmentModify();
		
		ServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		out.print("success");
		return null;
	}
	
	public String list() throws IOException{
		List<Department> departmentList = new ArrayList<Department>();
		DepartmentModifyService departmentService = new DepartmentModifyService();
		departmentList = departmentService.getDepartmentList();
		
		ServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		out.print(JSONArray.fromObject(departmentList));
		return null;
		
	}

	public String userlist() throws IOException{
		String Department;
		List<User> UserList = new ArrayList<User>();
		ServletRequest request = ServletActionContext.getRequest();
		Department = request.getParameter("Department");
		System.out.println(Department);
		DepartmentModifyService userListService = new DepartmentModifyService();
		UserList = userListService.getUserList(Department);
		ServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		out.print(JSONArray.fromObject(UserList));
		return null;
	}
}
