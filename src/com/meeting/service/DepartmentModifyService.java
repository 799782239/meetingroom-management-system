package com.meeting.service;

import java.util.ArrayList;
import java.util.List;

import com.meeting.dao.modify_person;
import com.meeting.dao.search_people;
import com.meeting.vo.Department;
import com.meeting.vo.User;

public class DepartmentModifyService {
	private String workId;
	private String department;
	
	public DepartmentModifyService(){
		
	}
	
	public DepartmentModifyService(String workId, String department) {
		// TODO Auto-generated constructor stub
		this.workId = workId;
		this.department = department;
	}

	public void DepartmentModify() {
		search_people search = new search_people();
		User user = (User) search.search_people("User", "workId", workId);
		user.setDepartment(department);
		modify_person modify = new modify_person();
		modify.modify_person(user);
	}
	
	public List<Department> getDepartmentList(){
		search_people search=new search_people();
		List<Object> ObjectDepartmentList = new ArrayList<Object>();
		List<Department> departmentList = new ArrayList<Department>();
		ObjectDepartmentList = search.search("Department");
		for (int i = 0; i < ObjectDepartmentList.size(); i++) {
			Department department = (Department) ObjectDepartmentList.get(i);
			departmentList.add(department);
		}
		return departmentList;
	}
	
	public List<User> getUserList(String Department) {
		ArrayList<Object> objectlist = new ArrayList<Object>();
		List<User> userList = new ArrayList<User>();
		search_people search=new search_people();
		objectlist = search.serach("User", "department", Department);
		for (int i = 0; i < objectlist.size(); i++) {
			User user = (User) objectlist.get(i);
			userList.add(user);
		}
		return userList;
	}
}
