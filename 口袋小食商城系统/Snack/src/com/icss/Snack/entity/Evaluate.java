package com.icss.Snack.entity;

import java.sql.Timestamp;

public class Evaluate {
	private int eid;//��ţ����Զ�����
	private int uid;//�û���ţ������
	private String oid;//������ţ������
	private Timestamp createtime;//����ʱ��
	private String content;//����
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
