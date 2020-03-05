package com.icss.Snack.entity;

import java.sql.Timestamp;

public class User {

	private int uid;//用户编号，主键，自动增长
	private String username;//登陆账号
	private String password;//登陆密码
	private String phone;//手机号
	private String sex;//性别
	private String email;//邮箱
	private String user_name;
	
	private Timestamp regtime;//注册时间
	private int account_id;//账号编号（外键）
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String i) {
		this.email = i;
	}
	public Timestamp getRegtime() {
		return regtime;
	}
	public void setRegtime(Timestamp regtime) {
		this.regtime = regtime;
	}
	public int getAccout_id() {
		return account_id;
	}
	public void setAccout_id(int string) {
		this.account_id = string;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	
}
