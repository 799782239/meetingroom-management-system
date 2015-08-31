package com.meeting.service;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.meeting.dao.delete_person;
import com.meeting.dao.modify_person;
import com.meeting.dao.search_people;
import com.meeting.vo.Department;
import com.meeting.vo.User;

public class DeleteDepartmentService {
	ArrayList<Object> obj = new ArrayList<Object>();
	//ArrayList<Department> de = new ArrayList<Department>();
	ArrayList<Department_transf> de=new ArrayList<Department_transf>();
	
	public ArrayList<Department_transf> ShowService() {
		// TODO Auto-generated constructor stub
		Department department = new Department();
		search_people s=new search_people();
		Date date=new Date();
		DateFormat formt=new SimpleDateFormat("yyyy/MM/dd");
		obj = s.search("Department");
		for (int i = 0; i < obj.size(); i++) {
			Department_transf tran= new Department_transf();
			department = (Department) obj.get(i);
			tran.setId(department.getId());
			tran.setName(department.getName());
			tran.setNumberLimit(department.getNumberLimit());
			tran.setEmployeelist(department.getEmployeelist());
			date=department.getBuilddata();
			tran.setBuilddata(formt.format(date));
			de.add(tran);
		}
		return de;
	}
	
	public void DeleteDepartment(String name){
		String class_name="User";
		String search="department";
		modify_person mo=new modify_person();
		search_people se=new search_people();
		delete_person de=new delete_person("Department", "name", name);
		obj=se.serach(class_name, search, name);
		if(obj!=null){
			for(int i=0;i<obj.size();i++){
				User u=new User();
				u=(User) obj.get(i);
				u.setDepartment(null);
				mo.modify_person(u);
			}
		}
	}
}
