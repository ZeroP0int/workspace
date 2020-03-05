package com.icss.Snack.entity;

public class Account {

	private int account_id;//账号编号，主键，自动增长
	private int uid;//用户编号，外键
	private double money;//账户金额
	public int getAccount_id() {
		return account_id;
	}
	public void setAccount_id(int account_id) {
		this.account_id = account_id;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	
	
}
