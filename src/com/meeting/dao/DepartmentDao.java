package com.meeting.dao;

import java.util.ArrayList;

import com.meeting.vo.Department;
import com.meeting.vo.Meeting;

public interface DepartmentDao {
	void add(Department department);
	void delete(Department department);
	void modify(Department department);
	Department find_one(String str);
	ArrayList<Department> find_class();

}
