package com.icss.Snack.entity;

import java.sql.Timestamp;

public class Evaluate {
	private int eid;//编号，逐渐自动增长
	private int uid;//用户编号（外键）
	private String oid;//订单编号（外键）
	private Timestamp createtime;//评论时间
	private String content;//内容
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getOid() {
		return oid;
	}
	public void setOid(String oid) {
		this.oid = oid;
	}
	public Timestamp getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Timestamp createtime) {
		this.createtime = createtime;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
}
