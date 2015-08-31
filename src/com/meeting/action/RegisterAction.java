package com.meeting.action;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.meeting.service.FindPswService;
import com.meeting.service.RegisterService;
import com.meeting.vo.User;
import com.opensymphony.xwork2.ActionSupport;

public class RegisterAction extends ActionSupport {

	private String username;
	private String sex;
	private String password;
	private int age;
	private String email;
	private String phone;
	private int number;
	private int find_work_number;
	private String find_phone; 
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
	
	

	public int getFind_work_number() {
		return find_work_number;
	}

	public void setFind_work_number(int find_work_number) {
		this.find_work_number = find_work_number;
	}

	public String getFind_phone() {
		return find_phone;
	}

	public void setFind_phone(String find_phone) {
		this.find_phone = find_phone;
	}

	/**
	 * @return
	 * @throws IOException 
	 */
	public String execute() throws IOException {
		// TODO Auto-generated method stub
		
		FindPswService f=new FindPswService();
		ServletResponse response=ServletActionContext.getResponse();
		PrintWriter out=response.getWriter();
		response.setCharacterEncoding("UTF-8");
		String psw=null;
		//System.out.println(find_work_number+find_phone);
		if(f.check(find_work_number, find_phone)){
			psw=f.getFindrs();
			//System.out.print("n");
			out.print("you password is："+psw+" please remember it!");
		}else{
			out.print("We can't find the information!please check you input!");
		}
		return null;
	}

	public String find() throws IOException{
		User user=new User();
		user.setName(username);
		user.setSex(sex);
		user.setAge(age);
		user.setPassword(password);
		user.setEMail(email);
		user.setPhone(phone);
		user.setWorkId(number);
		user.setDepartment("无");
		user.setJob("员工");
		user.setState("false");
		RegisterService ra=new RegisterService();
		ra.Do_Add(user);
	//	HttpServletRequest request=null;
		//request.setAttribute("msg", "<script>alert('添加成功!!');</script>");
		return "add";
	}
}