package com.icss.Snack.entity;

import java.util.List;

public class Flavor  {
	private int fid;//��ζ��ţ��������Զ�����
	private String fname;//��ζ����
	private int stock;//���
	private int commodity_id;
	public int getFid() {
		return fid;
	}
	public void setFid(int fid) {
		this.fid = fid;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public int getCommodity_id() {
		return commodity_id;
	}
	public void setCommodity_id(int commodity_id) {
		this.commodity_id = commodity_id;
	}
	
	

}
