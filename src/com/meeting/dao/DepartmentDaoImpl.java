package com.meeting.dao;

import java.util.ArrayList;

import org.springframework.orm.hibernate3.HibernateTemplate;

import com.meeting.vo.Department;
import com.meeting.vo.Meeting;

public class DepartmentDaoImpl implements DepartmentDao {
	private HibernateTemplate hibernateTemplate;

	public void add(Department department) {
		// TODO Auto-generated method stub
		hibernateTemplate.save(department);

	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public void delete(Department department) {
		// TODO Auto-generated method stub
		hibernateTemplate.delete(department);

	}

	public void modify(Department department) {
		// TODO Auto-generated method stub
		hibernateTemplate.update(department);

	}

	public Department find_one(String str) {
		// TODO Auto-generated method stub
		java.util.List list = hibernateTemplate.find(str);
		Department u = new Department();
		u = (Department) list.get(0);
		return u;
	}

	public ArrayList<Department> find_class() {
		// TODO Auto-generated method stub
		ArrayList<Department> use = new ArrayList<Department>();

		java.util.List list = hibernateTemplate
				.find("from com.meeting.vo.Department");
		for (int i = 0; i < list.size(); i++) {
			Department u = new Department();
			u = (Department) list.get(i);

			use.add(u);
		}
		return use;
	}

}
