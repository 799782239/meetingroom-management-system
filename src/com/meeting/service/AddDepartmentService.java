package com.meeting.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.meeting.dao.add_pesron;
import com.meeting.dao.modify_person;
import com.meeting.dao.search_people;
import com.meeting.vo.Department;
import com.meeting.vo.User;

public class AddDepartmentService {
	Department d=new Department();
	User m=new User();
	
	public boolean Check_d_name(String name){
		boolean flag=false;
		String class_name="Department";
		String search="name";
		search_people se=new search_people();
		d=(Department) se.search_people(class_name, search, name);
		if(d==null){
			 flag=true;
		}else{
			flag=false;
		}
		return flag;
	}
	
	
public boolean Check_person(String name){
		String class_name="User";
		String search="name";
		search_people se=new search_people();
		m=(User) se.search_people(class_name, search, name);
		if(m==null){
			return true;
		}else{
			return false;
		}
	}

	public void add_department(String dname,String maxnum,String person){
		Date date=new Date();
		d.setName(dname);
		d.setBuilddata(date);
		d.setNumberLimit(Integer.valueOf(maxnum));
		d.setEmployeelist(person);
		add_pesron add=new add_pesron(d);
		//修改添加部门导致的人事变动信息
		String class_name="User";
		String search="name";
		search_people s=new search_people();
		m=(User)s.search_people(class_name, search, person);
		m.setDepartment(dname);
		m.setJob("经理");
		modify_person md=new modify_person();
		md.modify_person(m);
	}
}
