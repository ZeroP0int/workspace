package com.icss.Snack.entity;

import java.util.List;

public class Address {
	private int address_id;//��ַ��ţ��������Զ�����
	private int uid;//�û���ţ������
	private String full_address;//��ϸ��ַ
	private String phone;//��ϵ�绰
	private String zip_code;//�ʱ�
	private String name;//��ϵ������
	private int state;//״̬ 1��Ĭ�� 0����Ĭ��
	public int getAddress_id() {
		return address_id;
	}
	public void setAddress_id(int address_id) {
		this.address_id = address_id;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getFull_address() {
		return full_address;
	}
	public void setFull_address(String full_address) {
		this.full_address = full_address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getZip_code() {
		return zip_code;
	}
	public void setZip_code(String zip_code) {
		this.zip_code = zip_code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	

}
